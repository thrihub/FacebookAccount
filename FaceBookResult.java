package com.mysql.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;
public class FaceBookResult {
    private static final String URL = "jdbc:mysql://localhost:3306/Thriveni";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    	
    	// Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Established the connection between java and Sql");
        
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        
        
        
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }

        connection.close();
        scanner.close();
    }
}