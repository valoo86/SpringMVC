<%-- 
    Document   : user_modifier
    Created on : 4 nov. 2015, 16:38:03
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
        <h1>Modifier un utilisateur ${util.login}</h1>
        <div>
            <form:form modelAttribute="util" action="modifier" method="POST">
                Login: <form:input path="login"/>
                <br>
                Email: <form:input path="email"/>
                <br>
                Mdp: <form:password path="mdp"/>
                <br>
                Age: <form:input path="age"/>
                <br>
                Id: <form:input path="id"/>
                <br>
                Pays: <form:select path="pays.id" items="${listePays}" itemValue="id" itemLabel="titre"/>
                <br>
                <input type="submit"/>
            </form:form>
        </div>
    </body>
</html>
