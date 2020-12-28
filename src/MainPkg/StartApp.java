package MainPkg;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Controller.DepartmentController;
import com.DTO.DepartmentDTO;

public class StartApp {

	private static Logger logger = Logger.getLogger(DepartmentController.class.getName());

	public static void main(String [] args) {
		
		DepartmentDTO dtp = new DepartmentDTO();
		Start();
	}
	
	public static void Start() {
		
		System.out.println("================================================================");
		System.out.println("---ABC COMPANY---");
		System.out.println("=================================================================");
		boolean quit = false;
		
		try {
			DepartmentController departmentController = new DepartmentController();
			
			
			String line = null;
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Add a new employee option 1");
			System.out.println("Add a new project 2");
			System.out.println("Add a new department 3");
			System.out.println("Update an existing employee 4");
			System.out.println("Update an existing project 5");
			System.out.println("Update an existing department 6");
			System.out.println("Get all employees 7");
			System.out.println("Get all projects 8");
			System.out.println("Get all departments 9");
			System.out.println("Quit(Type quit)");

			while(!quit) {
				
				System.out.print("Your option: ");

				
				line = input.nextLine();
				if(line!=null && !line.equalsIgnoreCase("") && !line.equalsIgnoreCase("\n") && !line.equalsIgnoreCase("quit")) {
					int option = Integer.parseInt(line);
					
					switch(option) {
						case 3:departmentController.save(input);break;
					}
				}
				else {
					quit = true;
					System.out.println("-------------PROGRAMME ENDS--------------------");
					System.gc();

					System.exit(1);
				}

				
			}
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
		}
		
		
	
	}
}
