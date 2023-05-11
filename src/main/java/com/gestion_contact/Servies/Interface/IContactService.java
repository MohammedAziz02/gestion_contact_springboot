package com.gestion_contact.Servies.Interface;

import com.gestion_contact.Entities.Contact;

import java.util.List;

public interface IContactService {
    public Contact create(Contact contact);
    public Contact findContactById(Long id);
    public List<Contact> getAllContactByOrder();
    public void deleteContact(Long id);
    public void updateContact(Long id, Contact contact);
    public List<Contact> chercherParNom(String nom);
    public List<Contact> chercherParNumerodeTelephone(String telephone);
}
