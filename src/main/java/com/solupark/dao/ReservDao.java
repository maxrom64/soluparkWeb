package com.solupark.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import com.solupark.reservation.*;
/**
 * Cette classe gère les réservations de parkings dans une base de données MySQL.
 * Elle fournit des méthodes pour charger un pilote JDBC, établir une connexion à la base de données,
 * et réserver un parking.
 * 
 * @author Maxime ROMERO
 */
public class ReservDao {
	 private String dburl = "jdbc:mysql://localhost:3306/solupark";				//**URL de la base de données MySQL.*/
	 private String dbuname = "root";											//** Nom d'utilisateur de la base de données MySQL.*/	
	 private String dbpassword = "root";										//** Mot de passe de la base de données MySQL.*/
	 private String dbdriver = "com.mysql.cj.jdbc.Driver";						//**Pilote de la base de données MySQL.*/

	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Cette méthode retourne une connexion à la base de données.
	 * Les informations de connexion (url, nom d'utilisateur, mot de passe) sont stockées dans des variables d'instance.
	 * 
	 * @return Une connexion à la base de données.
	 */
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbuname, dbpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	Cette méthode permet de réserver un parking pour un utilisateur donné, en enregistrant les informations de la réservation dans la base de données.
	@param reservation l'objet Reservation contenant les informations de la réservation à enregistrer (park_id, date_debut, date_fin).
	@param park_id le park_id du parking à réserver.
	@return une chaîne de caractères indiquant si la réservation a été effectuée avec succès ou non.
	*/
	public String reserv(Reservation reservation, String park_id) {
		loadDriver(dbdriver);																						// on charge le pilote JDBC dans la mémoire
		Connection con = getConnection();																			// methode pour retourner une instance connection
		String sql_user = "select user_id from parking where park_id= ?";											// instruction SQL pour inserer dans la table parking les paramètres
		String sql = "insert into reservation(park_id,user_id, date_debut, date_fin) values (?,?,?,?)";				// instruction SQL pour inserer dans la table reservation les paramètres
		String result="Parking réservé";																			// initialisation d'une variable avec la valeur "utilisateur inscrit"
		String user_id= "";																							//
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
