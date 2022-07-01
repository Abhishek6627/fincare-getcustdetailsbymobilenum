package com.practice.customerdetails.model;

public class CustomerDetails
{
    private String customerName;
    private String aadharReferenceNumber;
    private  String amlRiskRating;
    private String customerNumber;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAadharReferenceNumber() {
        return aadharReferenceNumber;
    }

    public void setAadharReferenceNumber(String aadharReferenceNumber) {
        this.aadharReferenceNumber = aadharReferenceNumber;
    }

    public String getAmlRiskRating() {
        return amlRiskRating;
    }

    public void setAmlRiskRating(String amlRiskRating) {
        this.amlRiskRating = amlRiskRating;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}