package com.gestion_contact.Repositeries;

import com.gestion_contact.Entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// la répositerie de Groupe
public interface IGroupe extends JpaRepository<Groupe,Long> {
    List<Groupe> getGroupeByNomIgnoreCase(String nom);
}
