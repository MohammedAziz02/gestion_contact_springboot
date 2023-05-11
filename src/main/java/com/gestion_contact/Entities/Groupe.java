package com.gestion_contact.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

// l'entité Groupe avec les getters et setters et les méthodes principales d'ajout de contact ***
@Entity
public class Groupe {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id_groupe")
    private Long id_groupe;
    @Column(name="nom")
    private String nom;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH}, mappedBy="groupedecontacts")
    private Set<Contact> listedeContacts=new HashSet<>();
    public Groupe() {}
    public Groupe(String nomgroupe){
        this.nom = nomgroupe;
    }

    public Long getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(Long id_groupe) {
        this.id_groupe = id_groupe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Contact> getListedeContacts() {
        return listedeContacts;
    }

    public void setListedeContacts(Set<Contact> listedeContacts) {
        this.listedeContacts = listedeContacts;
    }

    public void addContact(Contact contact){
        this.listedeContacts.add(contact);
        contact.setGroupedecontacts(this);
    }

    public void removeContact(Contact contact){
        this.listedeContacts.remove(contact);
        contact.setGroupedecontacts(null);
    }

    public void removeAllContact(){
        for(Contact contact : this.listedeContacts){
            contact.setGroupedecontacts(null);
        }
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "id_groupe=" + id_groupe +
                ", nom='" + nom + '\'' +
                ", listedeContacts=" + listedeContacts +
                '}';
    }
}
