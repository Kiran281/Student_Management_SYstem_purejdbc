package com.studentdata;

import java.sql.*;
import java.util.Scanner;

public class StudentOperations {
    private Connection connection;

    public StudentOperations() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addStudent() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter Course: ");
            String course = scanner.nextLine();

            String query = "INSERT INTO students(name, age, course) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.executeUpdate();

            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllStudents() {
        try {
            String query = "SELECT * FROM students";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("ID\tName\tAge\tCourse");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" +
                                   rs.getInt("age") + "\t" + rs.getString("course"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Student ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter New Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter New Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter New Course: ");
            String course = scanner.nextLine();

            String query = "UPDATE students SET name = ?, age = ?, course = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setInt(4, id);
            ps.executeUpdate();

            System.out.println("Student updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();

            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Student deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
