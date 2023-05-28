<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="mb-3">
    <c:if test="${not empty requestScope.message}">
        <div class="alert alert-info text-center">
                ${requestScope.message}
        </div>
    </c:if>
</div>

<c:if test="${not empty contacts}">
    <table class="table table-striped table-success table-hover border border-1 border-success shadow shadow-lg table-auto">
        <thead>
        <tr>
           <%-- <th class="text-center" scope="col">id</th>--%>
            <th class="text-center" scope="col">nom</th>
            <th class="text-center" scope="col">prenom</th>
            <th class="text-center" scope="col">Genre</th>
            <th class="text-center" scope="col">adresse</th>
            <th class="text-center" scope="col">téléphone1</th>
            <th class="text-center" scope="col">téléphone2</th>
            <th class="text-center" scope="col">email1</th>
            <th class="text-center" scope="col">email2</th>
            <th class="text-center" scope="col" class="text-center" colspan="2">Action</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contacts}" var="contact">
            <tr>
               <%-- <td class="text-center">${contact.id_Contact}</td>--%>
                <td class="text-center">${contact.nom}</td>
                <td class="text-center">${contact.prenom}</td>
                <td class="text-center">${contact.genre}</td>
                <td class="text-center">${contact.adress}</td>
                <td class="text-center">${contact.telephone1}</td>
                <td class="text-center">${contact.telephone2}</td>

                <td class="text-center">${contact.emailpersonnel}</td>
                <td class="text-center">${contact.emailprofessional}</td>

                <td class="text-center"><a href="/deletecontact/${contact.id_Contact}">
                    <button class="btn btn-danger"
                            onclick="confirm('voulez vous vraiment supprimer cette contact??')"> supprimer
                    </button>
                </a></td>
                <td class="text-center">
                    <button class=" btn btn-secondary modifier" data-id="${contact.id_Contact}"> modifier
                    </button>
                </td>

            </tr>

        </c:forEach>

        </tbody>
    </table>

</c:if>

<c:if test="${not empty groups}">

    <table class="table table-striped table-success table-hover border border-danger  table-auto">
        <thead>
        <tr>
                <%-- <th scope="col">id</th>--%>
            <th class="text-center" scope="col">nom</th>
            <th class="text-center" scope="col">Action</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td class="text-center">${group.nom}</td>
                <td class="text-center"><a href="/deletegroup/${group.id_groupe}">
                    <button class="btn btn-danger"
                            onclick="confirm('voulez vous vraiment supprimer cette contact??')"> supprimer
                    </button>
                </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</c:if>



