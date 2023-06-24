<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HighRadius 2023 - Invoice Management</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 20px;
    }

    h1 {
        text-align: center;
        color: #555555;
        margin-bottom: 20px;
    }

    form {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
    }

    label {
        display: inline-block;
        width: 150px;
        margin-bottom: 10px;
    }

    input[type="text"],
    input[type="number"] {
        padding: 8px;
        width: 250px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="submit"] {
        padding: 8px 20px;
        background-color: #4CAF50;
        color: #ffffff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<h1>HighRadius 2023 - Invoice Management</h1>
<h1><%= "CRUD Application" %>
</h1>
<br/>
<a href="InsertServlet">Insert Record</a><br>
<form action="<%= request.getContextPath() %>/DisplayServlet" method="get">
<a href="DisplayServlet">Display Record</a>
    <input type="submit" value="Submit" />
</form>
<form action="<%= request.getContextPath() %>/AnalyticsServlet" method="post">
<a href="AnalyticsServlet">Analytics</a>
    <input type="submit" value="Submit" />
</form>


<a href="DeleteServlet">Delete Record</a><br>
<a href="EditServlet">Edit Record</a><br>
<a href="AdvancedSearch.jsp">Perform Advanced Search on Records</a><br>

</body>
</html>
