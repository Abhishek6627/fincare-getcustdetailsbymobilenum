package com.practice.customerdetails.controller;


import com.practice.customerdetails.model.CustomerMobileNum;
import com.practice.customerdetails.model.Response;
import com.practice.customerdetails.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @PostMapping("/getMobile")
    public Response getDetails (@RequestBody CustomerMobileNum customerMobileNum)
    {

         return  customerDetailsService.getDetails(customerMobileNum);
    }
}
