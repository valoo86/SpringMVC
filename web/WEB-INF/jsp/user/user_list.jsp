<%-- 
    Document   : user_list
    Created on : 4 nov. 2015, 14:35:29
    Author     : ETY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
        <!--<h1>${users}</h1>-->

        Language : <a href="?language=en">English</a> <a href="?language=fr">Français</a>|
        <br>
        <br>
        
        <a href="<spring:url value="ajouter"/>">Ajouter un utilisateur</a>
        <br>
        <br>

        <table>
<!--            <caption>Liste des utilisateurs</caption>-->
            <caption><spring:message code="user.liste.titre"/></caption>
            
            
            <thead>
                <th>Login</th>
                <th>Email</th>
                <th>Pays</th>
            </thead>

            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.login}</td>
                        <td>${user.email}</td>
                        <td>${user.pays.id}</td>
                        <td><a href="<spring:url value="modifier/${user.id}"/>">Modifier</a><!-- url relative par rapport au chemin où on est --></td>
                        <td><a href="<spring:url value="supprimer/${user.id}"/>">Supprimer</a><!-- url relative par rapport au chemin où on est --></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

</body>
</html>
