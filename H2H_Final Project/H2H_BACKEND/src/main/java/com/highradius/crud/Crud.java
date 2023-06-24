package com.highradius.crud;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import com.highradius.model.AnalyticsModel;
import com.highradius.model.Invoice;

public class Crud {
	static Connection conn;
	ResultSet rst;
	static boolean ConnectStatus = false;
	
	// A static function to establish connection with the database.
    public static void createConnection() throws Exception{
    	try {
            Class.forName("com.mysql.jdbc.Driver");            
            Crud.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/h2h_internship?zeroDateTimeBehavior=convertToNull", "root", "C_20051685");            
            ConnectStatus=true;
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    		ConnectStatus = false;
    	}
    }
    
    //Function to convert Java.util.date type to java.sql.date type
    public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
    // Function to Display/Retrieve the data
    public ArrayList<Invoice> DisplayData() throws Exception {
        ArrayList<Invoice> InvoiceList = new ArrayList<>();
        String displayQuery = "select * from h2h_oap;";
        Class.forName("com.mysql.jdbc.Driver");
        if (ConnectStatus == true) {
            Statement statement = conn.createStatement();
            rst = statement.executeQuery(displayQuery);
            while (rst.next()) {
                Invoice invoiceObject = new Invoice();
                invoiceObject.setSl_No(rst.getInt("Sl_No"));
                invoiceObject.setCUSTOMER_ORDER_ID(rst.getInt("CUSTOMER_ORDER_ID"));
                invoiceObject.setSALES_ORG(rst.getInt("SALES_ORG"));
                invoiceObject.setDISTRIBUTION_CHANNEL(rst.getString("DISTRIBUTION_CHANNEL"));
                invoiceObject.setCOMPANY_CODE(rst.getInt("COMPANY_CODE"));
                invoiceObject.setORDER_CREATION_DATE(rst.getDate("ORDER_CREATION_DATE"));
                invoiceObject.setORDER_CURRENCY(rst.getString("ORDER_CURRENCY"));
                invoiceObject.setCUSTOMER_NUMBER(rst.getInt("CUSTOMER_NUMBER"));
                invoiceObject.setAMOUNT_IN_USD(rst.getDouble("AMOUNT_IN_USD"));
                // Add the values to our resultant Arraylist
                InvoiceList.add(invoiceObject);
            }
            return InvoiceList;
        } else {
            System.out.println("Database Not Connected");
        }
        return null;
    }
    
    // Function to Insert Data to Database
    public int addData(Invoice insertObject) throws Exception{
    	String insertQuery = "insert into h2h_oap () values (?,?,?,?,?,?,?,?,?);";
    	int resultStatus=0;
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	//To handle adding of data after deleting last row
    	String selectAllQuery = "select * from h2h_oap";
    	Statement statement = conn.createStatement();    	
    	ResultSet selectAll = statement.executeQuery(selectAllQuery);
    	int count = 0;
    	while (selectAll.next()) {
            count+=1;
        }
        System.out.println("Number of Records in the database: " + count);   
   	
	    	if (ConnectStatus == true) {
	            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
	            {
	                preparedStatement.setInt(1, count + 1);
	                preparedStatement.setInt(2, insertObject.getCUSTOMER_ORDER_ID());
	                preparedStatement.setInt(3, insertObject.getSALES_ORG());
	                preparedStatement.setString(4, insertObject.getDISTRIBUTION_CHANNEL());
	                preparedStatement.setInt(5, insertObject.getCOMPANY_CODE());
	                preparedStatement.setDate(6, insertObject.getORDER_CREATION_DATE());
	                preparedStatement.setString(7, insertObject.getORDER_CURRENCY());
	                preparedStatement.setInt(8, insertObject.getCUSTOMER_NUMBER());
	                preparedStatement.setDouble(9, insertObject.getAMOUNT_IN_USD());
	
	                resultStatus = preparedStatement.executeUpdate();
	                return resultStatus;
	            }
	        }
	    	else {
	    		return resultStatus;
	    	}     	
        }
    
    // Fetch details on the basis of sl_no to implement edit functionality
    public Invoice fetchDetailsbySl(String Sl_id) throws SQLException {
        String fetchQuery = "select * from h2h_oap where Sl_No=?;";
        PreparedStatement preparedStatement=conn.prepareStatement(fetchQuery);
        preparedStatement.setString(1,Sl_id);
        ResultSet fetchrs=preparedStatement.executeQuery();
        Invoice invoiceObject=new Invoice();
        if(fetchrs.next()){
        	invoiceObject.setSl_No(fetchrs.getInt("Sl_No"));
        	invoiceObject.setDISTRIBUTION_CHANNEL(fetchrs.getString("DISTRIBUTION_CHANNEL"));
        	invoiceObject.setCOMPANY_CODE(fetchrs.getInt("COMPANY_CODE"));
        	invoiceObject.setORDER_CURRENCY(fetchrs.getString("ORDER_CURRENCY"));
        return invoiceObject;
        }
        else{
            System.out.println("Record Not Found");
            return null;
        }
    }
    //Function to implement edit functionality
    public int editData(Invoice invoiceObject) {
    	int statusCode = -1;
        String editQuery = "update h2h_oap set ORDER_CURRENCY=?,COMPANY_CODE=?,DISTRIBUTION_CHANNEL=?"+ " where sl_no=?;";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(editQuery);
            preparedStatement.setString(1, invoiceObject.getDISTRIBUTION_CHANNEL());
            preparedStatement.setInt(2, invoiceObject.getCOMPANY_CODE());
            preparedStatement.setString(3, invoiceObject.getORDER_CURRENCY());
            preparedStatement.setInt(4, invoiceObject.getSl_No());
            preparedStatement.executeUpdate();
            statusCode=1;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            statusCode=0;
        }
        return statusCode;
    }
    
    // Function to perform Advanced Search Functionality
    public ArrayList<Invoice> AdvancedSearch(Invoice invoice) throws Exception {
    	ArrayList<Invoice> searchList=new ArrayList<>();
    	Invoice invoiceObject = new Invoice();
    	String AdvSearchQuery="select * from h2h_oap where CUSTOMER_ORDER_ID=?;";
    	PreparedStatement preparedStatement=conn.prepareStatement(AdvSearchQuery);
        preparedStatement.setInt(1,invoice.getCUSTOMER_ORDER_ID());
        ResultSet SearchResults=preparedStatement.executeQuery();
        
        while(SearchResults.next()){
        	invoiceObject.setSl_No(SearchResults.getInt("Sl_No"));
        	invoiceObject.setCUSTOMER_ORDER_ID(SearchResults.getInt("CUSTOMER_ORDER_ID"));
        	invoiceObject.setSALES_ORG(SearchResults.getInt("SALES_ORG"));
        	invoiceObject.setDISTRIBUTION_CHANNEL(SearchResults.getString("DISTRIBUTION_CHANNEL"));
        	invoiceObject.setCOMPANY_CODE(SearchResults.getInt("COMPANY_CODE"));
        	invoiceObject.setORDER_CREATION_DATE(SearchResults.getDate("ORDER_CREATION_DATE"));
        	invoiceObject.setORDER_CURRENCY(SearchResults.getString("ORDER_CURRENCY"));
        	invoiceObject.setCUSTOMER_NUMBER(SearchResults.getInt("CUSTOMER_NUMBER"));
        	invoiceObject.setAMOUNT_IN_USD(SearchResults.getDouble("AMOUNT_IN_USD"));
            searchList.add(invoiceObject);
        }
        return searchList;
    }
    
    //Function to perform delete operation on multiple records
    public int[] delete(int[] rowsToDelete) throws SQLException {
        int[] deleteArray = new int[rowsToDelete.length];
        String delQuery= "update h2h_oap where sl_no=?;";
        PreparedStatement preparedStatement=conn.prepareStatement(delQuery);
        for(int i=0;i<rowsToDelete.length;i++){
            preparedStatement.setInt(1,rowsToDelete[i]);
            deleteArray[i]=preparedStatement.executeUpdate();
        }
        return deleteArray;
    }
    
    // Function to Fetch Analytics from the Database
    public ArrayList<AnalyticsModel> getAnalyticData(ArrayList<String> list){
    	
    	String [] D_CHANNEL = {"Martinique", "Moldova", "United Arab Emirates"};

        ArrayList<String> DISTRIBUTION_CHANNEL=new ArrayList<>();
        ArrayList<Integer> CUSTOMER_NUMBER=new ArrayList<>();
        ArrayList<Double> AMOUNT_IN_USD=new ArrayList<>();
        System.out.println("Analytics Arraylist size: "+list.size());
        
        for(String s:list){
            System.out.println("Analytics Arraylist Item before null: "+s);
        }        
        for(int i=0;i<list.size();i++){
            if(list.get(i)==""){
                list.set(i,"null");
            }
        }        
        for(String s:list){
            System.out.println("Analytics Arraylist Item after null: "+s);
        } 
        //Query to select any combination of input given by the user
        String Analyticsquery="select * from h2h_oap where (((DISTRIBUTION_CHANNEL=? or DISTRIBUTION_CHANNEL=?) or (CUSTOMER_NUMBER=? or CUSTOMER_NUMBER=?));";
        
        for(int i=0;i<D_CHANNEL.length;i++){
            try {
                PreparedStatement preparedStatement=conn.prepareStatement(Analyticsquery);
                if(list.get(0).equals("null")){
                    preparedStatement.setDate(1,null);
                }
                else{
                    preparedStatement.setString(1,list.get(0));
                    System.out.println(list.get(0));
                }
                if(list.get(1).equals("null")){
                    preparedStatement.setDate(2,null);
                }
                else{
                    preparedStatement.setString(2,list.get(1));
                    System.out.println(list.get(1));
                }
                if(list.get(2).equals("null")){
                    preparedStatement.setDate(3,null);
                }
                else{
                    preparedStatement.setString(3,list.get(2));
                    System.out.println(list.get(2));
                }
  
                preparedStatement.setString(4,D_CHANNEL[i]);
                System.out.println(preparedStatement);
                ResultSet rs=preparedStatement.executeQuery();
                int CUSTOMER_NUMBERTemp=0;
                double AMOUNT_IN_USDTemp=0;
                while(rs.next()){
                	CUSTOMER_NUMBERTemp++;
                	AMOUNT_IN_USDTemp=AMOUNT_IN_USDTemp+rs.getDouble("AMOUNT_IN_USD");
                }
                AMOUNT_IN_USDTemp = AMOUNT_IN_USDTemp/10000;
                System.out.println(D_CHANNEL[i]+" "+CUSTOMER_NUMBERTemp+" "+AMOUNT_IN_USDTemp+" ");
                DISTRIBUTION_CHANNEL.add(D_CHANNEL[i]);
                CUSTOMER_NUMBER.add(CUSTOMER_NUMBERTemp);
                AMOUNT_IN_USD.add(AMOUNT_IN_USDTemp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ArrayList<AnalyticsModel> analyticModelArrayList=new ArrayList<>();
        AnalyticsModel analyticModel=new AnalyticsModel();
        analyticModel.setDISTRIBUTION_CHANNEL(DISTRIBUTION_CHANNEL);
        analyticModel.setCUSTOMER_NUMBER(CUSTOMER_NUMBER);
        analyticModel.setAMOUNT_IN_USD(AMOUNT_IN_USD);
        analyticModelArrayList.add(analyticModel);
        
        return analyticModelArrayList;
    }
    
    // Function to get to update it inside the database
    public boolean predictToDatabase(Integer[] CUSTOMERORDERIDList) throws Exception {
        String Predictquery = "update h2h_oap where CUSTOMER_ORDER_ID=?";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        PreparedStatement preparedStatement = conn.prepareStatement(Predictquery);
            for (int i = 0; i < CUSTOMERORDERIDList.length; i++) {
                preparedStatement.setInt(1, CUSTOMERORDERIDList[i]);
                preparedStatement.executeUpdate();
            }
            return true;
        }
    }
