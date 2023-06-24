<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Records to DataBase</title>
</head>
<body>
 <div align="center">
  <h1>Insert Records Form</h1>
  <form action="<%= request.getContextPath() %>/InsertServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>Customer Order ID</td>
     <td><input type="number" name="CUSTOMER_ORDER_ID" required/></td>
    </tr>
    <tr>
     <td>Sales Org</td>
     <td><input type="number" name="SALES_ORG" required/></td>
    </tr>
    <tr>
     <td>Distribution Channel</td>
     <td><input type="text" name="DISTRIBUTION_CHANNEL" required/></td>
    </tr>
    <tr>
     <td>Company Code</td>
     <td><input type="number" name="COMPANY_CODE" required/></td>
    </tr>
    <tr>
     <td>Order Creation Date</td>
     <td><input type="date" name="ORDER_CREATION_DATE" required/></td>
    </tr>
    <tr>
     <td>Order Amount</td>
     <td><input type="number" name="ORDER_AMOUNT" required/></td>
    </tr>
    <tr>
     <td>Order Currency</td>
     <td><input type="text" step="0.01" name="ORDER_CURRENCY" required/></td>
    </tr>
    <tr>
     <td>Customer Number</td>
     <td><input type="number" name="CUSTOMER_NUMBER" required/></td>
    </tr>
    <tr>
     <td>Amount In USD</td>
     <td><input type="number" name="AMOUNT_IN_USD" required/></td>
    </tr>

   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>