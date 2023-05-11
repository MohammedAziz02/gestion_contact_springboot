package com.gestion_contact;

import com.gestion_contact.Entities.Contact;
import com.gestion_contact.Entities.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.gestion_contact.Servies.GroupeService;

@SpringBootApplication
public class GestionContactApplication implements CommandLineRunner {
    @Autowired
    GroupeService service;

    public static void main(String[] args) {
        SpringApplication.run(GestionContactApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
