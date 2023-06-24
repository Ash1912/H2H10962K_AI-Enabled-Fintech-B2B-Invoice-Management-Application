package com.highradius.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.crud.Crud;
import com.highradius.model.Invoice;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/AddData.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public java.sql.Date convertToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CUSTOMER_ORDER_ID = request.getParameter("CUSTOMER_ORDER_ID");
        String SALES_ORG = request.getParameter("SALES_ORG");
        String DISTRIBUTION_CHANNEL = request.getParameter("DISTRIBUTION_CHANNEL");
        String COMPANY_CODE = request.getParameter("COMPANY_CODE");
        String ORDER_CREATION_DATE = request.getParameter("ORDER_CREATION_DATE");
        String ORDER_AMOUNT = request.getParameter("ORDER_AMOUNT");
        String ORDER_CURRENCY = request.getParameter("ORDER_CURRENCY");
        String CUSTOMER_NUMBER = request.getParameter("CUSTOMER_NUMBER");
        String AMOUNT_IN_USD = request.getParameter("AMOUNT_IN_USD");

        Invoice InvoiceObject = new Invoice();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        
        InvoiceObject.setCUSTOMER_ORDER_ID(Integer.parseInt(CUSTOMER_ORDER_ID));
        InvoiceObject.setSALES_ORG(Integer.parseInt(SALES_ORG));
        InvoiceObject.setDISTRIBUTION_CHANNEL(DISTRIBUTION_CHANNEL);
        InvoiceObject.setCOMPANY_CODE(Integer.parseInt(COMPANY_CODE));
        

        Date parsedOrderCreationDate = null;
        try {
        	parsedOrderCreationDate = formatter.parse(ORDER_CREATION_DATE);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert parsedOrderCreationDate != null;
        InvoiceObject.setORDER_CREATION_DATE(convertToSqlDate(parsedOrderCreationDate));

    
        
        InvoiceObject.setORDER_AMOUNT(Double.parseDouble(ORDER_AMOUNT));
        InvoiceObject.setORDER_CURRENCY(ORDER_CURRENCY);
        InvoiceObject.setCUSTOMER_NUMBER(Integer.parseInt(CUSTOMER_NUMBER));
        InvoiceObject.setAMOUNT_IN_USD(Double.parseDouble(AMOUNT_IN_USD));

       

        try {
			Crud.createConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        int resultStatus = -1;
        Crud crud = new Crud();

        try {
        	resultStatus= crud.addData(InvoiceObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(resultStatus==1){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/SuccessPage.jsp");
            dispatcher.forward(request, response);
        }
        else{
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error in registering');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
	}
}