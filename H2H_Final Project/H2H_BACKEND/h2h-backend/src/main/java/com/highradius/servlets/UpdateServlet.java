package com.highradius.servlets;

import com.google.gson.Gson;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/updateInvoice")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();  // Creating a new instance for each request for thread-safety

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String str;
        while ((str = reader.readLine()) != null) {
            sb.append(str);
        }
        Invoice invoiceDataToUpdate = gson.fromJson(sb.toString(), Invoice.class);

        invoiceDao.updateInvoice(invoiceDataToUpdate.getSlNo(), 
                                 invoiceDataToUpdate.getOrderCurrency(), 
                                 invoiceDataToUpdate.getCompanyCode(), 
                                 invoiceDataToUpdate.getDistributionChannel());

        response.getWriter().write("Invoice updated successfully.");
    }
}
