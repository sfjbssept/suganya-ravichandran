package com.gateway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value = "/getSchoolDetails/{schoolName}", method = RequestMethod.GET)
	public String getStudentDetails(@PathVariable String schoolName) {
		
		System.out.println("Displaying details based on schoolName"+schoolName);
		String response=restTemplate.exchange("http://school-service/SchoolDetails/{schoolName}", HttpMethod.GET,
				null,new ParameterizedTypeReference<String>() {
		},schoolName).getBody();
		
		System.out.println("Response received"+ response);
		
		return "School Name"+ schoolName+ "\nStudentdetails"+response;
	}

}
