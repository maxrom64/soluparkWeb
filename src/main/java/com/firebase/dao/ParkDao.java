package com.firebase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.solupark.parking.Park;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;


public class ParkDao {
 private static String dburl = "jdbc:mysql://localhost:3306/solupark";
 private static String dbuname = "root";
 private static String dbpassword = "root";
 public String dbdriver = "com.mysql.cj.jdbc.Driver";

 public static void loadDriver(String dbDriver)
 {
 try {
 Class.forName(dbDriver);
 } catch (ClassNotFoundException e) {
 
 e.printStackTrace();
 }
 }
 
 public static Connection getConnection() {
 Connection con = null;
 try {
 con = DriverManager.getConnection(dburl, dbuname, dbpassword);
 } catch (SQLException e) {
 e.printStackTrace();
 }
 return con;
 }
 
 public String insert(Park park, String email) {
	 loadDriver(dbdriver);
	 Connection con = getConnection();
	 String sql_user = "select user_id from user where email= ?";
	 String sql = "insert into parking(user_id, address, codePostal, ville, pays, longueur, largeur) values (?,?,?,?,?,?,?)";
	 String result="Parking ajouté";
	 String user_id = "";
	 try {
		 Statement state = con.createStatement();
		 PreparedStatement ps0 = con.prepareStatement(sql_user);
		 ps0.setString(1, email);
		 ResultSet resultat = ps0.executeQuery();
		 resultat.next();
		 user_id = resultat.getString(1);
		 resultat.close();
		 state.close();
		 PreparedStatement ps = con.prepareStatement(sql);
		 ps.setNString(1, user_id);
		 ps.setString(2, park.getAddress());
		 ps.setString(3, park.getCodePostal());
		 ps.setString(4, park.getVille());
		 ps.setString(5, park.getPays());
		 ps.setString(6, park.getLongueur());
		 ps.setString(7, park.getLargeur());
		 ps.executeUpdate();
	 } catch (SQLException e) {

 result="Le parking n est pas ajouté";
 e.printStackTrace();
 }
 return result;

 }

public static List<String> listParking() {
	List<String> list = new ArrayList<String>();
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String sql = "select * from parking";
		ResultSet res = stmt.executeQuery(sql);
		//étape 5: extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String user_id = res.getString("user_id");
			String park_id = res.getString("park_id");
			String address = res.getString("address");
			String codePostal = res.getString("codePostal");
			String ville = res.getString("ville");
			String pays = res.getString("pays");
			String longueur = res.getString("longueur");
			String largeur = res.getString("largeur");
			//Afficher les valeurs
			list.add(user_id);
			list.add(park_id);
			list.add(address);
			list.add(codePostal);
			list.add(ville);
			list.add(pays);
			list.add(longueur);
			list.add(largeur);
		}
		//étape 6: fermez l'objet de connexion
		con.close();
	}
	catch(Exception e){ 
		System.out.println(e);
		
		}
	return list;
	}

public static List<String> Listparktaille(String longueur) {
	List<String> list = new ArrayList<String>();
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String sql = "select * from parking where longueur = " +longueur;
		ResultSet res = stmt.executeQuery(sql);
		//étape 5: extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String user_id = res.getString("user_id");
			String park_id = res.getString("park_id");
			String address = res.getString("address");
			String codePostal = res.getString("codePostal");
			String ville = res.getString("ville");
			String pays = res.getString("pays");
			String longueur2 = res.getString("longueur");
			String largeur = res.getString("largeur");
			//Afficher les valeurs
			list.add(user_id);
			list.add(park_id);
			list.add(address);
			list.add(codePostal);
			list.add(ville);
			list.add(pays);
			list.add(longueur2);
			list.add(largeur);
		}
//étape 6: fermez l'objet de connexion
con.close();
}
catch(Exception e){ 
System.out.println(e);

}
return list;
}

public static List<String> Listparktaille2(String largeur) {
	List<String> list = new ArrayList<String>();
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String sql = "select * from parking where largeur = " +largeur;
		ResultSet res = stmt.executeQuery(sql);
		//étape 5: extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String user_id = res.getString("user_id");
			String park_id = res.getString("park_id");
			String address = res.getString("address");
			String codePostal = res.getString("codePostal");
			String ville = res.getString("ville");
			String pays = res.getString("pays");
			String longueur = res.getString("longueur");
			String largeur2 = res.getString("largeur");
			//Afficher les valeurs
			list.add(user_id);
			list.add(park_id);
			list.add(address);
			list.add(codePostal);
			list.add(ville);
			list.add(pays);
			list.add(longueur);
			list.add(largeur2);
		}
//étape 6: fermez l'objet de connexion
con.close();
}
catch(Exception e){ 
System.out.println(e);

}
return list;
}

public static List<String> ListDispo(String date_debut, String date_fin) {
	List<String> list = new ArrayList<String>();
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String sql = "select * from parking where park_id not in (select park_id from reservation where date_debut<='" + date_debut + "' and date_fin>= '" + date_debut + "')";
		ResultSet res = stmt.executeQuery(sql);
		//étape 5: extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String user_id = res.getString("user_id");
			String park_id = res.getString("park_id");
			String address = res.getString("address");
			String codePostal = res.getString("codePostal");
			String ville = res.getString("ville");
			String pays = res.getString("pays");
			String longueur = res.getString("longueur");
			String largeur2 = res.getString("largeur");
			//Afficher les valeurs
			list.add(user_id);
			list.add(park_id);
			list.add(address);
			list.add(codePostal);
			list.add(ville);
			list.add(pays);
			list.add(longueur);
			list.add(largeur2);
		}
//étape 6: fermez l'objet de connexion
con.close();
}
catch(Exception e){ 
System.out.println(e);

}
return list;
}

public static List<String> ParkMap() {
		List<String> list = new ArrayList<String>();
		String dbdriver = "com.mysql.cj.jdbc.Driver";
		try {
			loadDriver(dbdriver);
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			String sql = "select address,codePostal,ville,pays from parking";
			ResultSet res = stmt.executeQuery(sql);
			//étape 5: extraire les données
			while(res.next()){
				//Récupérer par nom de colonne
				String address = res.getString("address");
				String codePostal = res.getString("codePostal");
				String ville = res.getString("ville");
				String pays = res.getString("pays");
				//Afficher les valeurs
				list.add(address + " " + codePostal + " " + ville + " " + pays);
			}
			//étape 6: fermez l'objet de connexion
			con.close();
		}
		catch(Exception e){ 
			System.out.println(e);
			
			}
		return list;
}

public static List<String> ParkMap2(String largeur) {
	List<String> list = new ArrayList<String>();
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String sql = "select address,codePostal,ville,pays from parking where largeur =" +largeur;
		ResultSet res = stmt.executeQuery(sql);
		//étape 5: extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String address = res.getString("address");
			String codePostal = res.getString("codePostal");
			String ville = res.getString("ville");
			String pays = res.getString("pays");
			//Afficher les valeurs
			list.add(address + " " + codePostal + " " + ville + " " + pays);
		}
		//étape 6: fermez l'objet de connexion
		con.close();
	}
	catch(Exception e){ 
		System.out.println(e);
		
		}
	return list;
}
public static List<String> ParkMap3(String longueur) {
	List<String> list = new ArrayList<String>();
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String sql = "select address,codePostal,ville,pays from parking where longueur =" +longueur;
		ResultSet res = stmt.executeQuery(sql);
		//étape 5: extraire les données
		while(res.next()){
			//Récupérer par nom de colonne
			String address = res.getString("address");
			String codePostal = res.getString("codePostal");
			String ville = res.getString("ville");
			String pays = res.getString("pays");
			//Afficher les valeurs
			list.add(address + " " + codePostal + " " + ville + " " + pays);
		}
		//étape 6: fermez l'objet de connexion
		con.close();
	}
	catch(Exception e){ 
		System.out.println(e);
		
		}
	return list;
}

public boolean delete(Park park) {
    try (Connection con = getConnection()) {
        String sql = "DELETE FROM parking WHERE user_id = ? AND address = ? AND codePostal = ? AND ville = ? AND pays = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, park.getUser_id());
        ps.setString(2, park.getAddress());
        ps.setString(3, park.getCodePostal());
        ps.setString(4, park.getVille());
        ps.setString(5, park.getPays());
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public static List<ParktransformDao> Parkandroid() {
	List<ParktransformDao> list = new ArrayList<>();
	String dbdriver = "com.mysql.cj.jdbc.Driver";
	try {
		loadDriver(dbdriver);
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String sql = "select address,codePostal,ville,pays from parking";
		ResultSet res = stmt.executeQuery(sql);
		//étape 5: extraire les données
		ParktransformDao park;
		while(res.next()){
			//Récupérer par nom de colonne
			String address = res.getString("address");
			String codePostal = res.getString("codePostal");
			String ville = res.getString("ville");
			String pays = res.getString("pays");
			park = new ParktransformDao (address, codePostal,  ville, pays);
			//Afficher les valeurs
			list.add(park);
		}
		//étape 6: fermez l'objet de connexion
		con.close();
	}
	catch(Exception e){ 
		System.out.println(e);
		
		}
	return list;
}

}