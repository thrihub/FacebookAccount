package com.mysql.jdbc;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class FacebookAccountCreation {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Thriveni";
        String username = "root";
        String password = "admin";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String user = scanner.nextLine();
        System.out.println("Enter password: ");
        String pass = scanner.nextLine();
        scanner.close();

        String insertQuery = "INSERT INTO facebook_users (username, password) VALUES (?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver class loaded successfully");

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Established connection between Java and SQL");

            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Account created successfully");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
