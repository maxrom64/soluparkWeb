package com.solupark.utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.solupark.dao.UtilisateurDao;
/**
 * Classe d'implémentation de servlet Ajoutparking
 * Cette classe est responsable de la gestion des requêtes HTTP liées à l'ajout d'un parking à une base de données.
 * @author Maxime ROMERO
 * @version 1.0
 */
public class Ajoututilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * Constructeur par défaut. 
     */
    public Ajoututilisateur() {
    	super();
    }
    /**
     * Gère les requêtes HTTP GET.
     * @param request L'objet HttpServletRequest.
     * @param response L'objet HttpServletResponse.
     * @throws ServletException Si une exception se produit qui interfère avec le fonctionnement normal du servlet.
     * @throws IOException Si une exception d'entrée ou de sortie se produit.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	/**
     * Gère les requêtes HTTP POST. Récupère divers paramètres de l'objet de requête et les utilise pour créer un objet Park.
     * Ensuite, il est créée une instance de ParkDao qui est utilisé pour insérer l'objet Park et l'e-mail dans la base de données.
     * Le résultat de l'opération d'insertion est écrit dans la réponse.
     * @param request L'objet HttpServletRequest.
     * @param response L'objet HttpServletResponse.
     * @throws ServletException Si une exception se produit qui interfère avec le fonctionnement normal du servlet.
     * @throws IOException Si une exception d'entrée ou de sortie se produit.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	//déclaration de méthode utilisée dans les servlets pour traiter les requêtes HTTP POST envoyées à la servlet par le client
		String nom = request.getParameter("nom");																			//on récupère la valeur nom  via le formulaire soumis par l'utilisateur et on la stocke dans une variable nom
		String prenom = request.getParameter("prenom");																		//on récupère la valeur prenom  via le formulaire soumis par l'utilisateur et on la stocke dans une variable prenom	
		String email = request.getParameter("email");																		//on récupère la valeur email  via le formulaire soumis par l'utilisateur et on la stocke dans une variable email	
		String mdp = request.getParameter("mdp");																			//on récupère la valeur mdp  via le formulaire soumis par l'utilisateur et on la stocke dans une variable mdp
		String mdp2 = request.getParameter("mdp2");																			//on récupère la valeur mdp2 via le formulaire soumis par l'utilisateur et on la stocke dans une variable mdp2
		
		Utilisateur utilisateur=new Utilisateur(nom, prenom, email, mdp, mdp2);												//on créé une nouvelle instance de la classe utilisateur avec les paramètres passés
		UtilisateurDao rdao=new UtilisateurDao();																			//on créé une nouvelle instance de la classe UtilisateurDao
		String result=rdao.insert(utilisateur);																				//crée une instance de la classe UtilisateurDao appelée rdao et utilise sa méthode insert en passant l'objet utilisateur en paramètre.
		response.getWriter().println(result);																				//on renvoit une réponse au client le résultat
		}
}