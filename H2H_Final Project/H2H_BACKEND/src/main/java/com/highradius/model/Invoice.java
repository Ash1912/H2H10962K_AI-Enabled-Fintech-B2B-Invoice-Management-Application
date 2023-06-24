package com.highradius.model;

import java.sql.*;

public class Invoice {
	
	private Integer Sl_No;
	private Integer CUSTOMER_ORDER_ID;
	private Integer SALES_ORG;
	private String DISTRIBUTION_CHANNEL;
	private String DIVISION;
	private Double RELEASED_CREDIT_VALUE;
	private String PURCHASE_ORDER_TYPE;
	private Integer COMPANY_CODE;
	private Date ORDER_CREATION_DATE;
	private String ORDER_CREATION_TIME;
	private String CREDIT_CONTROL_AREA;
	private Integer SOLD_TO_PARTY;
	private Double ORDER_AMOUNT;
	private Date REQUESTED_DELIVERY_DATE;
	private String ORDER_CURRENCY;
	private String CREDIT_STATUS;
	private Integer CUSTOMER_NUMBER;
	private Double AMOUNT_IN_USD;
	private Long UNIQUE_CUST_ID;
	

	public Integer getSl_No() {
		return Sl_No;
	}

	public void setSl_No(Integer Sl_No) {
		this.Sl_No = Sl_No;
	}

	public Integer getCUSTOMER_ORDER_ID() {
		return CUSTOMER_ORDER_ID;
	}

	public void setCUSTOMER_ORDER_ID(Integer CUSTOMER_ORDER_ID) {
		this.CUSTOMER_ORDER_ID = CUSTOMER_ORDER_ID;
	}

	public Integer getSALES_ORG() {
		return SALES_ORG;
	}

	public void setSALES_ORG(Integer SALES_ORG) {
		this.SALES_ORG = SALES_ORG;
	}

	public String getDISTRIBUTION_CHANNEL() {
		return DISTRIBUTION_CHANNEL;
	}

	public void setDISTRIBUTION_CHANNEL(String DISTRIBUTION_CHANNEL) {
		this.DISTRIBUTION_CHANNEL = DISTRIBUTION_CHANNEL;
	}

	public String getDIVISION() {
		return DIVISION;
	}

	public void setDIVISION(String DIVISION) {
		this.DIVISION = DIVISION;
	}

	public Double getRELEASED_CREDIT_VALUE() {
		return RELEASED_CREDIT_VALUE;
	}

	public void setRELEASED_CREDIT_VALUE(Double RELEASED_CREDIT_VALUE) {
		this.RELEASED_CREDIT_VALUE = RELEASED_CREDIT_VALUE;
	}

	public String getPURCHASE_ORDER_TYPE() {
		return PURCHASE_ORDER_TYPE;
	}

	public void setPURCHASE_ORDER_TYPE(String PURCHASE_ORDER_TYPE) {
		this.PURCHASE_ORDER_TYPE = PURCHASE_ORDER_TYPE;
	}

	public Integer getCOMPANY_CODE() {
		return COMPANY_CODE;
	}

	public void setCOMPANY_CODE(Integer COMPANY_CODE) {
		this.COMPANY_CODE = COMPANY_CODE;
	}

	public Date getORDER_CREATION_DATE() {
		return ORDER_CREATION_DATE;
	}

	public void setORDER_CREATION_DATE(Date ORDER_CREATION_DATE) {
		this.ORDER_CREATION_DATE = ORDER_CREATION_DATE;
	}

	public String getORDER_CREATION_TIME() {
		return ORDER_CREATION_TIME;
	}

	public void setORDER_CREATION_TIME(String ORDER_CREATION_TIME) {
		this.ORDER_CREATION_TIME = ORDER_CREATION_TIME;
	}

	public String getCREDIT_CONTROL_AREA() {
		return CREDIT_CONTROL_AREA;
	}

	public void setCREDIT_CONTROL_AREA(String CREDIT_CONTROL_AREA) {
		this.CREDIT_CONTROL_AREA = CREDIT_CONTROL_AREA;
	}

	public Integer getSOLD_TO_PARTY() {
		return SOLD_TO_PARTY;
	}

	public void setSOLD_TO_PARTY(Integer SOLD_TO_PARTY) {
		this.SOLD_TO_PARTY = SOLD_TO_PARTY;
	}

	public Double getORDER_AMOUNT() {
		return ORDER_AMOUNT;
	}

	public void setORDER_AMOUNT(Double ORDER_AMOUNT) {
		this.ORDER_AMOUNT = ORDER_AMOUNT;
	}

	public Date getREQUESTED_DELIVERY_DATE() {
		return REQUESTED_DELIVERY_DATE;
	}

	public void setREQUESTED_DELIVERY_DATE(Date REQUESTED_DELIVERY_DATE) {
		this.REQUESTED_DELIVERY_DATE = REQUESTED_DELIVERY_DATE;
	}

	public String getORDER_CURRENCY() {
		return ORDER_CURRENCY;
	}

	public void setORDER_CURRENCY(String ORDER_CURRENCY) {
		this.ORDER_CURRENCY = ORDER_CURRENCY;
	}

	public String getCREDIT_STATUS() {
		return CREDIT_STATUS;
	}

	public void setCREDIT_STATUS(String CREDIT_STATUS) {
		this.CREDIT_STATUS = CREDIT_STATUS;
	}

	public Integer getCUSTOMER_NUMBER() {
		return CUSTOMER_NUMBER;
	}

	public void setCUSTOMER_NUMBER(Integer CUSTOMER_NUMBER) {
		this.CUSTOMER_NUMBER = CUSTOMER_NUMBER;
	}

	public Double getAMOUNT_IN_USD() {
		return AMOUNT_IN_USD;
	}

	public void setAMOUNT_IN_USD(Double AMOUNT_IN_USD) {
		this.AMOUNT_IN_USD = AMOUNT_IN_USD;
	}

	public Long getUNIQUE_CUST_ID() {
		return UNIQUE_CUST_ID;
	}

	public void setUNIQUE_CUST_ID(Long UNIQUE_CUST_ID) {
		this.UNIQUE_CUST_ID = UNIQUE_CUST_ID;
	}
}