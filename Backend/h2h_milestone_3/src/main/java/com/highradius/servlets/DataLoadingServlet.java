package com.highradius.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

@WebServlet("/DataLoadingServlet")
public class DataLoadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InvoiceDao invoiceDao;
 
    public DataLoadingServlet() {
        super();
    }

	public void init() throws ServletException {
		
		invoiceDao = new InvoiceDaoImpl();
		
	} 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		Gson gson= new Gson();
		String jsonresponse= new String();
		
		try {
		List<Invoice> invoices = invoiceDao.getInvoices();
		jsonresponse  =gson.toJson(invoices);
		out.println(jsonresponse);
		} catch (Exception e) {
            e.printStackTrace();
        }
		
	} 

}