package com.DTO;

import java.util.Date;

public class EmployeeDTO {

	//id, name, salary, join_date, address, city, district, supervisor
	private long id;
	private String name;
	private double salary;
	private Date join_date;
	private String address;
	private String city;
	private String district;
	private long supervisor;
	private ProjectDTO project;
	private DepartmentDTO department;
	private String role;

	
	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(long id, String name, double salary, Date join_date, String address, String city, String district,
			long supervisor,String role) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.join_date = join_date;
		this.address = address;
		this.city = city;
		this.district = district;
		this.supervisor = supervisor;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public long getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(long supervisor) {
		this.supervisor = supervisor;
	}
	
	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}
	
	public String getRole() {
		return role;
	}
	

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", join_date=" + join_date
				+ ", address=" + address + ", city=" + city + ", district=" + district + ", supervisor=" + supervisor
				+ "]";
	}
	
	
	
	
	


}
