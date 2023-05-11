<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add contact</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="css/myStyle.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <style>

    </style>
</head>
<body>

<div class="d-flex ">


    <div class="container-fluid bg-success">
        <div class="row">
            <div class="col-12 d-flex flex-column gap-4">
                <div class="titre  d-flex justify-content-center align-items-center">
                    <h2 class="text-center text-white bg-danger p-2"> Gestion de Contacts </h2>
                </div>
            </div>
        </div>

        <hr/>

        <div class="row">
            <div class="col-4">
                <button class="btn btn-danger" id="btnsupp" data-bs-toggle="modal" data-bs-target="#addcontact"> Ajouter
                    Un contact
                </button>
            </div>
            <div class="col-4">
                <form:form class="form-inline d-flex gap-2" action="/rechercherparnom" method="post">
                    <input class="form-control" type="search" name="nom" placeholder="rechercher par nom"
                           aria-label="Search">
                    <button class="btn btn-danger my-2 my-sm-0" type="submit"><i class="bi bi-search"></i></button>
                </form:form>
            </div>
            <div class="col-4">
              <%--  <form:form class="form-inline d-flex gap-2" action="/rechercherpartelephone" method="post">
                    <input class="form-control" name="numerotelephone" type="search"
                           placeholder="rechercher par numéro de téléphone" aria-label="Search">
                    <button class="btn btn-danger my-2 my-sm-0" type="submit"><i class="bi bi-search"></i></button>
                <form:form/>--%>
            </div>

        </div>


        <hr/>


        <c:if test="${not empty requestScope.message}">
            <div class="alert alert-info text-center">
                    ${requestScope.message}
            </div>
        </c:if>

        <div class="row">
            <div class="col-12">
                <table class="table table-striped table-success table-hover">
                    <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">nom</th>
                        <th scope="col">prenom</th>
                        <th scope="col">Genre</th>
                        <th scope="col">adresse</th>
                        <th scope="col">téléphone1</th>
                        <th scope="col">téléphone2</th>
                        <th scope="col">email1</th>
                        <th scope="col">email2</th>
                        <th scope="col" class="text-center" colspan="2">Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${contacts}" var="contact">
                        <tr>
                            <td>${contact.id_Contact}</td>
                            <td>${contact.nom}</td>
                            <td>${contact.prenom}</td>
                            <td>${contact.genre}</td>
                            <td>${contact.adress}</td>
                            <td>${contact.telephone1}</td>
                            <td>${contact.telephone2}</td>

                            <td>${contact.emailpersonnel}</td>
                            <td>${contact.emailprofessional}</td>

                            <td><a href="/deletecontact/${contact.id_Contact}">
                                <button class="btn btn-danger"
                                        onclick="alert('voulez vous vraiment supprimer cette contact??')"> supprimer
                                </button>
                            </a></td>
                            <td>
                                <button class=" btn btn-secondary modifier" data-id="${contact.id_Contact}"> modifier
                                </button>
                            </td>

                        </tr>

                    </c:forEach>

                    </tbody>
                </table>

            </div>

        </div>


        <jsp:include page="../Modals/modalforupdate.jsp"/>

        <jsp:include page="../Modals/formadd.jsp"/>

    </div>
</div>


<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>


<script type="text/javascript" src="js/test.js"></script>

</body>
</html>