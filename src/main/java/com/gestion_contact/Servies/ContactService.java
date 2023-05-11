package com.gestion_contact.Servies;

import com.gestion_contact.Entities.Contact;
import com.gestion_contact.Repositeries.IContact;

import com.gestion_contact.Servies.Interface.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// la classe de service de contact
@Service
public class ContactService implements IContactService {
    // l'injection automatique de contactRepository
    @Autowired
    private IContact contactRepositery;

    // la méthode de création
    public Contact create(Contact contact) {
        return contactRepositery.save(contact);
    }

    // la méthode de la recherche par id
    public Contact findContactById(Long id) {
        Contact contact = null;
        Optional<Contact> optionalContact = contactRepositery.findById(id);
        if (optionalContact.isPresent()) {
            contact = optionalContact.get();
        }
        return contact;
    }



    // la méthode pour extraire tous les contacts en ordre
    public List<Contact> getAllContactByOrder() {
        return contactRepositery.findAllByOrderByNomAscPrenomAsc();
    }

    // la méthode de supression d'un contact avec id
    public void deleteContact(Long id) {
        contactRepositery.deleteById(id);
    }

    // la méthode de la mise à jour d'un contact
    public void updateContact(Long id, Contact contact) {
        Contact c = findContactById(id);
        if (c != null) {
            c.setNom(contact.getNom());
            c.setPrenom(contact.getPrenom());
            c.setAdress(contact.getAdress());
            c.setGenre(contact.getGenre());
            c.setEmailpersonnel(contact.getEmailpersonnel());
            c.setEmailprofessional(contact.getEmailprofessional());
            c.setTelephone1(contact.getTelephone1());
            c.setTelephone2(contact.getTelephone2());
             contactRepositery.save(contact);
        }
       /* return null;*/
    }

    // la recherche par Nom
    public List<Contact> chercherParNom(String nom) {
        return contactRepositery.getContactByNomContainingIgnoreCase(nom);
    }

    // la recherche par Numéro de téléphone
    public List<Contact> chercherParNumerodeTelephone(String telephone) {
        return contactRepositery.getContactByTelephone1ContainingOrTelephone2Containing(telephone, telephone);
    }
}
