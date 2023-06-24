package com.highradius.servlets;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DataLoadingServlet extends HttpServlet {
    private InvoiceDao invoiceDao;

    public void init() {
        invoiceDao = new InvoiceDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Getting the list of invoices using the InvoiceDao's getInvoices method
        List<Invoice> invoices = invoiceDao.getInvoices();

        // Setting the invoices as an attribute in the request
        request.setAttribute("invoices", invoices);

        // Forwarding the request to a JSP page for displaying the invoices
        request.getRequestDispatcher("invoices.jsp").forward(request, response);
    }
}
