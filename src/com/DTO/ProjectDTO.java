package com.DTO;

import java.util.ArrayList;
import java.util.Date;

public class ProjectDTO {

	//id, name, description, budget, start_date, end_date
	
	private long id;
	private String name;
	private String description;
	private double budget;
	private Date start_date;
	private Date end_date;
	private Date est_end_date;

	private ArrayList<EmployeeDTO> empList;

	
	public ProjectDTO() {
		super();
	}

	public ProjectDTO(long id, String name, String description, double budget, Date start_date, Date end_date,
			Date est_end_date, ArrayList<EmployeeDTO> empList) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.budget = budget;
		this.start_date = start_date;
		this.end_date = end_date;
		this.est_end_date = est_end_date;
		this.empList = empList;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getEst_end_date() {
		return est_end_date;
	}

	public void setEst_end_date(Date est_end_date) {
		this.est_end_date = est_end_date;
	}

	public ArrayList<EmployeeDTO> getEmpList() {
		return empList;
	}

	public void setEmpList(ArrayList<EmployeeDTO> empList) {
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "ProjectDTO [id=" + id + ", name=" + name + ", description=" + description + ", budget=" + budget
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", est_end_date=" + est_end_date
				+ ", empList=" + empList + "]";
	}

	
	


}
