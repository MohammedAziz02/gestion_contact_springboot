<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--hada blan--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="updatecontact" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h5 class="modal-title w-100"   id="staticBackdropLabel">Modification  du Contact</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form:form action="/modifiercontact" name="formupdate" method="post" modelAttribute="contact">

                    <form:input path = "id_Contact"  type="hidden" cssClass="form-control" name="id_Contact"  />

                    <div class="mb-3 d-flex flex-column gap-2">
                        <label for="nom" class="form-label">Nom :</label>
                            <%--<input type="text" class="form-control" id="nom">--%>
                        <td><form:input  path = "nom" cssClass="form-control" name="nom"/></td>
                        <td><form:errors path = "nom" cssClass = "alert-danger alert text-center" /></td>
                    </div>
                    <div class="mb-3 d-flex flex-column gap-2">
                        <label for="prenom" class="form-label">Prenom :</label>
                            <%--   <input type="text" class="form-control" id="prenom">--%>
                        <td><form:input path = "prenom" cssClass="form-control" name="prenom"  /></td>
                        <td><form:errors path = "prenom" cssClass = "alert-danger alert text-center" /></td>
                    </div>
                    <div class="mb-3 d-flex flex-column gap-2">
                        <label for="genre" class="form-label">Genre :</label>
                            <%-- <select id="Genre" class="form-select" >
                                 <option value="Homme" selected>Homme</option>
                                 <option value="Femme" >Femme</option>
                             </select>--%>
                        <form:select path="genre" cssClass="form-select" name="genre" >
                            <form:option value="Homme" label="Homme"  />
                            <form:option value="Femme" label="Femme"/>
                        </form:select>
                        <td><form:errors path = "genre" cssClass = "alert-danger alert text-center" /></td>
                    </div>
                    <div class="mb-3 d-flex flex-column gap-2">
                        <label for="adress" class="form-label">addresse :</label>
                            <%--<input type="text" class="form-control" id="adresse">--%>
                        <td><form:input path = "adress" cssClass="form-control" name="adress" /></td>
                        <td><form:errors path = "adress" cssClass = "alert-danger alert text-center" /></td>
                    </div>
                    <div class="mb-3 d-flex flex-column gap-2">
                        <label for="telephone1" class="form-label">telephpne 1 :</label>
                            <%--<input type="text" class="form-control" id="telephone1">--%>
                        <td><form:input path = "telephone1" cssClass="form-control" name="telephone1" /></td>
                        <td><form:errors path = "telephone1" cssClass = "alert-danger alert text-center" /></td>
                    </div>
                    <div class="mb-3 d-flex flex-column gap-2">
                        <label for="telephone2" class="form-label">telephpne 2 :</label>
                            <%--<input type="text" class="form-control" id="telephone2">--%>
                        <td><form:input path = "telephone2" cssClass="form-control" name="telephone2" /></td>
                        <td><form:errors path = "telephone2" cssClass = "alert-danger alert text-center" /></td>
                    </div>
                    <div class="mb-3 d-flex flex-column gap-2">
                        <label for="emailpersonnel" class="form-label">Email personnel :</label>
                            <%--<input type="email" class="form-control" id="emailperson">--%>
                        <td><form:input path = "emailpersonnel" cssClass="form-control" name="emailpersonnel" /></td>
                        <td><form:errors path = "emailpersonnel" cssClass = "alert-danger alert text-center" /></td>
                    </div>

                    <div class="mb-3 d-flex flex-column gap-2">
                        <label for="emailprofessional" class="form-label">Email professionnel :</label>
                            <%--<input type="email" class="form-control" id="emailprofess">--%>
                        <td><form:input path = "emailprofessional" cssClass="form-control" name="emailprofessional" /></td>
                        <td><form:errors path = "emailprofessional" cssClass = "alert-danger alert text-center" /></td>
                    </div>

                    <button type="submit"  class="btn btn-primary">Modifier</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </form:form>

            </div>

        </div>
    </div>
</div>