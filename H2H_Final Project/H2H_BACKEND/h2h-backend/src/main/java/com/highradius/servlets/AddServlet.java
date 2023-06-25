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

@WebServlet("/addInvoice")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST");

        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();  // Creating a new instance for each request for thread-safety
        int lastInvoiceId = invoiceDao.getLastInvoiceId(); // fetch the last inserted Sl_no

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String str;
        while ((str = reader.readLine()) != null) {
            sb.append(str);
        }
        Invoice invoiceDataToInsert = gson.fromJson(sb.toString(), Invoice.class);
        invoiceDataToInsert.setSlNo(lastInvoiceId + 1); // set the slno to lastInvoiceId + 1

        invoiceDao.insertInvoice(invoiceDataToInsert);

        response.getWriter().write("Invoice added successfully.");

    }
}
