<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--hada blan--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/myStyle.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

</head>
<body>
<div class="wrapper d-flex align-items-stretch">
    <%--Navbar--%>
    <jsp:include page="../utils/navbar.jsp"/>

    <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5 pt-5">
        <jsp:include page="../utils/tabledecontacts.jsp"/>
    </div>


    <jsp:include page="../Modals/formadd.jsp"/>

    <jsp:include page="../Modals/modalforupdate.jsp"/>
    <jsp:include page="../Modals/modaladdgroupe.jsp"/>


</div>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/test.js"></script>


</body>
</html>