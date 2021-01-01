package com.Controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.DTO.EmployeeDTO;
import com.ServiceImpl.DepartmenServiceImpl;
import com.ServiceImpl.EmployeeServiceImpl;
import com.ServiceImpl.ProjectServiceImpl;

public class EmployeeController {

	private EmployeeServiceImpl empServiceImpl;
	private DepartmenServiceImpl departmentServiceImpl;
	private ProjectServiceImpl projectServiceImpl;
	
	public EmployeeController() throws SQLException {
		this.empServiceImpl = new EmployeeServiceImpl();
		this.departmentServiceImpl = new DepartmenServiceImpl();
		this.projectServiceImpl = new ProjectServiceImpl();
	}
	
	public boolean save(Scanner input) {
		
		EmployeeDTO empDTO = new EmployeeDTO();
		System.out.println("---------------Enter employee details------------------");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String line = "";
		
		while(line!=null) {
			while(line==null || line.equals("")) {
				System.out.print("Employee name : ");
				line = input.nextLine();
			}
			empDTO.setName(line);
			line = "";
			
			while(line==null || line.equals("")) {
				System.out.print("Employee salary : ");
				line = input.nextLine();
			}
			
			empDTO.setSalary(Double.parseDouble(line));
			line = "";
			
			while(line==null || line.equals("")) {
				System.out.print("Employee join date : ");
				line = input.nextLine();
			}
			
			//empDTO.setJoin_date(line);
			line = "";
			
			while(line==null || line.equals("")) {
				System.out.print("Employee address : ");
				line = input.nextLine();
			}
			
			while(line==null || line.equals("")) {
				System.out.print("Employee city : ");
				line = input.nextLine();
			}
			
			while(line==null || line.equals("")) {
				System.out.print("Employee district : ");
				line = input.nextLine();
			}
			while(line==null || line.equals("")) {
				System.out.print("Employee supervisor : ");
				line = input.nextLine();
			}
			
			while(line==null || line.equals("")) {
				System.out.print("Employee role : ");
				line = input.nextLine();
			}

		}
		return true;
		
	}
	
	public boolean save(String fileName) {
		return true;
	}
}
