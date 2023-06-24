<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Data</title>
</head>
<body>
<div align="center">
    <h1>Edit Data Form</h1>
    <form action="<%= request.getContextPath() %>/EditServlet" method="get">
        <table style="with: 80%">

            <tr>
                <td>Sl_no</td>
                <td><input type="number" name="sl_no" required/></td>
            </tr>

        </table>
        <input type="submit" value="Submit" />
    </form>
    <form action="<%= request.getContextPath() %>/EditServlet" method="post">
        <table style="with: 80%">

            <tr>
                <td>Sl_no</td>
                <td><input type="number" name="Sl_No" value=${invoice.Sl_No} required/></td>
            </tr>

            <tr>
                <td>ORDER_CURRENCY</td>
                <td><input type="text" name="ORDER_CURRENCY" value=${invoice.ORDER_CURRENCY} required/></td>
            </tr>

            <tr>
                <td>COMPANY_CODE</td>
                <td><input type="number" name="COMPANY_CODE" value=${invoice.COMPANY_CODE} required/></td>
            </tr>
            
            <tr>
                <td>DISTRIBUTION_CHANNEL</td>
                <td><input type="text" name="DISTRIBUTION_CHANNEL" value=${invoice.DISTRIBUTION_CHANNEL} required/></td>
            </tr>

        </table>
        <input type="submit" value="Submit" />
    </form>
</div>

</body>
</html>