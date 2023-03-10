package com.solupark.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.solupark.parking.Park;
/**
 * La classe ParkDao contient plusieurs méthodes qui interagissent avec une base de données pour effectuer diverses actions liées aux places de stationnement.
 * LoadDriver(String dbDriver) est une méthode d'assistance qui charge le pilote JDBC spécifié par le paramètre dbDriver.
 * getConnection() est une méthode qui crée et renvoie un nouvel objet Connection utilisé pour se connecter à la base de données.
 * insert(Park park, String email) est une méthode qui prend un objet Park et une adresse e-mail, et ajoute une nouvelle place de parking à la base de données avec les informations de l'objet Park et le user_id associé de l'adresse e-mail.
 * listParking() est une méthode qui récupère une liste de toutes les places de parking de la base de données.
 * Listparktaille(String longueur) renvoie une liste des places de stationnement dans la base de données qui correspondent au paramètre de longueur.
 * Listparktaille2(String largeur) renvoie une liste des places de stationnement dans la base de données qui correspondent au paramètre largeur.
 * ListDispo(String date_debut, String date_fin) renvoie une liste des places de stationnement dans la base de données qui ne sont pas réservées entre les paramètres date_debut et date_fin.
 * ParkMap() renvoie une liste des places de stationnement dans la base de données avec les informations d'adresse, du code postal, de ville et de pays.
 * 
 * @author Maxime ROMERO
 *
/** Cette classe ParkDao est un objet d'accès aux données (DAO) qui fournit une interface entre l'application et la table de la base de données de stationnement.
 * Elle fournit des méthodes pour effectuer des opérations CRUD (créer, lire, mettre à jour et supprimer) sur la table.
 * 
 * @author Maxime ROMERO
 */
 
public class ParkDao {
/**
* Variable pour l'URL de la base de données
*/
 private static String dburl = "jdbc:mysql://localhost:3306/solupark";
/**
* Variable pour le nom d'utilisateur de la base de données
*/
 private static String dbuname = "root";
 /**
 * Variable pour le mot de passe de la base de données
 */
 private static String dbpassword = "root";
 /**
 * Variable for the database driver
 */
 public String dbdriver = "com.mysql.cj.jdbc.Driver";
 /**
  *  Cette méthode est utilisée pour charger le pilote de la base de données
  * @param dbDriver
  */
 public static void loadDriver(String dbDriver){
	 try {
		 Class.forName(dbDriver);
	 	}catch (ClassNotFoundException e) {
		 e.printStackTrace();
	 }
 }
 
 /**
  * Cette méthode est utilisée pour se connecter à la base de données et renvoyer un objet de connexion
  * @return Connection 
  */
 public static Connection getConnection() {
 Connection con = null;
 	try {
 		con = DriverManager.getConnection(dburl, dbuname, dbpassword);
 	} catch (SQLException e) {
 		e.printStackTrace();
 	}
 	return con;
 }
 
 /**
  * Cette méthodeest utilisée pour insérer un nouveau parc dans la base de données en établissant la connexion à la base de données
  * 
  * @param park le parking à insérer
  * @param email l'email du propriétaire du parking
  * @return une chaîne de carcatère indiquant le résultat de l'insertion, 'Parking ajouté' si succès, 'Le parking n'est pas ajouté' si échec.
  */
 public String insert(Park park, String email) {
	 loadDriver(dbdriver);																										// Définition du pilote de base de données à utiliser
	 Connection con = getConnection();																							// connexion à la base de données
	 String sql_user = "select user_id from user where email= ?";																// Requête SQL pour récupérer l'ID utilisateur de l'utilisateur avec l'adresse e-mail donnée
	 String sql = "insert into parking(user_id, address, codePostal, ville, pays, longueur, largeur) values (?,?,?,?,?,?,?)"; 	// Requête SQL pour insérer un nouvel enregistrement de stationnement dans la base de données
	 String result="Parking ajouté";																							// Définissez le résultat par défaut pour indiquer que le parking a été ajouté avec succès
	 String user_id = "";
	 try {
		 Statement state = con.createStatement();																				// création d'un objet instruction pour exécuter des requêtes SQL
		 PreparedStatement ps0 = con.prepareStatement(sql_user);																// Préparation d'un objet d'instruction pour exécuter la requête SQL afin de récupérer l'ID utilisateur
		 ps0.setString(1, email);																								// Définission du paramètre email pour la requête SQL afin de récupérer l'ID utilisateur
		 ResultSet resultat = ps0.executeQuery();																				// Exécution de la requête SQL pour récupérer l'ID utilisateur et récupérer le ResultSet
		 resultat.next();																										// Déplacement du curseur sur la première ligne du ResultSet
		 user_id = resultat.getString(1);																						// Récupération l'ID utilisateur du ResultSet
		 resultat.close();																										
		 state.close();																											// Fermeture de  l'objet d'instruction pour exécuter la requête SQL afin de récupérer l'ID utilisateur
		 PreparedStatement ps = con.prepareStatement(sql);																		// Préparation d'un objet d'instruction pour exécuter la requête SQL afin d'insérer le nouvel enregistrement de stationnement
		 ps.setNString(1, user_id);																								// Définission des paramètres de la requête SQL pour insérer le nouvel enregistrement de stationnement
		 ps.setString(2, park.getAddress());
		 ps.setString(3, park.getCodePostal());
		 ps.setString(4, park.getVille());
		 ps.setString(5, park.getPays());
		 ps.setString(6, park.getLongueur());
		 ps.setString(7, park.getLargeur());
		 ps.executeUpdate();																									// Exécution de la requête SQL pour insérer le nouvel enregistrement de stationnement
	 } catch (SQLException e) {
 result="Le parking n est pas ajouté";																							// S'il y a eu une exception dans le try, alors on indique que le parking n'a pas été ajouté avec succès
 e.printStackTrace();
 }
 return result;																													// on Renvoie le résultat de l'opération d'insertion

 }

public static List<String> listParking() {
/**
* méthode pour récupérer une liste de parking de la base de données
*
* @return une Liste de Strings contenant les user_id, park_id, address, codePostal, ville, pays, longueur, largeur de tous les parkings de la base de données
*/
	List<String> list = new ArrayList<String>();
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);																									// Définition du pilote de base de données à utiliser
		Connection con = getConnection();																						// connexion à la base de données
		Statement stmt = con.createStatement();																					// création d'un objet instruction pour exécuter des requêtes SQL																					
		String sql = "select * from parking";																					// requête sql pour récuperer dans une varible toutes les données de la table parking 
		ResultSet res = stmt.executeQuery(sql);																					// exécution de la reqête sql utilisant l'objet stmt. ResultSet contient le résultat de la requête
		//étape : extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String user_id = res.getString("user_id");																			// récupération de la valeur user_id à partir de l'objet ResultSet appelé res dans une variable
			String park_id = res.getString("park_id");																			// récupération de la valeur park_id à partir de l'objet ResultSet appelé res dans une variable
			String address = res.getString("address");																			// récupération de la valeur address à partir de l'objet ResultSet appelé res dans une variable	
			String codePostal = res.getString("codePostal");																	// récupération de la valeur CodePostal à partir de l'objet ResultSet appelé res dans une variable		
			String ville = res.getString("ville");																				// récupération de la valeur ville à partir de l'objet ResultSet appelé res dans une variable
			String pays = res.getString("pays");																				// récupération de la valeur pays à partir de l'objet ResultSet appelé res dans une variable
			String longueur = res.getString("longueur");																		// récupération de la valeur longueur à partir de l'objet ResultSet appelé res dans une variable
			String largeur = res.getString("largeur");																			// récupération de la valeur largeur à partir de l'objet ResultSet appelé res dans une variable
			list.add(user_id);																									//ajout de la valeur user_id à la liste list
			list.add(park_id);																									//ajout de la valeur park_id à la liste list
			list.add(address);																									//ajout de la valeur address_id à la liste list
			list.add(codePostal);																								//ajout de la valeur codePostal_id à la liste list
			list.add(ville);																									//ajout de la valeur ville à la liste list
			list.add(pays);																										//ajout de la valeur pays à la liste list
			list.add(longueur);																									//ajout de la valeur longueur à la liste list
			list.add(largeur);																									//ajout de la valeur largeur à la liste list
		}
		con.close();																											//fermeture de l'objet de connexion
	}
	catch(Exception e){ 
		System.out.println(e);
		
		}
	return list;																												// on Renvoie le résultat de l'opération de la liste
	}

public static List<String> Listparktaille(String longueur) {
/**
* Méthode pour récupérer une liste des parkings de la base de données en fonction d'une longueur donnée
*
* @param longueur la longueur du parking que l'on veut récupérer
* @return une Liste de Strings contenant les user_id, park_id, address, codePostal, ville, pays, longueur, largeur de tous les parkings de la base de données avec la même longueur que celui passé en paramètre.
*/
	List<String> list = new ArrayList<String>();
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);																									// Définition du pilote de base de données à utiliser
		Connection con = getConnection();																						// connexion à la base de données
		Statement stmt = con.createStatement();																					// création d'un objet instruction pour exécuter des requêtes SQL									
		String sql = "select * from parking where longueur = " +longueur;														// requête SQL pour sélectionner toutes les colonnes de la table "parking" où la valeur de la colonne "longueur" correspond à la valeur de la variable "longueur" 
		ResultSet res = stmt.executeQuery(sql);																					// exécution de la reqête sql utilisant l'objet stmt. ResultSet contient le résultat de la requête
		//étape : extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String user_id = res.getString("user_id");																			// récupération de la valeur user_id à partir de l'objet ResultSet appelé res dans une variable
			String park_id = res.getString("park_id");																			// récupération de la valeur park_id à partir de l'objet ResultSet appelé res dans une variable
			String address = res.getString("address");																			// récupération de la valeur address à partir de l'objet ResultSet appelé res dans une variable
			String codePostal = res.getString("codePostal");																	// récupération de la valeur codePostalà partir de l'objet ResultSet appelé res dans une variable
			String ville = res.getString("ville");																				// récupération de la valeur ville à partir de l'objet ResultSet appelé res dans une variable
			String pays = res.getString("pays");																				// récupération de la valeur pays à partir de l'objet ResultSet appelé res dans une variable
			String longueur2 = res.getString("longueur");																		// récupération de la valeur longueur à partir de l'objet ResultSet appelé res dans une variable
			String largeur = res.getString("largeur");																			// récupération de la valeur largeur à partir de l'objet ResultSet appelé res dans une variable
			list.add(user_id);																									//ajout de la valeur user_id à la liste list
			list.add(park_id);																									//ajout de la valeur park_id à la liste list
			list.add(address);																									//ajout de la valeur address à la liste list
			list.add(codePostal);																								//ajout de la valeur codePostal à la liste list
			list.add(ville);																									//ajout de la valeur ville à la liste list	
			list.add(pays);																										//ajout de la valeur pays à la liste list	
			list.add(longueur2);																								//ajout de la valeur longueur2 à la liste list
			list.add(largeur);																									//ajout de la valeur largeur à la liste list
			}
		con.close();																											//fermeture de l'objet de connexion
		}
	catch(Exception e){ 
		System.out.println(e);
		}
return list;																													// on Renvoie le résultat de l'opération de la liste
}

public static List<String> Listparktaille2(String largeur) {
/**
 * méthode pour récupérer une liste des parkings de la base de données en fonction d'une largeur donnée
 *
 * @param largeur la largeur du parking que l'on veut récupérer
 * @return une Liste de Strings contenant les user_id, park_id, address, codePostal, ville, pays, longueur, largeur de tous les parkings de la base de données avec la même largeur que celle passée en paramètre.
*/
	List<String> list = new ArrayList<String>();																				// création d'un nouvel objet ArrayList vide de type String appelé "list"
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);																									// Définition du pilote de base de données à utiliser
		Connection con = getConnection();																						// connexion à la base de données
		Statement stmt = con.createStatement();																					// création d'un objet instruction pour exécuter des requêtes SQL
		String sql = "select * from parking where largeur = " +largeur;															// requête SQL pour sélectionner toutes les colonnes de la table "parking" où la valeur de la colonne "largeur" correspond à la valeur de la variable "largeur"
		ResultSet res = stmt.executeQuery(sql);																					// exécution de la reqête sql utilisant l'objet stmt. ResultSet contient le résultat de la requête
		//étape : extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String user_id = res.getString("user_id");																			// récupération de la valeur user_id à partir de l'objet ResultSet appelé res dans une variable
			String park_id = res.getString("park_id");																			// récupération de la valeur park_id à partir de l'objet ResultSet appelé res dans une variable
			String address = res.getString("address");																			// récupération de la valeur address à partir de l'objet ResultSet appelé res dans une variable
			String codePostal = res.getString("codePostal");																	// récupération de la valeur codePostalà partir de l'objet ResultSet appelé res dans une variable
			String ville = res.getString("ville");																				// récupération de la valeur ville à partir de l'objet ResultSet appelé res dans une variable
			String pays = res.getString("pays");																				// récupération de la valeur pays à partir de l'objet ResultSet appelé res dans une variable
			String longueur = res.getString("longueur");																		// récupération de la valeur longueur à partir de l'objet ResultSet appelé res dans une variable
			String largeur2 = res.getString("largeur");																			// récupération de la valeur longueur à partir de l'objet ResultSet appelé res dans une variable
			list.add(user_id);																									//ajout de la valeur user_id à la liste list
			list.add(park_id);																									//ajout de la valeur park_id à la liste list
			list.add(address);																									//ajout de la valeur address à la liste list
			list.add(codePostal);																								//ajout de la valeur codePostal à la liste list
			list.add(ville);																									//ajout de la valeur ville à la liste list	
			list.add(pays);																										//ajout de la valeur pays à la liste list
			list.add(longueur);																									//ajout de la valeur longueur à la liste list
			list.add(largeur2);																									//ajout de la valeur largeur2 à la liste list
		}
		con.close();																											//fermeture de l'objet de connexion
	}
	catch(Exception e){ 
		System.out.println(e);
	}
return list;																													// on Renvoie le résultat de l'opération de la liste
}

public static List<String> ListDispo(String date_debut, String date_fin) {
/**
 * méthode pour récupérer une liste des parkings disponibles sur une période donnée
 *
 * @param date_debut la date à laquelle la période commence
 * @param date_fin la date à laquelle la période se termine
 * @return une liste de chaînes contenant les user_id, park_id, address, codePostal, ville, pays, longueur, width de tous les parkings de la base de données disponibles dans la période donnée
 */
	List<String> list = new ArrayList<String>();																				// création d'un nouvel objet ArrayList vide de type String appelé "list"
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);																									// Définition du pilote de base de données à utiliser
		Connection con = getConnection();																						// connexion à la base de données
		Statement stmt = con.createStatement();																					// création d'un objet instruction pour exécuter des requêtes SQL
		String sql = "select * from parking where park_id not in (select park_id from reservation where date_debut<='" + date_debut + "' and date_fin>= '" + date_debut + "')"; // requête SQL pour récupérer une liste des parkings disponibles sur une période donnée
		ResultSet res = stmt.executeQuery(sql);																					// exécution de la reqête sql utilisant l'objet stmt. ResultSet contient le résultat de la requête
		//étape : extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String user_id = res.getString("user_id");																			// récupération de la valeur user_id à partir de l'objet ResultSet appelé res dans une variable
			String park_id = res.getString("park_id");																			// récupération de la valeur park_id à partir de l'objet ResultSet appelé res dans une variable
			String address = res.getString("address");																			// récupération de la valeur address à partir de l'objet ResultSet appelé res dans une variable
			String codePostal = res.getString("codePostal");																	// récupération de la valeur codePostalà partir de l'objet ResultSet appelé res dans une variable
			String ville = res.getString("ville");																				// récupération de la valeur ville à partir de l'objet ResultSet appelé res dans une variable
			String pays = res.getString("pays");																				// récupération de la valeur pays à partir de l'objet ResultSet appelé res dans une variable
			String longueur = res.getString("longueur");																		// récupération de la valeur longueur à partir de l'objet ResultSet appelé res dans une variable
			String largeur2 = res.getString("largeur");																			// récupération de la valeur longueur à partir de l'objet ResultSet appelé res dans une variable
			list.add(user_id);																									//ajout de la valeur user_id à la liste list
			list.add(park_id);																									//ajout de la valeur park_id à la liste list
			list.add(address);																									//ajout de la valeur address à la liste list
			list.add(codePostal);																								//ajout de la valeur codePostal à la liste list
			list.add(ville);																									//ajout de la valeur ville à la liste list	
			list.add(pays);																										//ajout de la valeur pays à la liste list
			list.add(longueur);																									//ajout de la valeur longueur à la liste list
			list.add(largeur2);																									//ajout de la valeur largeur2 à la liste list
		}
		con.close();																											//fermeture de l'objet de connexion
		}
	catch(Exception e){ 
		System.out.println(e);
	}
return list;																													// on Renvoie le résultat de l'opération de la liste
}

public static List<String> ParkMap() {
/**
 * Cette méthode retourne une liste des informations des parkings contenant l'adresse, le code postal, ville et pays.
 * @return List<String> contenant des informations sur les parkings
*/
		List<String> list = new ArrayList<String>();																			// création d'un nouvel objet ArrayList vide de type String appelé "list"
		String dbdriver = "com.mysql.cj.jdbc.Driver";
		try {
			loadDriver(dbdriver);																								// Définition du pilote de base de données à utiliser
			Connection con = getConnection();																					// connexion à la base de données
			Statement stmt = con.createStatement();																				// création d'un objet instruction pour exécuter des requêtes SQL
			String sql = "select address,codePostal,ville,pays from parking";													//requête SQL pour sélectionner address, codePostal, ville, pays de la table "parking" 
			ResultSet res = stmt.executeQuery(sql);																				// exécution de la reqête sql utilisant l'objet stmt. ResultSet contient le résultat de la requête
			//étape : extraire les données
			while(res.next()){
				//Récupérer par nom de colonne
				String address = res.getString("address");																		// récupération de la valeur user_id à partir de l'objet ResultSet appelé res dans une variable
				String codePostal = res.getString("codePostal");																// récupération de la valeur user_id à partir de l'objet ResultSet appelé res dans une variable
				String ville = res.getString("ville");																			// récupération de la valeur user_id à partir de l'objet ResultSet appelé res dans une variable
				String pays = res.getString("pays");																			// récupération de la valeur user_id à partir de l'objet ResultSet appelé res dans une variable
				//Afficher les valeurs
				list.add(address + " " + codePostal + " " + ville + " " + pays);												//ajout des valeurs user_id, codePostal, ville , pays à la liste list												
				}
			con.close();																										//fermeture de l'objet de connexion
		}
		catch(Exception e){ 
			System.out.println(e);
			}
		return list;																											// on Renvoie le résultat de l'opération de la liste
}

public static List<String> ParkMap2(String largeur) {
/**
 * Cette méthode retourne une liste des informations des parkings contenant l'adresse, le code postal, ville et pays.
 * @param largeur largeur des parkings recherché
 * @return List<String> contenant des informations sur les parkings filtrés par largeur
*/
	List<String> list = new ArrayList<String>();																				// création d'un nouvel objet ArrayList vide de type String appelé "list"
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);																									// Définition du pilote de base de données à utiliser
		Connection con = getConnection();																						// connexion à la base de données
		Statement stmt = con.createStatement();																					// création d'un objet instruction pour exécuter des requêtes SQL
		String sql = "select address,codePostal,ville,pays from parking where largeur =" +largeur;								// requête SQL qui sélectionne les valeurs des colonnes "adresse", "codePostal", "ville" et "pays" d'une table nommée "parking" où la valeur de la colonne "largeur" est égale à la valeur de la variable "largeur".
		ResultSet res = stmt.executeQuery(sql);																					// exécution de la reqête sql utilisant l'objet stmt. ResultSet contient le résultat de la requête
		//étape : extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String address = res.getString("address");																			// récupération de la valeur address à partir de l'objet ResultSet appelé res dans une variable
			String codePostal = res.getString("codePostal");																	// récupération de la valeur codePostal à partir de l'objet ResultSet appelé res dans une variable
			String ville = res.getString("ville");																				// récupération de la valeur ville à partir de l'objet ResultSet appelé res dans une variable
			String pays = res.getString("pays");																				// récupération de la valeur pays à partir de l'objet ResultSet appelé res dans une variable
			//Afficher les valeurs
			list.add(address + " " + codePostal + " " + ville + " " + pays);													//ajout des valeurs user_id, codePostal, ville , pays à la liste list	
		}
		con.close();																											//fermeture de l'objet de connexion
	}
	catch(Exception e){ 
		System.out.println(e);
		}
	return list;																												// on Renvoie le résultat de l'opération de la liste
}
public static List<String> ParkMap3(String longueur) {
/**
 * Cette méthode retourne une liste des informations des parkings contenant l'adresse, le code postal, ville et pays.
 * @param longueur longueur des parkings recherché
 * @return List<String> contenant des informations sur les parkings filtrés par longueur
*/	
	List<String> list = new ArrayList<String>();																				// création d'un nouvel objet ArrayList vide de type String appelé "list"
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);																									// Définition du pilote de base de données à utiliser
		Connection con = getConnection();																						// connexion à la base de données
		Statement stmt = con.createStatement();																					// création d'un objet instruction pour exécuter des requêtes SQL
		String sql = "select address,codePostal,ville,pays from parking where longueur =" +longueur;							//requête SQL qui sélectionne les valeurs des colonnes "adresse", "codePostal", "ville" et "pays" d'une table nommée "parking" où la valeur de la colonne "longueur" est égale à la valeur de la variable "longueur".
		ResultSet res = stmt.executeQuery(sql);																					// exécution de la reqête sql utilisant l'objet stmt. ResultSet contient le résultat de la requête
		//étape : extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String address = res.getString("address");																			// récupération de la valeur address à partir de l'objet ResultSet appelé res dans une variable
			String codePostal = res.getString("codePostal");																	// récupération de la valeur codePostal à partir de l'objet ResultSet appelé res dans une variable
			String ville = res.getString("ville");																				// récupération de la valeur ville à partir de l'objet ResultSet appelé res dans une variable
			String pays = res.getString("pays");																				// récupération de la valeur pays à partir de l'objet ResultSet appelé res dans une variable
			//Afficher les valeurs
			list.add(address + " " + codePostal + " " + ville + " " + pays);													//ajout des valeurs user_id, codePostal, ville , pays à la liste list	
		}
		con.close();																											//fermeture de l'objet de connexion
	}
	catch(Exception e){ 
		System.out.println(e);
		}
	return list;																												// on Renvoie le résultat de l'opération de la liste
}

public boolean delete(Park park) {
/**
 * Supprime un enregistrement de stationnement de la base de données qui correspond aux informations fournies dans l'objet Park.
 * @param park l'objet Park qui contient les informations nécessaires pour trouver l'enregistrement à supprimer.
*/
    try (Connection con = getConnection()) {																					// connexion à la base de données
        String sql = "DELETE FROM parking WHERE user_id = ? AND address = ? AND codePostal = ? AND ville = ? AND pays = ?";		// Requête SQL pour supprimer l'enregistrement avec l'ID utilisateur, l'adresse, le code postal, la ville et les pays correspondants
        PreparedStatement ps = con.prepareStatement(sql);																		// exécution de la reqête sql utilisant l'objet stmt. ResultSet contient le résultat de la requête
        ps.setString(1, park.getUser_id());																						// définition de la valeur de la première position de paramètre dans la requête préparée ps avec la valeur de l'ID d'utilisateur de l'objet park
        ps.setString(2, park.getAddress());																						// définition de la valeur de la deuxième position de paramètre dans la requête préparée ps avec la valeur de l'address de l'objet park
        ps.setString(3, park.getCodePostal());																					// définition de la valeur de la troisième position de paramètre dans la requête préparée ps avec la valeur du codePostal de l'objet park
        ps.setString(4, park.getVille());																						// définition de la valeur de la quatrième position de paramètre dans la requête préparée ps avec la valeur de la ville de l'objet park
        ps.setString(5, park.getPays());																						// définition de la valeur de la cinquième position de paramètre dans la requête préparée ps avec la valeur du pays de l'objet park
        ps.executeUpdate();																										// Exécute la requête SQL pour supprimer l'enregistrement
        return true;																											// Renvoie vrai si l'enregistrement a été supprimé avec succès
    	} 
    	catch (SQLException e) {
    		e.printStackTrace();
    		return false;																										// renvoie faux sinon
    	}
	}	

public static List<ParktransformDao> Parkandroid() {
	/**
	 * Récupère une liste d'objets ParktransformDao de la base de données, contenant l'adresse, le code postal, la ville et le pays de chaque enregistrement de stationnement dans la base de données.
	 * @return une liste d'objets ParktransformDao, chacun représentant un enregistrement de stationnement dans la base de données.
	*/
	List<ParktransformDao> list = new ArrayList<>();
	String dbdriver = "com.mysql.cj.jdbc.Driver";																
	try {
		loadDriver(dbdriver);																					// chargement du pilote de la base de données
		Connection con = getConnection();																		// connection a la base de données								
		Statement stmt = con.createStatement();																	// Création d' un objet instruction pour exécuter des requêtes SQL
		String sql = "select address,codePostal,ville,pays from parking";										// Requête SQL pour sélectionner tous les enregistrements de parkings
		ResultSet res = stmt.executeQuery(sql);																	// Exécute la requête SQL et stocke les résultats dans un objet ResultSet
		ParktransformDao park;																					// Pour chaque enregistrement du ResultSet, création d' un nouvel objet ParktransformDao qui est ajouté à la liste
		while(res.next()){
			String address = res.getString("address");															// Récupère les valeurs des champs de l'enregistrement en cours "address"
			String codePostal = res.getString("codePostal");													// Récupère les valeurs des champs de l'enregistrement en cours "codePostal"
			String ville = res.getString("ville");																// Récupère les valeurs des champs de l'enregistrement en cours "ville"
			String pays = res.getString("pays");																// Récupère les valeurs des champs de l'enregistrement en cours "pays"
			park = new ParktransformDao (address, codePostal,  ville, pays);									// Création d' un nouvel objet ParktransformDao pour l'enregistrement en cours et l'ajoute à la liste
			list.add(park);
		}
		
		con.close();																							// Ferme la connexion à la base de données
	}
	catch(Exception e){
		System.out.println(e);																					// S'il y a eu une exception, affiche le message d'erreur
		}
	return list;																								// retourne le résultat list
	}															

}