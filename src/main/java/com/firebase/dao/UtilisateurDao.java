package com.firebase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.solupark.utilisateur.Utilisateur;
 
public class UtilisateurDao {
 private String dburl = "jdbc:mysql://localhost:3306/solupark";
 private String dbuname = "root";
 private String dbpassword = "root";
 private String dbdriver = "com.mysql.cj.jdbc.Driver";

 public void loadDriver(String dbDriver)
 {
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
 
 public String insert(Utilisateur utilisateur) {
 loadDriver(dbdriver);
 Connection con = getConnection();
 String sql = "insert into user(user_id, nom, prenom, email, mdp, mdp2) values (DEFAULT,?,?,?,?,?)";
 String result="Utilisteur inscrit";
 try {
 PreparedStatement ps = con.prepareStatement(sql);
 ps.setString(1, utilisateur.getNom());
 ps.setString(2, utilisateur.getPrenom());
 ps.setString(3, utilisateur.getEmail());
 ps.setString(4, utilisateur.getMdp());
 ps.setString(5, utilisateur.getMdp2());
 ps.executeUpdate();
 } catch (SQLException e) {

 result="Utilisateur pas enregistré";
 e.printStackTrace();
 }
 return result;

 }
}