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
		
		System.out.println("=================================================================================");
		System.out.println("\t\t\t---Programme Starts---");
		System.out.println("=================================================================================");
		boolean quit = false;
		
		try {
			DepartmentController departmentController = new DepartmentController();
			
			
			String line = null;
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("\t\t\tAdd a new employee option 1");
			System.out.println("\t\t\tAdd a new project 2");
			System.out.println("\t\t\tAdd a new department 3");
			System.out.println("\t\t\tUpdate an existing employee 4");
			System.out.println("\t\t\tUpdate an existing project 5");
			System.out.println("\t\t\tUpdate an existing department 6");
			System.out.println("\t\t\tGet all employees 7");
			System.out.println("\t\t\tGet all projects 8");
			System.out.println("\t\t\tGet all departments 9");
			System.out.println("\t\t\tQuit(Type quit)");

			while(!quit) {
				
				System.out.print("\t\t\tYour option: ");

				
				line = input.nextLine();
				if(line!=null && !line.equalsIgnoreCase("") && !line.equalsIgnoreCase("\n") && !line.equalsIgnoreCase("quit")) {
					int option = Integer.parseInt(line);
					
					switch(option) {
						case 1:departmentController.save(input);break;

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
