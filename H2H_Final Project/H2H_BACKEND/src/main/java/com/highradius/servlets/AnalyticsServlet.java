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
import com.highradius.model.AnalyticsModel;
import com.google.gson.Gson;

/**
 * Servlet implementation class AnalyticsServlet
 */
@WebServlet("/AnalyticsServlet")
public class AnalyticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> arrayList=new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyticsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			Crud.createConnection();
		} catch (Exception e) {			
			e.printStackTrace();
		}
        ArrayList<AnalyticsModel> analyticModelArrayList=new ArrayList<>();
        Crud crud=new Crud();
        analyticModelArrayList=crud.getAnalyticData(arrayList);
        PrintWriter out = response.getWriter();        
        Gson gson = new Gson();
        String json = gson.toJson(analyticModelArrayList);
        out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		arrayList.clear();
        arrayList.add(request.getParameter("DISTRIBUTION_CHANNEL"));
        arrayList.add(request.getParameter("CUSTOMER_NUMBER"));
	}
}