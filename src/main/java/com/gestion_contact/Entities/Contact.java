package com.gestion_contact.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Objects;


// l'entité contact avec les getters et setters
@Entity
public class Contact {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id_Contact;

    @NotBlank(message = "le nom ne doit pas étre null")
    private String nom;
    @NotBlank(message = "le prenom ne doit pas étre null")
    private String prenom;
    @Pattern(regexp = "^06\\d{8}$",message = "veuillez vérifier le numéro Personnel de téléphone que vous avez saisis")
    private String telephone1;
    @Pattern(regexp = "^06\\d{8}$",message = "veuillez vérifier le numéro Professionnel de téléphone que vous avez saisis")
    private String telephone2;
    public String adress;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "vérfiez que vous avez saisis un email personnel valide")
    private String emailpersonnel;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "vérfiez que vous avez saisis un email professionnel valide")
    private String emailprofessional;
    @NotNull(message = "le genre ne doit pas étre null")
    private String genre;


    @ManyToOne
    @JoinColumn(name = "id_groupe")
    private Groupe groupedecontacts;

    public Contact(String nom, String prenom, String telephoe1, String telephoe2, String adress, String emailpersonnel, String emailprofessional, String genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone1 = telephoe1;
        this.telephone2 = telephoe2;
        this.adress = adress;
        this.emailpersonnel = emailpersonnel;
        this.emailprofessional = emailprofessional;
        this.genre = genre;
    }

    public Contact() {}

    public Long getId_Contact() {
        return id_Contact;
    }

    public void setId_Contact(Long id_Contact) {
        this.id_Contact = id_Contact;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmailpersonnel() {
        return emailpersonnel;
    }

    public void setEmailpersonnel(String emailpersonnel) {
        this.emailpersonnel = emailpersonnel;
    }

    public String getEmailprofessional() {
        return emailprofessional;
    }

    public void setEmailprofessional(String emailprofessional) {
        this.emailprofessional = emailprofessional;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Groupe getGroupedecontacts() {
        return groupedecontacts;
    }

    public void setGroupedecontacts(Groupe groupedecontacts) {
        this.groupedecontacts = groupedecontacts;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(id_Contact, contact.id_Contact) && Objects.equals(nom, contact.nom) && Objects.equals(prenom, contact.prenom) && Objects.equals(telephone1, contact.telephone1) && Objects.equals(telephone2, contact.telephone2) && Objects.equals(adress, contact.adress) && Objects.equals(emailpersonnel, contact.emailpersonnel) && Objects.equals(emailprofessional, contact.emailprofessional) && Objects.equals(genre, contact.genre) && Objects.equals(groupedecontacts, contact.groupedecontacts);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id_Contact, nom, prenom, telephone1, telephone2, adress, emailpersonnel, emailprofessional, genre, groupedecontacts);
    }
}
