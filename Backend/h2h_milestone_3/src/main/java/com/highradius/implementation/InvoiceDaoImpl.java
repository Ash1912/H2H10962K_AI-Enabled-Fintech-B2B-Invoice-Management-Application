package com.highradius.implementation;
import com.highradius.connection.DatabaseConnection;
import com.highradius.model.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDao {

	@Override
	public List<Invoice> getInvoices() {
		List<Invoice> invoices = new ArrayList<>();

        try (Connection connection = DatabaseConnection.con();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM h2h_intern");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Invoice invoice = new Invoice();
                invoice.setSl_No(resultSet.getInt("sl_no"));
                invoice.setCUSTOMER_ORDER_ID(resultSet.getInt("CUSTOMER_ORDER_ID"));
                invoice.setSALES_ORG(resultSet.getInt("SALES_ORG"));
                invoice.setDISTRIBUTION_CHANNEL(resultSet.getString("DISTRIBUTION_CHANNEL"));
                invoice.setDIVISION(resultSet.getString("DIVISION"));
                invoice.setRELEASED_CREDIT_VALUE(resultSet.getDouble("RELEASED_CREDIT_VALUE"));
                invoice.setPURCHASE_ORDER_TYPE(resultSet.getString("PURCHASE_ORDER_TYPE"));
                invoice.setCOMPANY_CODE(resultSet.getInt("COMPANY_CODE"));
                invoice.setORDER_CREATION_DATE(resultSet.getString("ORDER_CREATION_DATE"));
                invoice.setORDER_CREATION_TIME(resultSet.getString("ORDER_CREATION_TIME"));
                invoice.setCREDIT_CONTROL_AREA(resultSet.getString("CREDIT_CONTROL_AREA"));
                invoice.setSOLD_TO_PARTY(resultSet.getInt("SOLD_TO_PARTY"));
                invoice.setORDER_AMOUNT(resultSet.getDouble("ORDER_AMOUNT"));
                invoice.setREQUESTED_DELIVERY_DATE(resultSet.getString("REQUESTED_DELIVERY_DATE"));
                invoice.setORDER_CURRENCY(resultSet.getString("ORDER_CURRENCY"));
                invoice.setCREDIT_STATUS(resultSet.getString("CREDIT_STATUS"));
                invoice.setCUSTOMER_NUMBER(resultSet.getInt("CUSTOMER_NUMBER"));
                invoice.setAMOUNT_IN_USD(resultSet.getDouble("AMOUNT_IN_USD"));
                invoice.setUNIQUE_CUST_ID(resultSet.getLong("UNIQUE_CUST_ID"));

                invoices.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return invoices;
	}

	@Override
	public void insertInvoice(Invoice invoice) {
		try (Connection connection = DatabaseConnection.con();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO h2h_oap (sl_no, CUSTOMER_ORDER_ID, SALES_ORG, " +
                        "DISTRIBUTION_CHANNEL, DIVISION, RELEASED_CREDIT_VALUE, PURCHASE_ORDER_TYPE, COMPANY_CODE, " +
                        "ORDER_CREATION_DATE, ORDER_CREATION_TIME, CREDIT_CONTROL_AREA, SOLD_TO_PARTY, ORDER_AMOUNT, " +
                        "REQUESTED_DELIVERY_DATE, ORDER_CURRENCY, CREDIT_STATUS, CUSTOMER_NUMBER, AMOUNT_IN_USD, UNIQUE_CUST_ID) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

               statement.setInt(1, invoice.getSl_No());
               statement.setInt(2, invoice.getCUSTOMER_ORDER_ID());
               statement.setInt(3, invoice.getSALES_ORG());
               statement.setString(4, invoice.getDISTRIBUTION_CHANNEL());
               statement.setString(5, invoice.getDIVISION());
               statement.setDouble(6, invoice.getRELEASED_CREDIT_VALUE());
               statement.setString(7, invoice.getPURCHASE_ORDER_TYPE());
               statement.setInt(8, invoice.getCOMPANY_CODE());
               statement.setString(9, invoice.getORDER_CREATION_DATE());
               statement.setString(10, invoice.getORDER_CREATION_TIME());
               statement.setString(11, invoice.getCREDIT_CONTROL_AREA());
               statement.setInt(12, invoice.getSOLD_TO_PARTY());
               statement.setDouble(13, invoice.getORDER_AMOUNT());
               statement.setString(14, invoice.getREQUESTED_DELIVERY_DATE());
               statement.setString(15, invoice.getORDER_CURRENCY());
               statement.setString(16, invoice.getCREDIT_STATUS());
               statement.setInt(17, invoice.getCUSTOMER_NUMBER());
               statement.setDouble(18, invoice.getAMOUNT_IN_USD());
               statement.setLong(19, invoice.getUNIQUE_CUST_ID());

               statement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }
		
	}

	@Override
	public void updateInvoice(Integer sl_no, Invoice invoice) {
		try (Connection connection = DatabaseConnection.con();
	             PreparedStatement statement = connection.prepareStatement("UPDATE h2h_intern SET " +
	                     "CUSTOMER_ORDER_ID = ?, SALES_ORG = ?, DISTRIBUTION_CHANNEL = ?, DIVISION = ?, " +
	                     "RELEASED_CREDIT_VALUE = ?, PURCHASE_ORDER_TYPE = ?, COMPANY_CODE = ?, " +
	                     "ORDER_CREATION_DATE = ?, ORDER_CREATION_TIME = ?, CREDIT_CONTROL_AREA = ?, " +
	                     "SOLD_TO_PARTY = ?, ORDER_AMOUNT = ?, REQUESTED_DELIVERY_DATE = ?, " +
	                     "ORDER_CURRENCY = ?, CREDIT_STATUS = ?, CUSTOMER_NUMBER = ?, AMOUNT_IN_USD = ?, " +
	                     "UNIQUE_CUST_ID = ? WHERE sl_no = ?")) {

	            statement.setInt(1, invoice.getCUSTOMER_ORDER_ID());
	            statement.setInt(2, invoice.getSALES_ORG());
	            statement.setString(3, invoice.getDISTRIBUTION_CHANNEL());
	            statement.setString(4, invoice.getDIVISION());
	            statement.setDouble(5, invoice.getRELEASED_CREDIT_VALUE());
	            statement.setString(6, invoice.getPURCHASE_ORDER_TYPE());
	            statement.setInt(7, invoice.getCOMPANY_CODE());
	            statement.setString(8, invoice.getORDER_CREATION_DATE());
	            statement.setString(9, invoice.getORDER_CREATION_TIME());
	            statement.setString(10, invoice.getCREDIT_CONTROL_AREA());
	            statement.setInt(11, invoice.getSOLD_TO_PARTY());
	            statement.setDouble(12, invoice.getORDER_AMOUNT());
	            statement.setString(13, invoice.getREQUESTED_DELIVERY_DATE());
	            statement.setString(14, invoice.getORDER_CURRENCY());
	            statement.setString(15, invoice.getCREDIT_STATUS());
	            statement.setInt(16, invoice.getCUSTOMER_NUMBER());
	            statement.setDouble(17, invoice.getAMOUNT_IN_USD());
	            statement.setLong(18, invoice.getUNIQUE_CUST_ID());
	            statement.setInt(19, sl_no);

	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void deleteInvoice(Integer sl_no) {
		try (Connection connection = DatabaseConnection.con();
	             PreparedStatement statement = connection.prepareStatement("DELETE FROM h2h_intern WHERE sl_no = ?")) {

	            statement.setInt(1, sl_no);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
	}

   