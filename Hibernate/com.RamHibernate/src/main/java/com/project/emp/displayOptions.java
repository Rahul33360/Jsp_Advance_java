package com.project.emp;

import java.util.Scanner;

public class displayOptions {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			System.out.println(
					"Select Any The Options \n1.Insert\n2.Fetch By Id\n3.Fetch By Name\n4.Fetch Female Emp\n5.Fetch Male Emp\n6.Fetch All\n7.Fetch By Grade\n8.Update Emp By Id\n9.Remove By Id\n10.Exit");
			int input = sc.nextInt();
			switch (input) {
				case 1: {
					// insert
					allOperations.insert();
					break;
				}
	
				case 2: {
					// fetchById
					allOperations.fetchById();
					break;
				}
	
				case 3: {
					// fetchByName
					allOperations.fetchByName();
					break;
				}
	
				case 4: {
					// fetchFemaleEmp
					allOperations.fetchFemaleEmp();
					break;
				}
	
				case 5: {
					// fetchMaleEmp
					allOperations.fetchMaleEmp();
					break;
				}
	
				case 6: {
					// fetchAll
					allOperations.fetchAll();
					break;
				}
	
				case 7: {
					// fetchByGrade
					allOperations.fetchByGrade();
					break;
				}
	
				case 8: {
					// updateEmpById
					allOperations.updateEmpById();
					break;
				}
	
				case 9: {
					// removeById
					allOperations.removeById();
					break;
				}
	
				case 10: {
					check = false;
					break;
				}
				default: {
					System.out.println("Wrong Input !!!");
					break;
				}
			}
			System.out.println();
		} while (check);
	}
}
