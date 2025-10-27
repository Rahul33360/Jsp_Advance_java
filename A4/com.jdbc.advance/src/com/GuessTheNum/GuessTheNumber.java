package com.GuessTheNum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GuessTheNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name and Age ");
		String name = sc.next();
		int age = sc.nextInt();

		int score = 0;
		int rand = (int) ((Math.random() * 9) + 1);

		for (int i = 0; i < 3; i++) {
			System.out.println("Enter the Guessed Number: ");
			int guess = sc.nextInt();
			if (rand == guess) {
				System.out.println("Correct guess!");
				score += 10;
				rand = (int) ((Math.random() * 9) + 1); // new random number
			} else {
				System.out.println("Wrong guess! ");
			}
		}

		try {
			// Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish connection
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/cjd_a4?user=root&password=Rahul&useSSL=false");

			// Create Statement
			Statement state = connection.createStatement();

			// SQL syntax (values should be inserted, not column names)
			String sql = "INSERT INTO premium_student values("+age+",'"+name+"',"+score+") ";

			state.execute(sql); // executeUpdate for insert/update/delete
			System.out.println("Data inserted successfully!");

			// Close resources
//			state.close();
//			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println(name + " age " + age + " scored " + score);

	}
}
