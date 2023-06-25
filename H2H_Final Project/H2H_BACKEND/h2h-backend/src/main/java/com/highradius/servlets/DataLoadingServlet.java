package com.highradius.servlets;

import com.google.gson.Gson;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/InvoiceData")
public class DataLoadingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InvoiceDaoImpl invoiceDao;

    @Override
    public void init() {
        invoiceDao = new InvoiceDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET");
        PrintWriter writer = response.getWriter();
        String jsonResponseInvoiceDetail;
        List<Invoice> invoiceToShowOnUi = invoiceDao.getInvoiceList();
        Gson gson = new Gson();
        jsonResponseInvoiceDetail = gson.toJson(invoiceToShowOnUi);
        response.setContentType("application/json");
        writer.append(jsonResponseInvoiceDetail);
    }
}
