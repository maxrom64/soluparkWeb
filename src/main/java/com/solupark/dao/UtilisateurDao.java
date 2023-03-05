package com.solupark.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.solupark.utilisateur.Utilisateur;
/**
Cette classe gère les utilisateurs dans une base de données MySQL. Elle fournit des méthodes pour charger un pilote JDBC,
établir une connexion à la base de données, et pour insérer un utilisateur.
@author Maxime ROMERO
*/ 
public class UtilisateurDao {											
 private String dburl = "jdbc:mysql://localhost:3306/solupark";							//**URL de la base de données MySQL.*/
 private String dbuname = "root";														//** Nom d'utilisateur de la base de données MySQL.*/	
 private String dbpassword = "root";													//** Mot de passe de la base de données MySQL.*/
 private String dbdriver = "com.mysql.cj.jdbc.Driver";									//**Pilote de la base de données MySQL.*/

 /**
 Cette méthode charge le pilote JDBC spécifié.
 @param dbDriver Le nom de la classe du pilote JDBC à charger.
 */
 public void loadDriver(String dbDriver){
	 try {
		 Class.forName(dbDriver);
	 } catch (ClassNotFoundException e) {

		 e.printStackTrace();
	 }
 	}
 
 /**
 Cette méthode établit une connexion à la base de données avec les informations de connexion spécifiées.
 @return une connexion à la base de données.
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
 Cette méthode insère un nouvel utilisateur dans la base de données.
 @param utilisateur l'utilisateur à insérer dans la base de données.
 @return une chaîne de caractère indiquant si l'utilisateur a été inséré
*/
 
 public String insert(Utilisateur utilisateur) {
 loadDriver(dbdriver);																					// on charge le pilote JDBC dans la mémoire
 Connection con = getConnection();																		// methode pour retourner une instance connection
 String sql = "insert into user(user_id, nom, prenom, email, mdp, mdp2) values (DEFAULT,?,?,?,?,?)";	// instruction SQL pour inserer dans la table user les paramètres
 String result="Utilisteur inscrit";																	// initialisation d'une variable avec la valeur "utilisateur inscrit"
 	try {
 		PreparedStatement ps = con.prepareStatement(sql);												// on préparee la requête SQL
 		ps.setString(1, utilisateur.getNom());															// on remplace le ? dans la requete SQL par la valeur correpondante nom
 		ps.setString(2, utilisateur.getPrenom());														// on remplace le ? dans la requete SQL par la valeur correpondante prenom
 		ps.setString(3, utilisateur.getEmail());														// on remplace le ? dans la requete SQL par la valeur correpondante email
 		ps.setString(4, utilisateur.getMdp());															// on remplace le ? dans la requete SQL par la valeur correpondante mdp
 		ps.setString(5, utilisateur.getMdp2());															// on remplace le ? dans la requete SQL par la valeur correpondante mdp2
 		ps.executeUpdate();																				// methode qui permet d'excuter une requête SQL
 	} catch (SQLException e) {
 		result="Utilisateur pas enregistré";
 		e.printStackTrace();
 		}
 return result;																							// message renvoyé si utilisteur enregistré ou pas enregistré
 	}
}