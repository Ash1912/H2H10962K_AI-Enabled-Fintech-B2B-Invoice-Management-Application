package com.highradius.implementation;

import com.highradius.connection.DbConnection;
import com.highradius.model.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDao {

	@Override
	public List<Invoice> getInvoiceList() {
	    List<Invoice> invoiceList = new ArrayList<>();

	    try (Connection connection = DbConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement("SELECT Sl_no, CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, COMPANY_CODE, ORDER_CREATION_DATE, ORDER_CURRENCY, CUSTOMER_NUMBER, AMOUNT_IN_USD, ORDER_AMOUNT FROM h2h_oap LIMIT 100");
	         ResultSet resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {
	            Invoice invoice = new Invoice(
	                    resultSet.getInt("Sl_no"),
	                    resultSet.getLong("CUSTOMER_ORDER_ID"),
	                    resultSet.getInt("SALES_ORG"),
	                    resultSet.getString("DISTRIBUTION_CHANNEL"),
	                    resultSet.getInt("COMPANY_CODE"),
	                    resultSet.getString("ORDER_CREATION_DATE"),
	                    resultSet.getDouble("ORDER_AMOUNT"),
	                    resultSet.getString("ORDER_CURRENCY"),
	                    resultSet.getLong("CUSTOMER_NUMBER"),
	                    resultSet.getDouble("AMOUNT_IN_USD")
	            );

	            invoiceList.add(invoice);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return invoiceList;
	}


	@Override
	public boolean insertInvoice(Invoice invoice) {
	    boolean isSuccess = false;
	    try (Connection connection = DbConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement("INSERT INTO h2h_oap (Sl_no, CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, COMPANY_CODE, ORDER_CREATION_DATE, ORDER_CURRENCY, CUSTOMER_NUMBER, AMOUNT_IN_USD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

	        statement.setInt(1, invoice.getSlNo());
	        statement.setLong(2, invoice.getCustomerOrderID());
	        statement.setInt(3, invoice.getSalesOrg());
	        statement.setString(4, invoice.getDistributionChannel());
	        statement.setInt(5, invoice.getCompanyCode());
	        statement.setString(6, invoice.getOrderCreationDate());
	        statement.setString(7, invoice.getOrderCurrency());
	        statement.setLong(8, invoice.getCustomerNumber());
	        statement.setDouble(9, invoice.getAmountInUsd());
	        isSuccess = statement.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	}


	@Override
	public boolean updateInvoice(int id, String orderCurrency, int companyCode, String distributionChannel) {
	    boolean isSuccess = false;
	    try (Connection connection = DbConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement("UPDATE h2h_oap SET ORDER_CURRENCY = ?, COMPANY_CODE = ?, DISTRIBUTION_CHANNEL = ? WHERE Sl_no = ?")) {

	        statement.setString(1, orderCurrency);
	        statement.setInt(2, companyCode);
	        statement.setString(3, distributionChannel);
	        statement.setInt(4, id);

	        isSuccess = statement.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	}


    @Override
    public boolean deleteInvoice(List<Integer> ids) {
        boolean isSuccess = false;
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM h2h_oap WHERE Sl_no = ? LIMIT 100")) {
            for (Integer id : ids) {
                statement.setInt(1, id);
                statement.addBatch();
            }
            int[] results = statement.executeBatch();
            for (int i : results) {
                if (i == 0) {
                    return false;
                }
            }
            isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    @Override
    public int getLastInvoiceId() {
        int lastId = 0;
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT MAX(Sl_no) FROM h2h_oap LIMIT 100");
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                lastId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastId;
    }


}
