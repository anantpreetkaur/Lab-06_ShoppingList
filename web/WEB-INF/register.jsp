<%-- 
    Document   : register
    Created on : 5 Aug, 2022, 12:00:20 PM
    Author     : anant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
         <h1>Shopping List</h1>
        <form method="post" action="ShoppingList">
            <label>Username:</label>
            <input type="text" name="user" value="">
            <input type="submit" value="Register name">
            <input type="hidden" name="action" value="register">
        </form>
    </body>
</html>
