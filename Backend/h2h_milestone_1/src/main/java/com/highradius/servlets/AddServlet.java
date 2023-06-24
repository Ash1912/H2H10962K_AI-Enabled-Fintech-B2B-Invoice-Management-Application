package com.highradius.servlets;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    private InvoiceDao invoiceDao;

    public void init() {
        invoiceDao = new InvoiceDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieving invoice data from the request parameters
        int slNo = Integer.parseInt(request.getParameter("slNo"));
        int customerOrderID = Integer.parseInt(request.getParameter("customerOrderID"));
        int salesOrg = Integer.parseInt(request.getParameter("salesOrg"));
        String distributionChannel = request.getParameter("distributionChannel");
        String division = request.getParameter("division");
        float releasedCreditValue = Float.parseFloat(request.getParameter("releasedCreditValue"));
        String purchaseOrderType = request.getParameter("purchaseOrderType");
        int companyCode = Integer.parseInt(request.getParameter("companyCode"));
        String orderCreationDate = request.getParameter("orderCreationDate");
        String orderCreationTime = request.getParameter("orderCreationTime");
        String creditControlArea = request.getParameter("creditControlArea");
        int soldToParty = Integer.parseInt(request.getParameter("soldToParty"));
        float orderAmount = Float.parseFloat(request.getParameter("orderAmount"));
        String requestedDeliveryDate = request.getParameter("requestedDeliveryDate");
        String orderCurrency = request.getParameter("orderCurrency");
        String creditStatus = request.getParameter("creditStatus");
        int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
        float amountInUsd = Float.parseFloat(request.getParameter("amountInUsd"));
        long uniqueCustNumber = Long.parseLong(request.getParameter("uniqueCustNumber"));

        // Creating an Invoice object with the retrieved data
        Invoice invoice = new Invoice(slNo, customerOrderID, salesOrg, distributionChannel, division, releasedCreditValue,
                purchaseOrderType, companyCode, orderCreationDate, orderCreationTime, creditControlArea, soldToParty,
                orderAmount, requestedDeliveryDate, orderCurrency, creditStatus, customerNumber, amountInUsd, uniqueCustNumber);

        // Adding the invoice using the InvoiceDao's insertInvoice method
        invoiceDao.insertInvoice(invoice);

        // Redirecting to a success page
        response.sendRedirect("success.jsp");
    }
}
