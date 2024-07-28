package com.mysql.jdbc;

import java.sql.*;


public class FetchingFacebookDetails {
     static String URL = "jdbc:mysql://localhost:3306/Thriveni";
     static String USER = "root";
     static String PASSWORD = "admin";
    Statement st=null;
    static String query="select * from facebook_users";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    	 
    	// Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");

        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Established the connection between java and Sql");
        System.out.println();
        
        
        Statement st=con.createStatement();
		ResultSet res=st.executeQuery(query);
		while(res.next())
		{
			System.out.println(res.getInt(1)+"   "+res.getString(2)+"   "+res.getString(3));
		}
    }
}