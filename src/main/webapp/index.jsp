<%-- 
    Document   : index
    Created on : Jun 23, 2016, 7:39:50 PM
    Author     : Rafael
--%>

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

    </body>
</html>
