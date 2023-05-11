<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--hada blan--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav id="sidebar">
    <div class="custom-menu">
        <button type="button" id="sidebarCollapse" class="btn btn-primary">
            <i class="fa fa-bars"></i>
            <span class="sr-only">Toggle Menu</span>
        </button>


    </div>


    <div class="p-4">
        <h1 class="text-center">
            <a href="/" class="logo">Application de <span class="badge">la gestion de contacts</span></a>
        </h1>
        <hr/>
        <h5 class="text-center text-white"> Contact</h5>
        <hr/>
        <ul class="list-unstyled components mb-5 ">
            <li class="active mb-2 w-100 ">
                <button class="btn btn-danger w-100" id="btnsupp" data-bs-toggle="modal" data-bs-target="#addcontact">
                    <i class="bi bi-plus-circle-fill"></i>
                    Ajouter
                    Un contact
                </button>
            </li>

            <li class="active mb-2">

                <form:form class="form-inline  d-flex gap-1" action="/rechercherparnom" method="post">
                    <input class="form-control w-75" type="search" name="nom" placeholder="rechercher par nom"
                           aria-label="Search">
                    <button class="btn  w-25 text-white btn-success" type="submit"><i class="bi bi-search"></i></button>
                </form:form>

            </li>

            <li class="active">

                <form:form class="form-inline  d-flex gap-1" action="/rechercherpartelephone" method="post">
                    <input class="form-control w-75" type="search" name="numerotelephone"
                           placeholder="rechercher par numéro de téléphone"
                           aria-label="Search">
                    <button class="btn btn-success  w-25 text-white" type="submit"><i class="bi bi-search"></i></button>
                </form:form>

            </li>
        </ul>

        <hr/>
        <h5 class="text-center text-white"> Groupe</h5>
        <hr/>
        <ul class="list-unstyled components mb-5">
            <li class="active mb-2 w-100">
                <a href="/listdegroupe">  <button class="btn btn-secondary w-100" >
                    <i class="bi bi-card-checklist"></i>
                    voir la liste des groupes
                </button>
                </a>
            </li>
            <li class="active mb-2">

                <form:form class="form-inline  d-flex gap-1" action="/recherchergroupe" method="post">
                    <input class="form-control w-75" type="search" name="nom" placeholder="rechercher Groupe"
                           aria-label="Search">
                    <button class="btn  w-25 text-white btn-success" type="submit"><i class="bi bi-search"></i></button>
                </form:form>

            </li>
            <li class="active mb-2 w-100">
                <button class="btn btn-secondary w-100"   data-bs-toggle="modal" data-bs-target="#modaladdgroup" >
                    <i class="bi bi-plus-circle-fill"></i>
                    Ajouter
                    Un Groupe
                </button>
            </li>
        </ul>

    </div>

</nav>