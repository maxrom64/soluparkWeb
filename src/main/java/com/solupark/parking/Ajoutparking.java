package com.solupark.parking;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.solupark.dao.ParkDao;
/**
* Cette classe représente le servlet qui gère l'insertion de parking
* 
* @author Maxime ROMERO
* @version 1.0
*/
public class Ajoutparking extends HttpServlet {
	/**
	* serialVersionUID de la classe
	*/
	private static final long serialVersionUID = 1L;
	/**
	* Constructeur par défaut
	*/
    public Ajoutparking() {
    	super();
    }
    /**
     * Handles la méthode HTTP <code>GET</code>
     * @param request la demande de servlet
     * @param response la réponse du servlet
     * @throws ServletException si une erreur spécifique au servlet se produit
     * @throws IOException si une erreur I/O se produit
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	/**
	 * Handles la méthode HTTP <code>POST</code>.
	 * 
	 * @param request la demande de servlet
	 * @param response la réponse du servlet
	 * @throws ServletException si une erreur spécifique au servlet se produit
	 * @throws IOException si une erreur I/O se produit
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * L'identifiant du propriétaire du parking
		 */
		String user_id = request.getParameter("user_id");
		/**
		 * l'adresse du parking
		 */
		String address = request.getParameter("address");
		/**
		 * le code postal du parking
		 */
		String codePostal = request.getParameter("codePostal");
		/**
		 * la ville ou se trouve le parking
		 */
		String ville = request.getParameter("ville");
		/**
		 * le pays ou se trouve le parking
		 */
		String pays = request.getParameter("pays");
		/**
		 * la longueur du parking
		 */
		String longueur = request.getParameter("longueur");
		/**
		 * la largeur du parking
		 */
		String largeur = request.getParameter("largeur");
		/**
		 * l'email du propriétaire du parking
		 */
		String email = request.getParameter("email");
		/**
		 * création d'un nouvel objet
		 */
		Park park=new Park(user_id, address, codePostal, ville, pays, longueur, largeur);
		/**
		 * creation d'un nouvel objet dao parking
		 */
		ParkDao rdao=new ParkDao();
		/**
		 * résultat de l'instertion
		 */
		String result=rdao.insert(park,email);
		/**
		 * affichage du résultat de l'insertion
		 */
		response.getWriter().println(result);
		}
}