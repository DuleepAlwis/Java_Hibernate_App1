package com.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.DTO.DepartmentDTO;
import com.DTO.EmployeeDTO;
import com.Service.CRUDService;
import com.ServiceImpl.DepartmenServiceImpl;
import com.ServiceImpl.EmployeeServiceImpl;

public class DepartmentController {

	private static Logger logger = Logger.getLogger(DepartmentController.class.getName());
	private static CRUDService<DepartmentDTO> departmentService;
	private static CRUDService<EmployeeDTO> empService;

	public DepartmentController() throws SQLException {
		departmentService = new DepartmenServiceImpl();
		empService = new EmployeeServiceImpl();

	}
	
	public static boolean save(Scanner input) {
		
		 String line = null;
		 BufferedReader br = null;
		 String [] headers;
		 ArrayList<String> values = new ArrayList<String>();
		 ArrayList<ArrayList<String>> linesValues = new ArrayList<ArrayList<String>>();
		 DepartmentDTO d_dto = new DepartmentDTO();
		 EmployeeDTO e_dto = new EmployeeDTO();
		 boolean result = false;
		 int number = 0;
		 
		 System.out.print("Values from a csv file, file name : ");

		 line = input.nextLine();
		 
		 if(line!=null && line.length()>0) {
			 
			 File file = new File(line);
			 
			  try {
				br = new BufferedReader(new FileReader(file));
				while((line = br.readLine())!=null){
					if(number==0) {
						continue;
					}
					else {
						Arrays.stream(line.split(",")).forEach(str->values.add(str));
						d_dto.setName(values.get(0));
						e_dto = empService.retrieveByName(values.get(1));
						
						d_dto.setManager(e_dto);
						d_dto.setLocation(values.get(2));
						departmentService.save(d_dto);
						number++;
						
					}
				}
				logger.log(Level.INFO,("Inserted records "+number));
				result = (number>0?true:false);
				
			} catch (IOException e) {
				logger.log(Level.WARNING,e.getMessage());
			}
		 }
		 else {
			 System.out.println("Enter data from console | Exit (quit)");
			 line = " ";
			 while(!(line.equals("quit"))){
				 line = " ";

				 while(line != null && line.equals(" ") && !(line.equals("quit"))) {
					 System.out.print("Department name : ");

					 line = input.nextLine();

					 if(line == null || line.equals(" ")) {
						 System.out.println("Please enter a value");

					 }
					 else{
						 d_dto.setName(line);
					 }
				 }
				
				 line = " ";
				 while(line != null && (line.equals(" ")) && !(line.equals("quit"))) {
					 System.out.print("\nDepartment Manager : ");

					 line = input.nextLine();

					 if(line == null || line.equals(" ")) {
						 System.out.println("Please enter a value");

					 }
					 else {
						 e_dto = empService.retrieveByName(line);
						 d_dto.setManager(e_dto);

					 }
				 }

				 line = " ";
				
				 while(line != null && line.equals(" ") && !(line.equals("quit"))) {
					 System.out.print("\nDepartment location : ");

					 line = input.nextLine();
					 if(line == null || line.equals(" ")) {
						 System.out.println("Please enter a value");

					 }			
					 else {
						 d_dto.setLocation(line);
					 }
				 }

				 result = (departmentService.save(d_dto)!=null?true:false);
				 System.out.print("Want to quit(y/n)");
				 line = input.nextLine();
				 if(line!=null) {
					 if(line.equalsIgnoreCase("y")) {
						 break;
					 }
				 }
				 
			 }
					 

			 
		 }
		 
		 return result;
	}
}

