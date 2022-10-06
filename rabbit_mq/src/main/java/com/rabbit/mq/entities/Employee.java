package com.rabbit.mq.entities;

public class Employee {
	
	private String empId;
	private String name;
	private String salary;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Employee(String empId, String name, String salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "MessageEntity [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
	}
	
	

}
