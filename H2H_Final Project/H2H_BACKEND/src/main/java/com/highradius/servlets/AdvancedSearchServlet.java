package com.highradius.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.crud.Crud;
import com.highradius.model.Invoice;
import com.google.gson.Gson;

/**
 * Servlet implementation class AdvancedSearchServlet
 */
@WebServlet("/AdvancedSearchServlet")
public class AdvancedSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvancedSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CUSTOMER_ORDER_ID= request.getParameter("CUSTOMER_ORDER_ID");
		String CUSTOMER_NUMBER= request.getParameter("CUSTOMER_NUMBER");
		String SALES_ORG= request.getParameter("SALES_ORG");
		
        Crud crudObject= new Crud();
        try {
			Crud.createConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Invoice invoiceObject=new Invoice();
        invoiceObject.setCUSTOMER_ORDER_ID(Integer.parseInt(CUSTOMER_ORDER_ID));
        invoiceObject.setCUSTOMER_NUMBER(Integer.parseInt(CUSTOMER_NUMBER));
        invoiceObject.setSALES_ORG(Integer.parseInt(SALES_ORG));
        ArrayList<Invoice> invoiceArrayList = null;
        try {
            invoiceArrayList=crudObject.AdvancedSearch(invoiceObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        Gson gsonObject = new Gson();
        String json = gsonObject.toJson(invoiceArrayList);
        out.print(json);
        out.print(invoiceArrayList.size());
	}

}