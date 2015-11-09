<%-- 
    Document   : ajouter
    Created on : 4 nov. 2015, 14:58:01
    Author     : ETY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ajouter un utilisateur</h1>
        <div>
            <form:form modelAttribute="util" action="ajouter" method="POST">
                Login: <form:input path="login"/> <form:errors path="login"/>
                <br>
                Email: <form:input path="email"/>
                <br>
                Mdp: <form:password path="mdp"/>
                <br>
                Age: <form:input path="age"/>
                <br>
                Id: <form:input path="id"/>
                <br>
                <input type="submit"/>
                Pays: <form:select path="pays.id" items="${listePays}" itemValue="id" itemLabel="titre"/>
                <br>
            </form:form>
        </div>
    </body>
</html>
