package com.school.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/SchoolDetails")
public class SchoolServiceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{schoolName}")
	public String getStudents(@PathVariable String schoolName) {
		System.out.println(schoolName);
		String requestUrl="http://student-service/getStudentDetails/"+ schoolName;
		HttpHeaders httpHeaders= new HttpHeaders();
		HttpEntity<String> httpEntity= new HttpEntity<String>(httpHeaders);
		
		ResponseEntity<String> response= restTemplate.exchange(requestUrl, HttpMethod.GET, httpEntity, String.class);
		String student=response.getBody();
		
		return "School Name -"+ schoolName+ "\n Student details " +student;
	}

}
