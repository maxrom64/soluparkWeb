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
		String user_id= "";																							// declaration d'une variable de type chaines de caractères vide
		try {
			Statement state = con.createStatement();																// Création un objet Statement à partir de l'objet Connection existant, et l'assigne à la variable d'état "state".
			PreparedStatement ps0 = con.prepareStatement(sql_user);													// préparation de la requête SQL en utilisant la chaine de caractère sql_user
			ps0.setString(1, park_id);																				// on affecte la valeur variable park_id au premier paramètre de la requête préparée ps0
			ResultSet resultat = ps0.executeQuery();																// execution de la requête ps0 et stockage du resultat dans "resultat"
			resultat.next();																						// on parcours les resultats de la reqûete vers la prochaine ligne
			user_id = resultat.getString(1);																		// on récupère la valeur de la première colonne de la ligne	
			resultat.close();													
			state.close();
			PreparedStatement ps = con.prepareStatement(sql);														// préparation de la requête SQL en utilisant la chaine de caractère sql
			ps.setString(1, reservation.getPark_id());																// on affecte la valeur de l'identifiant du parking de la réservation "reservation"
			ps.setString(2, user_id);																				// on affecte la valeur de l'identifiant de l'utilisateur "user_id" au deuxième paramètre de la requête préparée "ps"
			ps.setString(3, reservation.getDate_debut());															// on affecte la valeur de la date de début de la réservation "reservation" au troisième paramètre de la requête préparée "ps"
			ps.setString(4, reservation.getDate_fin());																// on affecte la valeur de la date de fin de la réservation "reservation" au quatrième paramètre de la requête préparée "ps".
			ps.executeUpdate();																						// on exécute la requête préparée "ps" pour insérer la nouvelle ligne dans la table de réservations.
			} catch (SQLException e) {
				 result="Parking non réservé";
				 e.printStackTrace();
			 	}	
			 return result;																							//on renvoie la valeur stockée de la variable resultat 
			 }
	}
