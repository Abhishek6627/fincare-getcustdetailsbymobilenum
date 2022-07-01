package com.practice.customerdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GetCustomerDetailsByMobileNumApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetCustomerDetailsByMobileNumApplication.class, args);
	}

}
