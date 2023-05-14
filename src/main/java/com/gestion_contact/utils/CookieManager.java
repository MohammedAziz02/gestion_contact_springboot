package com.gestion_contact.utils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// une class qui nous aide a gérer les cookies dans notre application (créer, supprimer ) un cookie
public class CookieManager {

    public static void createCookie(String name, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        response.addCookie(cookie);
    }

    public static Cookie readCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

   /* public static void updateCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }*/

    public static void deleteCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
