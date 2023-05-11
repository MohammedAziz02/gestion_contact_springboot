<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--hada blan--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="modal fade" id="modaladdgroup" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h5 class="modal-title w-100" id="exampleModalLabel">Ajouter un groupe</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" ></button>
            </div>
            <div class="modal-body">
                <form:form action="/ajoutergroupe" method="post">
                    <div class="mb-3">
                        <label  class="form-label">Nom de Groupe :</label>
                        <input type="text" class="form-control"  name="nom">
                    </div>
                    <div class="mb-3">
                        <label>Contacts :</label>
                        <ul>
                            <c:forEach items="${contacts}" var="contact">
                                <li>
                                    <label>
                                        <input type="checkbox" name="contactIds" class="form-check-input" value="${contact.id_Contact}">
                                            ${contact.nom} ${contact.prenom} / ${contact.telephone1}
                                    </label>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">ajouter </button>
                </form:form>
            </div>

        </div>
    </div>
</div>