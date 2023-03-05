package com.solupark.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
* LoginDao est une classe utilisée pour authentifier un utilisateur.
* il contient une méthode checkUser qui prend deux arguments de chaîne (email, mdp) et vérifie si
* l'utilisateur avec l'email et le mdp correspondants existe dans la base de données.
* @author Maxime ROMERO
* @version 1.0
*/
public class LoginDao {
/**
* On vérifie si l'utilisateur avec l'email et le mdp correspondants existe dans la base de données
* @param email l'email de l'utilisateur
* @param mdp le mot de passe de l'utilisateur
* @return vrai si l'utilisateur existe, faux sinon
*/
public static boolean checkUser(String email,String mdp) 
	    {
	        boolean st =false;																						//déclaration de la variable boolean nommé st et initilisé a false
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/solupark","root","root"); //creation de la connexion avec la base
	            PreparedStatement ps = con.prepareStatement("select * from user where email=? and mdp=?");			//preparation de la requête SQL
	            ps.setString(1, email);																				//on affecte la valeur email à la requête préparée ps
	            ps.setString(2, mdp);																				//on affecte la valeur  mdp à la requête préparée mdp
	            ResultSet rs =ps.executeQuery();																	//création de l'objet ResultaSet qui va contennir le résultat de la requête SQL
	            st = rs.next();																						//on passe l'instruction st qui renvoie true si une nouvelle ligne est disponible et false si toutes sont lues
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	        return st;   																							//on renvoie la valeur stocké de la variable st              
	    }
	}