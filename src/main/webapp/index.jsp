<%-- 
    Document   : index
    Created on : Jun 23, 2016, 7:39:50 PM
    Author     : Rafael
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Search</title>
    </head>
    <body>
        <h1>Movie Search</h1>
        <form action="MovieSearch" method="GET">
            <label for="searchParam">Search:</label>
            <input type="text" id="searchParam" name="s" />
            <br /><br />
            <input type="submit" value="Search" />
        </form>
        <c:if test="${!empty movies}">
           <h2>Movies</h2>
        </c:if>
        <c:forEach var="movie" items="${movies}">
            <p>${movie.Title} (${movie.Year})</p>
            <img src="${movie.Poster}" alt="Poster" height="250" width="170">
        </c:forEach>
    </body>
</html>