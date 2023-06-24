package com.highradius.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InvoiceDao invoiceDao;
       

    public AddServlet() {
        super();
    }

	public void init() {
		
		invoiceDao = new InvoiceDaoImpl();	
		
	}
	
	public void addInvoice(Invoice invoice) {
        invoiceDao.insertInvoice(invoice);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer sl_no = Integer.parseInt(request.getParameter("SL"));
	    Integer customer_order_id = Integer.parseInt(request.getParameter("cust_ord_id"));
	    Integer sales_org = Integer.parseInt(request.getParameter("sal_org"));
	    String distribution_channel = request.getParameter("dist_channel");
	    String division = request.getParameter("div");
	    Double released_credit_value = Double.parseDouble(request.getParameter("rc_val"));
	    String purchase_order_type = request.getParameter("p_o_t");
	    Integer company_code = Integer.parseInt(request.getParameter("comp_code"));
	    String order_creation_date = request.getParameter("oc_date");
	    String order_creation_time = request.getParameter("oc_time");
	    String credit_control_area = request.getParameter("cc_area");
	    Integer sold_to_party = Integer.parseInt(request.getParameter("sold_party"));
	    Double order_amount = Double.parseDouble(request.getParameter("ord_amt"));
	    String requested_delivery_date = request.getParameter("rd_date");
	    String order_currency = request.getParameter("ord_curr");
	    String credit_status = request.getParameter("cre_sta");
	    Integer customer_number = Integer.parseInt(request.getParameter("cust_num"));
	    Double amount_in_usd = Double.parseDouble(request.getParameter("amt_usd"));
	    Long unique_cust_id = Long.parseLong(request.getParameter("u_cust_id"));
	    
	    Invoice invoice = new Invoice();
        invoice.setSl_No(sl_no);
        invoice.setCUSTOMER_ORDER_ID(customer_order_id);
        invoice.setSALES_ORG(sales_org);
        invoice.setDISTRIBUTION_CHANNEL(distribution_channel);
        invoice.setDIVISION(division);
        invoice.setRELEASED_CREDIT_VALUE(released_credit_value);
        invoice.setPURCHASE_ORDER_TYPE(purchase_order_type);
        invoice.setCOMPANY_CODE(company_code);
        invoice.setORDER_CREATION_DATE(order_creation_date);
        invoice.setORDER_CREATION_TIME(order_creation_time);
        invoice.setCREDIT_CONTROL_AREA(credit_control_area);
        invoice.setSOLD_TO_PARTY(sold_to_party);
        invoice.setORDER_AMOUNT(order_amount);
        invoice.setREQUESTED_DELIVERY_DATE(requested_delivery_date);
        invoice.setORDER_CURRENCY(order_currency);
        invoice.setCREDIT_STATUS(credit_status);
        invoice.setCUSTOMER_NUMBER(customer_number);
        invoice.setAMOUNT_IN_USD(amount_in_usd);
        invoice.setUNIQUE_CUST_ID(unique_cust_id);
        
        
        try {
        	addInvoice(invoice);
        }catch(Exception e) {
        	e.printStackTrace();
        }
	       

	}

}