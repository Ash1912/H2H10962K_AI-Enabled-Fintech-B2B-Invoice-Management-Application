package com.highradius.model;

public class Invoice {
	private int slNo;
    private long customerOrderID;
    private int salesOrg;
    private String distributionChannel;
    private int companyCode;
    private String orderCreationDate;
    private double orderAmount;
    private String orderCurrency;
    private long customerNumber;
    private double amountInUsd;

    public Invoice(int slNo, long customerOrderID, int salesOrg, String distributionChannel,
                   int companyCode, String orderCreationDate, double orderAmount,
                   String orderCurrency, long customerNumber, double amountInUsd) {
        this.slNo = slNo;
        this.customerOrderID = customerOrderID;
        this.salesOrg = salesOrg;
        this.distributionChannel = distributionChannel;
        this.companyCode = companyCode;
        this.orderCreationDate = orderCreationDate;
        this.orderAmount = orderAmount;
        this.orderCurrency = orderCurrency;
        this.customerNumber = customerNumber;
        this.amountInUsd = amountInUsd;
    }
    public int getSlNo() {
 		return slNo;
 	}

 	public void setSlNo(int slNo) {
 		this.slNo = slNo;
 	}

 	public long getCustomerOrderID() {
 		return customerOrderID;
 	}

 	public void setCustomerOrderID(long customerOrderID) {
 		this.customerOrderID = customerOrderID;
 	}

 	public int getSalesOrg() {
 		return salesOrg;
 	}

 	public void setSalesOrg(int salesOrg) {
 		this.salesOrg = salesOrg;
 	}

 	public String getDistributionChannel() {
 		return distributionChannel;
 	}

 	public void setDistributionChannel(String distributionChannel) {
 		this.distributionChannel = distributionChannel;
 	}

 	public int getCompanyCode() {
 		return companyCode;
 	}

 	public void setCompanyCode(int companyCode) {
 		this.companyCode = companyCode;
 	}

 	public String getOrderCreationDate() {
 		return orderCreationDate;
 	}

 	public void setOrderCreationDate(String orderCreationDate) {
 		this.orderCreationDate = orderCreationDate;
 	}

 	public double getOrderAmount() {
 		return orderAmount;
 	}

 	public void setOrderAmount(double orderAmount) {
 		this.orderAmount = orderAmount;
 	}

 	public String getOrderCurrency() {
 		return orderCurrency;
 	}

 	public void setOrderCurrency(String orderCurrency) {
 		this.orderCurrency = orderCurrency;
 	}

 	public long getCustomerNumber() {
 		return customerNumber;
 	}

 	public void setCustomerNumber(long customerNumber) {
 		this.customerNumber = customerNumber;
 	}

 	public double getAmountInUsd() {
 		return amountInUsd;
 	}

 	public void setAmountInUsd(double amountInUsd) {
 		this.amountInUsd = amountInUsd;
 	}
}
