package com.highradius.model;
import java.util.ArrayList;

public class AnalyticsModel {
    private ArrayList<String> DISTRIBUTION_CHANNEL;
    private ArrayList<Integer> CUSTOMER_NUMBER;
    private ArrayList<Double> AMOUNT_IN_USD;

    public ArrayList<String> getDISTRIBUTION_CHANNEL() {
        return DISTRIBUTION_CHANNEL;
    }

    public void setDISTRIBUTION_CHANNEL(ArrayList<String> DISTRIBUTION_CHANNEL) {
        this.DISTRIBUTION_CHANNEL = DISTRIBUTION_CHANNEL;
    }

    public ArrayList<Integer> getCUSTOMER_NUMBER() {
        return CUSTOMER_NUMBER;
    }

    public void setCUSTOMER_NUMBER(ArrayList<Integer> CUSTOMER_NUMBER) {
        this.CUSTOMER_NUMBER = CUSTOMER_NUMBER;
    }
    
    public ArrayList<Double> getAMOUNT_IN_USD() {
    	return AMOUNT_IN_USD;
    }
    
    public void setAMOUNT_IN_USD(ArrayList<Double> AMOUNT_IN_USD) {
    	this.AMOUNT_IN_USD = AMOUNT_IN_USD;
    }
    

}
