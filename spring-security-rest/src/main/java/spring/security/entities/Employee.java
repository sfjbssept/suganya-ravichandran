package spring.security.entities;

import java.util.Objects;

public class Employee {

	private String name;
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Employee(String name, String role) {

		this.name = name;
		this.role = role;
	}

	public Employee() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(name, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee employee = (Employee) obj;
		
		return Objects.equals(name, employee.name) && Objects.equals(role, employee.role);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", role=" + role + "]";
	}

}
