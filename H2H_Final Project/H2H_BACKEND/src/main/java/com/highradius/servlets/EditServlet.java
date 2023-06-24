package com.highradius.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.crud.Crud;
import com.highradius.model.Invoice;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	Invoice invoice = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Invoice invoiceObject = new Invoice();
        
        String ORDERCURRENCY=request.getParameter("ORDER_CURRENCY");
        String COMPANYCODE=request.getParameter("COMPANY_CODE");
        String DISTRIBUTIONCHANNEL=request.getParameter("DISTRIBUTION_CHANNEL");
        String sl_no=request.getParameter("Sl_No");        
        
        invoiceObject.setORDER_CURRENCY(ORDERCURRENCY);
        invoiceObject.setCOMPANY_CODE(Integer.parseInt(COMPANYCODE));
        invoiceObject.setDISTRIBUTION_CHANNEL(DISTRIBUTIONCHANNEL);
        invoiceObject.setSl_No(Integer.parseInt(sl_no));
        Crud crudObject = new Crud();
        try {
			Crud.createConnection();
		} 
        catch (Exception e) {			
			e.printStackTrace();
		}
        int statusCode = crudObject.editData(invoiceObject);
        System.out.println("Edit Servlet Status: "+ statusCode);        
	}
}