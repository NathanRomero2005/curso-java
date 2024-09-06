package application;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// Creating List<Employee>
		List<Employee> list = new ArrayList<>();
		
		// Getting the employee's ID
		System.out.println("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Emplyoee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while (hasId(list, id)) {
				System.out.println("Id already taken! Try again: ");
				id = sc.nextInt();
			}
			
			// Getting other employee's data
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			list.add(emp);
		}
		
		// Getting who will get the increase
		System.out.println();
		System.out.println("Enter the employee ID that will have salary increase : ");
		int idsalary = sc.nextInt();
		
		// Searching if the ID exists in the list or not
		Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);
		
		// Show if the ID exists
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}
		
		// Show the list of employees (with the increase)
		System.out.println();
		System.out.println("List of employees:");
		
		for (Employee e : list) {
			System.out.println(e);
		}
		
		sc.close();
	}

	// Method to get the position of employees ID
	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	// Method to search the employee's ID
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
