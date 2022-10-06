package com.rabbit.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbit.mq.config.MessagingConfig;
import com.rabbit.mq.entities.EmployeeStatus;

@Component
public class User {
	@RabbitListener(queues = MessagingConfig.QUEUENAME)
	public void consumeMessage(EmployeeStatus employeeStatus) {
		System.out.println("Message Recived"+employeeStatus.getMessage());
	}
	
	

}
