package com.gestion_contact.Servies.Interface;

import com.gestion_contact.Entities.Groupe;

import java.util.List;

public interface IGroupeService {
    public void save(Groupe g);
    public void delete(Long id);
    public List<Groupe> getGroupeListbyNom(String nom);
    public List<Groupe> findAllGroups();
}
