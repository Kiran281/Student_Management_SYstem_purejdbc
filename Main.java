package com.studentdata;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentOperations operations = new StudentOperations();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n=== Simple Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    operations.addStudent();
                    break;
                case 2:
                    operations.viewAllStudents();
                    break;
                case 3:
                    operations.updateStudent();
                    break;
                case 4:
                    operations.deleteStudent();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
