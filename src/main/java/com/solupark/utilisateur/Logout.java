package com.solupark.utilisateur;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * La classe Logout Servlet gère les demandes de deconnexion des utilisateurs.
 * Cette classe est responsable de la gestion des requêtes HTTP GET pour la déconnexion d'un utilisateur
 * @author Maxime ROMERO
 * @version 1.0
 */
public class Logout extends HttpServlet{
	 
	private static final long serialVersionUID = 1L;
	/**
     * Constructeur par défaut.
     */
	public Logout() {
	        super();
	    }
	/**
     * Gère les requêtes HTTP GET en supprimant l'attribut "utilisateur" de la session et en transmettant la requête et la réponse à la page login.jsp.
     * @param request L'objet HttpServletRequest
     * @param response L'objet HttpServletRequest
     * @throws ServletException si une exception se produit et interfère avec l'opération normale du servlet.
     * @throws IOException Si une exception d'entrée ou de sortie se produit
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)		//Methode doGetpour récupérer des ressources depuis un serveur web
	      throws ServletException, IOException {
	      HttpSession session = request.getSession(false);								//on écupérere la session actuelle associée à la requête HTTP en cours. Si une session existe, elle est renvoyée, sinon null est renvoyé sans en créer une nouvelle.
	      if (session != null) {														//on verifie si une session existe
	          session.removeAttribute("utilisateur");    								//on supprime la valeur de l'attribut nommé utilisateur
	          RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");	//on transfere le controle de la requête et de la réponse vers la page login.jsp
	          dispatcher.forward(request, response);
	      }
	   }
}
