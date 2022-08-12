<%-- 
    Document   : shoppingList
    Created on : 10 Aug, 2022, 12:51:41 AM
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
        <p>Hello, ${user}</p>
        <br>
        <a href="<c:url value="/ShoppingList">
               <c:param name="action" value="logout"/>
            </c:url>">Logout</a>
        
        <h2>List</h2>
        <form method="post" action="ShoppingList">
        <label>Add Item:</label>
        <input type="text" name="itemname" value="">
        <input type="submit" name="add" value="Add">
        <input type="hidden" name="action" value="add">
        </form>
        
        <form method="post" action="ShoppingList">
        <ul>
        <c:forEach items="${itemList}" var="item">
        <li> <input type="radio" name="itemname" value="${item}">${item}</li>
        </c:forEach>
        </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
