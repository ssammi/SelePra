package com.sam.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


import org.testng.annotations.Test;

	public class DatabaseConSSH {
		
	   public static void main(String[] args){
		   
		   Connection con = null;
		   String url = "jdbc:mysql://127.0.0.1:3306/";
		   String databaseName = "northwind";
		   String username = "root";
		   String password = "zhou1993";
		   
		   try{
			   Class.forName("com.mysql.jdbc.Driver");
			   con = DriverManager.getConnection(url + databaseName, username, password);
			   String sqlQuerry = "SELECT CustomerID FROM `northwind`.`Customers`";
			   Statement statement = con.createStatement();
			   ResultSet result = statement.executeQuery(sqlQuerry);
			   result.next();
			   System.out.println(result.getString("CustomerID"));
			   
			   
			   
		   }catch(Exception e){
			   System.out.println(e);
			   
		   }finally{
			   if(con != null){
				   con = null;
			   }
			   
		   }
	   }
}