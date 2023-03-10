package com.solupark.parking;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.solupark.dao.ParkDao;


/**
* Cette classe represente la servlet qui gère l'affichage de la liste de parking
* 
* @author Maxime ROMERO
* @version 1.0
*/
public class ListParking extends HttpServlet {
	/**
	* serialVersionUID de la classe
	*/
	private static final long serialVersionUID = 1L;
	
	/**
	* Constructeur par défaut
	*/
	public ListParking() {
    	super();
    }
    
	/**
	    * @param request HttpServletRequest
	    * @param response HttpServletResponse
	    * Cette méthode gérera les requêtes doGet
	    * @throws ServletException
	    * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		List<String> list_address = new ArrayList<String>();
		list = ParkDao.listParking();																			// 
		list_address = ParkDao.ParkMap();
		response.getWriter().println(list);
		//Filtre par longueur
		String longueur = request.getParameter("longueur");														//récupère la valeur de l'attribut longueur à partir de la requête HTTP.
		if (longueur != null) {																					// vérification si la longueur est différente de null
			list = ParkDao.Listparktaille(longueur);															// appel de la méthode Listparktaille de la classe ParkDao avec le pramètre longueur affecté dna la variable list
			list_address = ParkDao.ParkMap3(longueur);															// appel de la méthode ParkMap3 de la classe ParkDao avec le pramètre longueur affecté dans la variable list_address
			}
		//Filtre par largeur
		String largeur = request.getParameter("largeur");														//récupère la valeur de l'attribut largeur à partir de la requête HTTP.						
		if (largeur != null) {																					// vérification si la largeur est différente de null	
			list = ParkDao.Listparktaille2(largeur);															// appel de la méthode Listparktaille2 de la classe ParkDao avec le pramètre longueur affecté dna la variable list
			list_address = ParkDao.ParkMap2(largeur);															// appel de la méthode ParkMap2 de la classe ParkDao avec le pramètre longueur affecté dna la variable list_address
			}
		//Filtre par date de disponibilité
		String date_debut = request.getParameter("date_debut");													// récupère la valeur de l'attribut date_debut à partir de la requête HTTP.
		String date_fin = request.getParameter("date_fin");														// récupère la valeur de l'attribut date_fin à partir de la requête HTTP.
		if (date_debut == null || date_debut.equals(" ")) {														// vérifie si la variable date_debut est null ou vide.
			date_debut = null;																					
			}

		if (date_fin == null || date_fin.equals(" ")) {															// vérifie si la variable date_fin est null ou vide.
			date_fin = null;
			}
		if (date_debut != null && date_fin != null) {															// Si les dates de début et de fin ne sont pas nulles, nous filtrons la liste de stationnement par disponibilité
			list = ParkDao.ListDispo(date_debut,date_fin);														// mise à jour de la variable list qui contient la liste filtrée de parkings disponibles pendant la période spécifiée
			}
		RequestDispatcher dispatcher;																			// déclare une variable de type RequestDispatcher nommée dispatcher.
		request.setAttribute("parkings",list);																	// ajoute un attribut nommé "parkings" à l'objet HttpServletRequest qui a pour valeur la liste 'list
		request.setAttribute("date_debut",date_debut);															// ajoute un attribut nommé "date_debut" à l'objet HttpServletRequest qui a pour valeur la liste date_debut
		request.setAttribute("date_fin",date_fin);																// ajoute un attribut nommé "date_fin" à l'objet HttpServletRequest qui a pour valeur la liste date_fin
		request.setAttribute("longueur",longueur);																// ajoute un attribut nommé "longueur" à l'objet HttpServletRequest qui a pour valeur la liste date_debut
		request.setAttribute("list_address",list_address);														// ajoute un attribut nommé "list_address" à l'objet HttpServletRequest qui a pour valeur la liste list_address
		dispatcher = request.getRequestDispatcher("./ParkList2.jsp");											// page jsp de destination pour un dispatcher de requête 
        dispatcher.forward(request,response);   																// transfert de la requête d'un client vers la pages jsp /Parklist2.jsp
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
}