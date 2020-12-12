package MainPkg;

import java.util.Scanner;

import com.DTO.DepartmentDTO;

public class StartApp {

	public static void main(String [] args) {
		
		DepartmentDTO dtp = new DepartmentDTO();
	}
	
	public void Start() {
		
		System.out.println("================================================================");
		System.out.println("---ABC COMPANY---");
		System.out.println("=================================================================");
		boolean quit = false;
		
		String line = null;
		
		Scanner input = new Scanner(System.in);
		
		while(!quit) {
			
			System.out.println("Add a new employee option 1");
			System.out.println("Add a new project 2");
			System.out.println("Add a new department 3");
			System.out.println("Update an existing employee 4");
			System.out.println("Update an existing project 5");
			System.out.println("Update an existing department 6");
			System.out.println("Get all employees 7");
			System.out.println("Get all projects 8");
			System.out.println("Get all departments 9");
			System.out.println("");

			
		}
	}
}
