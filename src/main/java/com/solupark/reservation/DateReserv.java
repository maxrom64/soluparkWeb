package com.solupark.reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.solupark.dao.ReservDao;

/**
* DateReserv est une classe de servlet qui gère les requêtes HTTP liées à la réservation d'une place de parking.
* Elle communique avec les classes externes ReservDao et Reservation.
* @author Maxime ROMERO
* @version 1.0
*/
public class DateReserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
     * Constructeur par défaut
     */
    public DateReserv() {
        super();
    }
    /**
    * Gère les requêtes GET et renvoie un message indiquant le contexte de la requête.
    * @param request La requête HTTP entrante
    * @param response La réponse HTTP sortante
    * @throws ServletException Si une erreur de servlet se produit
    * @throws IOException Si une erreur d'entrée/sortie se produit
    */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	* Gère les requêtes POST pour la réservation d'un parking.
	* @param request La requête HTTP entrante
	* @param response La réponse HTTP sortante
	* @throws ServletException Si une erreur de servlet se produit
	* @throws IOException Si une erreur d'entrée/sortie se produit
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String park_id = request.getParameter("park_id");																		// on recupère la valeur de park_id qui sera envoyé depuis le formulaire à la servlet
		String user_id = request.getParameter("user_id");																		// on recupère la valeur de user_id qui sera envoyé depuis le formulaire à la servlet
		String date_debut = request.getParameter("date_debut");																	// on recupère la valeur de date_debu qui sera envoyé depuis le formulaire à la servlet
		String date_fin = request.getParameter("date_fin");																		// on recupère la valeur de date_fin qui sera envoyé depuis le formulaire à la servlet
		Reservation reservation=new Reservation(park_id, user_id,date_debut,date_fin);											// création de la nouvelle instance de la classe reservation avec les valeurs passées en paramètres
		ReservDao rdao=new ReservDao();																							// creation d'un nouvel objet de la classe ReservDao avec la variable rdao
		String result=rdao.reserv(reservation,park_id);																			// rdao appelle la méthode reserv avec l'objet "reservation" de type Reservation et la chaîne de caractères "park_id".
		response.getWriter().println(result);																					// on renvoit le résultat 
		}
}
