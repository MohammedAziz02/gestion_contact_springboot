package com.gestion_contact.Servies;

import com.gestion_contact.Entities.Groupe;
import com.gestion_contact.Repositeries.IGroupe;
import com.gestion_contact.Servies.Interface.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupeService implements IGroupeService {
    @Autowired
    private IGroupe groupeService;

    public void save(Groupe g) {
        groupeService.save(g);
    }

    public void delete(Long id) {
        Optional<Groupe> groupe = groupeService.findById(id);
        if (groupe.isPresent()) {
            Groupe g = groupe.get();
            g.removeAllContact();
            groupeService.delete(g);
        }
    }

    public List<Groupe> getGroupeListbyNom(String nom) {
        return groupeService.getGroupeByNomIgnoreCase(nom);
    }

    public List<Groupe> findAllGroups(){
        return groupeService.findAll();
    }

}
