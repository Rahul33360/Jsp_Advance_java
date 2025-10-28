package Task;

import java.util.Scanner;

public class EmpDriver {
	
	static Scanner s;
	static boolean flag= true;

	public static void main(String[] args) {
		s= new Scanner(System.in);
		while(flag) {
		System.out.println("Select the Options To perfrom "+"\n"+"1 :- Insert Data"+"\n"+"2 :- Delete Data"+"\n"+"3 :- Fetch Data"+"\n"+"4 :- Exit"+"\n");
		int option = s.nextInt();
		switch(option) {
		case 1:
			addEmp();
			break;
		case 2:
			removeEmp();
			break;
		case 3:
			fetchEmp();
			break;
		case 4:
			exit();
			break;
			default:
				System.out.println("Select The Valid Option"+"\n");
			}
		}
	}
	private static void addEmp() {
		System.out.println("Enter the Emp ID");
		int id = s.nextInt();
		System.out.println("Enter the Emp Name");
		String name=s.next();
		System.out.println("Enter the Emp Age");
		int age =s.nextInt();
		Emp e= new Emp();
		e.setId(id);
		e.setName(name);
		e.setAge(age);
		if (EmpService.add(e)) {
			System.out.println("Employee Got Added !!"+"\n");
		}
		else
			System.out.println("Employe Not Added !!"+"\n");
	}
	private static void removeEmp() {
		System.out.println("Enter the Emp ID to Remove"+"\n");
		int id = s.nextInt();
		if (EmpService.remove(id)) {
			System.out.println("Employee Got Removed !!"+"\n");
		}
		else
			System.out.println("Employe Not Removed !!"+"\n");
	}
	private static void fetchEmp() {
		EmpService.fetch();
	}
	private static void exit() {
		
		if (EmpService.exit()) {
			System.out.println("Exited Successfully");
		}
		else
			System.out.println("Some problem hapends"+"\n");
		flag = false;
	}	
	
}
