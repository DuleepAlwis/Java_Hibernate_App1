package com.DTO;

import java.util.ArrayList;

public class DepartmentDTO {

	private long id;
	private String name;
	private EmployeeDTO manager;
	private String location;
	private ArrayList<EmployeeDTO> empList;
	private ArrayList<ProjectDTO> prjList;

	public DepartmentDTO() {
		super();
		
	}

	public DepartmentDTO(long id, String name, EmployeeDTO manager, String location) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.location = location;
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

	public EmployeeDTO getManager() {
		return manager;
	}

	public void setManager(EmployeeDTO manager) {
		this.manager = manager;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setEmployeeList(ArrayList<EmployeeDTO> employeeList) {
		
		this.empList = employeeList;
	}
	
	public ArrayList<EmployeeDTO> getEmployeeList(){
		
		return this.empList;
	}
	
	public ArrayList<ProjectDTO> getPrjList() {
		return prjList;
	}

	public void setPrjList(ArrayList<ProjectDTO> prjList) {
		this.prjList = prjList;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", name=" + name + ", manager=" + manager + ", location=" + location + "]";
	}
	
	
	
}
