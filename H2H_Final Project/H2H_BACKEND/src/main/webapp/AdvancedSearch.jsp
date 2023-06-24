<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Advanced Search</title>
</head>
<body>
<div align="center">
  <h1>Input the below data to search records:</h1>
  <form action="<%= request.getContextPath() %>/AdvancedSearchServlet" method="post">
   <table style="with: 80%">
   <tr>
     <td>Customer Order ID</td>
     <td><input type="number" name="CUSTOMER_ORDER_ID" required/></td>
    </tr>   
    <tr>
     <td>Customer Number</td>
     <td><input type="number" name="CUSTOMER_NUMBER" required/></td>
    </tr>
    <tr>
     <td>Sales Org</td>
     <td><input type="number" name="SALES_ORG" required/></td>
    </tr>    
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>