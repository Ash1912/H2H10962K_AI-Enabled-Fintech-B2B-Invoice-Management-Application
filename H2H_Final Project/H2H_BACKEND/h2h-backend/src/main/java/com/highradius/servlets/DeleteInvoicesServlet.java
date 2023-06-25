package com.highradius.servlets;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.highradius.implementation.InvoiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet("/deleteInvoices")
public class DeleteInvoicesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String str;
        while ((str = reader.readLine()) != null) {
            sb.append(str);
        }
        Type listType = new TypeToken<List<Integer>>(){}.getType();
        List<Integer> idList = gson.fromJson(sb.toString(), listType);

        boolean isDataDeleted = invoiceDao.deleteInvoice(idList);

        if (isDataDeleted) {
            response.getWriter().append("Data deleted successfully");
        } else {
            response.getWriter().append("Failed to delete data");
        }
    }
}
