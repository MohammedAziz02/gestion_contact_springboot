package com.gestion_contact.Repositeries;

import com.gestion_contact.Entities.Contact;
import jakarta.persistence.OrderBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// la répositerie de Contact
@Repository
public interface IContact extends JpaRepository<Contact,Long> {
    // la méthode qui permet de rechercher un contact par nom
    List<Contact> getContactByNomContainingIgnoreCase(String nom);
    // lla méthode qui permet de rechercher un contact par téléphone 1 ou 2
    List<Contact> getContactByTelephone1ContainingOrTelephone2Containing(String phone1,String phone2);
    // la méthode qui permet d'extraire tous les contacts par nom et prénom ascendante
    List<Contact> findAllByOrderByNomAscPrenomAsc();

}
