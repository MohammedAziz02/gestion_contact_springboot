package com.gestion_contact.FIlters;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
// le but de cette filter est :
// d'abord j'ai utiliser les Modal de bootstrap comme formulaire pour ajouter ou modifier un Contact
// lorsque on a bien remplir tous les champs donc il  n'a pas de problèmes
// mais lorsque on a pas bien remplit un champ , soit on le laisse vide ou ne répond pas au vérification de hibernate
// alors la requette va arriver au serveur et le serveur va vérifier , il va trouver un erreur , donc il va retourner
// une page / et le Modal va s'afficher automatiquement avec les messages d'erreur
//donc si le serveur trouve un erreur va créer un cookie qui est la cause de pop up du Modal,
// avec javascript on vérifie si le cookie exist alors le modal pop up , sinon ne pop up pas.
// le problème est que si un utilisateur n'a pas remplis bien le formulaire est le modal pop up mais il n'a pas remplis
// du retour il a refrecher la page dans ce cas le modal pop up car il existe déja le cookie, donc l'idéé est supprimer
// cette cookie dès le départ d'un requete
@Component
@Order(1)
public class FilterForModal implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("modalShownadd") || cookie.getName().equals("modalShownupdate")) {

                    cookie.setMaxAge(0);
                    res.addCookie(cookie);
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
