package com.firebase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

public static boolean checkUser(String email,String mdp) 
	    {
	        boolean st =false;
	        try {

	            //loading drivers for mysql
	            Class.forName("com.mysql.jdbc.Driver");

	            //creating connection with the database
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/solupark","root","root");
	            PreparedStatement ps = con.prepareStatement("select * from user where email=? and mdp=?");
	            ps.setString(1, email);
	            ps.setString(2, mdp);
	            ResultSet rs =ps.executeQuery();
	            st = rs.next();

	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	        return st;                 
	    }
	}