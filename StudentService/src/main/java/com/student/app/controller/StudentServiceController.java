package com.student.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.entities.Student;

@RestController
public class StudentServiceController {

	private static Map<String, List<Student>> schoolDb = new HashMap<String, List<Student>>();

	static {
		schoolDb = new HashMap<String, List<Student>>();

		List<Student> lst = new ArrayList<Student>();

		Student std = new Student("Suganya", "10th");
		lst.add(std);

		Student std1 = new Student("Dharmesh", "9th");
		lst.add(std1);

		schoolDb.put("School1", lst);
	}

	@RequestMapping(value="/getStudentDetails/{schoolName}", method=RequestMethod.GET)
	public List<Student> getStudentDetails(@PathVariable String schoolName){
		
		System.out.println("Getting student details"+schoolName);
		System.out.println("Getting student details"+schoolDb.get(schoolName));
		List<Student> studentList= schoolDb.get(schoolName);
		if(studentList==null) {
			studentList=  new ArrayList<Student>();
			Student std= new Student("not found", "NA");
			studentList.add(std);
		}
		return studentList;
	}
}
