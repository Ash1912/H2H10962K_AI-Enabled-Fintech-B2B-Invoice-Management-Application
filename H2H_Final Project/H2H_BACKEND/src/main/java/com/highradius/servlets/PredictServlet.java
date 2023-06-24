package com.highradius.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.crud.Crud;

/**
 * Servlet implementation class PredictBucketServlet
 */
@WebServlet("/PredictServlet")
public class PredictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PredictServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status=false;
	    Integer CUSTOMER_ORDER_ID= Integer.parseInt(request.getParameter("CUSTOMER_ORDER_ID"));
        
        System.out.println("\nCustomer Order ID: "+CUSTOMER_ORDER_ID);

        
        Integer[] CUSTOMERORDERIDList= CUSTOMER_ORDER_ID.split(",");

        try {
			Crud.createConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        Crud crud= new Crud();
        try {
            status=crud.predictToDatabase(CUSTOMERORDERIDList);
        } catch (Exception e) {
            e.printStackTrace();
        }    
	}
}
