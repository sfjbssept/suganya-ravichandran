package com.rabbit.mq.producer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.rabbit.mq.config.MessagingConfig;
import com.rabbit.mq.entities.Employee;
import com.rabbit.mq.entities.EmployeeStatus;

@RestController
@RequestMapping("/Employee")
public class EmployeePublisher {
	
	@Autowired
	RabbitTemplate restTemplate;

	
	@PostMapping("/CompanyName")
	public String saveEmployee(@RequestBody Employee emp) {
		emp.setEmpId(UUID.randomUUID().toString());
		
		EmployeeStatus employeeStatus= new EmployeeStatus(emp,"joined","I joined recently");
		restTemplate.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,employeeStatus);
		return "Success";
	}
	
	

}
