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

<!-- Add Invoice Form -->
<form action="/AddServlet" method="post">
    <h2>Add Invoice</h2>
    <label>SL No:</label><input type="text" name="sl_no" required><br>
    <label>Customer Order ID:</label><input type="text" name="customer_order_id" required><br>
    <label>Sales Organization:</label><input type="text" name="sales_org" required><br>
    <label>Distribution Channel:</label><input type="text" name="distribution_channel" required><br>
    <label>Division:</label><input type="text" name="division" required><br>
    <label>Released Credit Value:</label><input type="text" name="released_credit_value" required><br>
    <label>Purchase Order Type:</label><input type="text" name="purchase_order_type" required><br>
    <label>Company Code:</label><input type="text" name="company_code" required><br>
    <label>Order Creation Date:</label><input type="text" name="order_creation_date" required><br>
    <label>Order Creation Time:</label><input type="text" name="order_creation_time" required><br>
    <label>Credit Control Area:</label><input type="text" name="credit_control_area" required><br>
    <label>Sold To Party:</label><input type="text" name="sold_to_party" required><br>
    <label>Order Amount:</label><input type="text" name="order_amount" required><br>
    <label>Requested Delivery Date:</label><input type="text" name="requested_delivery_date" required><br>
    <label>Order Currency:</label><input type="text" name="order_currency" required><br>
    <label>Credit Status:</label><input type="text" name="credit_status" required><br>
    <label>Customer Number:</label><input type="text" name="customer_number" required><br>
    <label>Amount in USD:</label><input type="text" name="amount_in_usd" required><br>
    <label>Unique Customer Number:</label><input type="text" name="unique_cust_id" required><br>
    <input type="submit" value="Add Invoice">
</form>

<!-- Delete Invoice Form -->
<form action="deleteInvoice" method="post">
    <h2>Delete Invoice</h2>
    <label>SL No:</label><input type="number" name="sl_no" required><br>
    <input type="submit" value="Delete Invoice">
</form>

</body>
</html>
