package com.gestion_contact.Controllers;

import com.gestion_contact.Entities.Contact;
import com.gestion_contact.Entities.Groupe;
import com.gestion_contact.Servies.ContactService;
import com.gestion_contact.Servies.GroupeService;
import com.gestion_contact.Servies.Interface.IContactService;
import com.gestion_contact.Servies.Interface.IGroupeService;
import com.gestion_contact.utils.CookieManager;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

// la classe qui représente le controlleur principale
@Controller
@RequestMapping("/")
public class ContactController {
    // l'injection automatique d'une instance de ContactService
    @Autowired
    private IContactService contactService;

    // l'injection automatique d'une instance de GroupeService
    @Autowired
    private IGroupeService groupeService;


    // le chemin principal :/
    @RequestMapping({"/"})
    public String getPrincipalView(Model model) {
        // extraire tous les contact par ordre de Nom et les ajoute dans le model
        List<Contact> contacts = contactService.getAllContactByOrder();
        model.addAttribute("contacts", contacts);
        // on renvoie le view jsp prinicipale
        return "add";
    }

    // la requete qui permet l'ajout d'un contact
    @PostMapping("/addcontact")
    // on recoit l'objet contact depuis la formulaire d'ajout de contact formadd.jsp à l'aide de l'annotation @ModelAttribute
    public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult, Model model, HttpServletResponse response) {
        // si il y'a des erreurs lors de l'envoit de la formulaire on doit afficher les messages d'erreur dans le formualaire.
        // cepandant j'ai travaillé avec les Modals dans Bootstrap donc,il faut que lorsque on retourne le View principale le Modal (formulaire) s'affiche
        // automatiquement donc j'ai utilisé un cookie qui permet d'informer la partie Front (Javascript) d'afficher le Modal ou bien surgir le Modal qui contient
        // le formualaire lorsque il y'a d'erreur.
        if (bindingResult.hasErrors()) {
            // on créer un Cookie et on l'ajout à la réponse de la requette HTTP
            CookieManager.createCookie("modalShownadd", "true", response);
            // on renvoi le View, à ce momoent la Modal va surgir automatiquement.
            return "add";
        }

        // sinon si le cookie existe déja on doit le supprimé, pour que le Modal ne surgit pas
        CookieManager.deleteCookie(response, "modalShownadd");

        // on crée un contact
        contactService.create(contact);
        // on ajoute un message pour l'information
        model.addAttribute("message", contact.getNom() + " " + contact.getPrenom() + " est bien ajoutée à la base de données");
        // on fait une redirection au niveau serveur à ":/" pour qu'il met à jour la liste de contact et renvoi la view principale
        return "forward:/";
    }

    // on recoit l'id de contact on url
    @GetMapping("/deletecontact/{id_contact}")
    public String deleteContact(@PathVariable("id_contact") Long id_contact, HttpServletRequest request, Model model) {
        // on cherche premièrment le contact pour présérver ses informations (nom,prenom,telephoen) pour le transférer au view après.
        Contact contact = contactService.findContactById(id_contact);
        String nom = contact.getNom();
        String prenom = contact.getPrenom();
        String tele = contact.getTelephone1();
        // on supprime le contact
        contactService.deleteContact(id_contact);
        //on ajoute un message juste pour informer l'utilisateur
        model.addAttribute("message", String.format("le contact  %s %s / %s est bien supprimé ", nom, prenom, tele));
        return "forward:/";
    }


    // la méthode de la modification d'un conctact à le meme principe que l'ajout d'un contact
    // concernant la validation des informations envoyées et aussi concernant la surgissement de la (Modal) formulaire
    @PostMapping("/modifiercontact")
    public String modifiercontact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {

            /*Cookie cookie = new Cookie("modalShownupdate", "true");
            response.addCookie(cookie);*/

            CookieManager.createCookie("modalShownupdate", "true", response);
            return "add";
        }

       /* Cookie cookie = new Cookie("modalShownupdate", null);
        response.addCookie(cookie);*/

        CookieManager.deleteCookie(response, "modalShownupdate");

        contactService.updateContact(contact.getId_Contact(), contact);
        return "forward:/";
    }


    // la méthode qui permet de rechercher un Contact par nom
    @PostMapping("/rechercherparnom")
    public String rechercherparnom(@RequestParam("nom") String nom, Model model) {
        var contactsparrecherche = contactService.chercherParNom(nom);
        model.addAttribute("contacts", contactsparrecherche);

        return "add";
    }

    // la méthode qui permet de rechercher un Contact par numéro de téléphone
    @PostMapping("/rechercherpartelephone")
    public String rechercherparnumerodetelephone(@RequestParam("numerotelephone") String numero, Model model) {
        var contactsderecherche = contactService.chercherParNumerodeTelephone(numero);
        model.addAttribute("contacts", contactsderecherche);

        return "add";
    }

    // on extrait tous les groupes
    @RequestMapping("/listdegroupe")
    public String getListofGroup(Model model) {
        // extraire tous les groupes de la base de données
        List<Groupe> groups = groupeService.findAllGroups();
        // ajouter ces groups au model pour que nous pouvons les affichés après dans le view
        model.addAttribute("groups", groups);

        return "add";
    }


    // l'ajout d'un groupe (un groupe est constitué de plusieurs contacts)
    //donc pour créer un groupe on doit tout d'abord reçoit son nom et les ids des contacts qu'ils appartients à lui.
    // tous cela je le fait avec jstl. dans le view j'affiche un Modal (formulaire) qui contient les contacts, les contacts je les obtients
    // en base de données.
    @RequestMapping("/ajoutergroupe")
    // donc on reçoit le nom du groupe + les ids des contacts
    public String ajoutdegroupe(@RequestParam("nom") String groupName, @RequestParam("contactIds") String[] contactIds) {
        Groupe group = new Groupe(groupName);
        // Ajouter chaque contact sélectionné au groupe
        for (String contactId : contactIds) {
            Long id = Long.valueOf(contactId);
            Contact contact = contactService.findContactById(id);
            group.addContact(contact);
        }
        // Enregistrer le groupe en base de données
        groupeService.save(group);
        // un redirection au niveau serveur
        return "forward:/listdegroupe";
    }

    //méthode qui permet la suppression d'un groupe
    @GetMapping("/deletegroup/{id_group}")
    public String deleteGroup(@PathVariable("id_group") Long id_group, Model model) {
        //appeler la méthode delete du groupeService
        groupeService.delete(id_group);
        model.addAttribute("message", String.format("le groupe avec l'id %d est bien supprimé ", id_group));
        // un redirection au niveau serveur
        return "forward:/listdegroupe";
    }

    // la recherche d'un groupe par nom
    @PostMapping("/recherchergroupe")
    public String cherchergroupe(@RequestParam("nom") String nomgroup, Model model) {
        var groups = groupeService.getGroupeListbyNom(nomgroup);
        model.addAttribute("groups", groups);


        return "add";
    }

    // l'ajout d'un objet de type Contact au model
    @ModelAttribute("contact")
    public Contact generateContact() {
        return new Contact();
    }


    // j'ai utilisé le Modal dans bootstrap pour afficher les formulaire
    // donc lorsque je veux ajouter un groupe j'ai toujours besoin d'extraire tous les contacts
    // pour cela j'ai utilisé cette méthode
    @ModelAttribute("all")
    public List<Contact> gettAllContact() {
        return contactService.getAllContactByOrder();
    }

}
