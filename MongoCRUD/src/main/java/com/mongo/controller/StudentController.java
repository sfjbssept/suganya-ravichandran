package com.mongo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.entities.Student;
import com.mongo.repo.StudentRepository;
@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	@PostMapping("/addStudent")
	ResponseEntity<?> addStudent(@RequestBody Student student){
		Student save = this.repo.save(student);
		return ResponseEntity.ok(save);
		
	}
	
	@GetMapping("/getStudent")
	ResponseEntity<?> getStudent(){
		return ResponseEntity.ok(this.repo.findAll());
	}
	
	@PutMapping("/updateStudent/{id}")
	ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable("id") Integer id){
		Student student1 = repo.findById(id).get();
		student1.setId(id);
		student1.setName(student.getName());
		student1.setCity(student.getCity());
		student1.setCollege(student.getCollege());
		repo.save(student1);
		return ResponseEntity.ok(student1);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@RequestBody Student student){
		repo.delete(student);
		return "deleted successfully";
	}
	
	

}
