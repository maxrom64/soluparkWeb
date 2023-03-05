package com.firebase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import com.solupark.reservation.*;

public class ReservDao {
	 private String dburl = "jdbc:mysql://localhost:3306/solupark";
	 private String dbuname = "root";
	 private String dbpassword = "root";
	 private String dbdriver = "com.mysql.cj.jdbc.Driver";

	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbuname, dbpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public String reserv(Reservation reservation, String park_id) {
		loadDriver(dbdriver);
		Connection con = getConnection();
		String sql_user = "select user_id from parking where park_id= ?";
		String sql = "insert into reservation(park_id,user_id, date_debut, date_fin) values (?,?,?,?)";
		String result="Parking réservé";
		String user_id= "";
		try {
			Statement state = con.createStatement();
			PreparedStatement ps0 = con.prepareStatement(sql_user);
			ps0.setString(1, park_id);
			ResultSet resultat = ps0.executeQuery();
			resultat.next();
			user_id = resultat.getString(1);
			resultat.close();
			state.close();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reservation.getPark_id());
			ps.setString(2, user_id);
			ps.setString(3, reservation.getDate_debut());
			ps.setString(4, reservation.getDate_fin());
			ps.executeUpdate();
			} catch (SQLException e) {
				 result="Parking non réservé";
				 e.printStackTrace();
			 }
			 return result;
			 }
	}
