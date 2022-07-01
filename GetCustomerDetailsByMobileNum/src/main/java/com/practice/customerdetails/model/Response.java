package com.practice.customerdetails.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Response
{
   private String status;
   private String message;
   private List<CustomerDetails> customerDetails;



    public Response()
    {

    }

    public Response(String status, String message, ArrayList<CustomerDetails> customerDetails) {
        this.status = status;
        this.message = message;
        this.customerDetails = customerDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CustomerDetails> getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(List<CustomerDetails> customerDetails) {
        this.customerDetails = customerDetails;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", customerDetails=" + customerDetails +
                '}';
    }
}
