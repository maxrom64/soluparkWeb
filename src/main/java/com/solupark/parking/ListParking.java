package com.solupark.parking;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import com.solupark.dao.ParkDao;
import com.firebase.dao.ParkDao;

/**
* Cette classe représente la servlet qui gère l'affichage de la liste de parking
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
		list = ParkDao.listParking();
		list_address = ParkDao.ParkMap();
		response.getWriter().println(list);
		//Filtre par longueur
		String longueur = request.getParameter("longueur");
		if (longueur != null) {
			list = ParkDao.Listparktaille(longueur);
			list_address = ParkDao.ParkMap3(longueur);
			}
		//Filtre par largeur
		String largeur = request.getParameter("largeur");
		if (largeur != null) {
			list = ParkDao.Listparktaille2(largeur);
			list_address = ParkDao.ParkMap2(largeur);
			}
		//Filtre par date de disponibilité
		/** La date de début du filtre de recherche du parking*/
		String date_debut = request.getParameter("date_debut");
		/** La date de fin du filtre de recherche du parking*/
		String date_fin = request.getParameter("date_fin");
		/** Validation de la date de début, si elle est nulle ou vide on met à null*/
		if (date_debut == null || date_debut.equals(" ")) {
			date_debut = null;
			}
		/** Validation de la date de fin, si elle est nulle ou vide on met à null*/
		if (date_fin == null || date_fin.equals(" ")) {
			date_fin = null;
			}
		/** Si les dates de début et de fin ne sont pas nulles, nous filtrons la liste de stationnement par disponibilité*/
		if (date_debut != null && date_fin != null) {
			list = ParkDao.ListDispo(date_debut,date_fin);
			}
		RequestDispatcher dispatcher;
		request.setAttribute("parkings",list);
		request.setAttribute("date_debut",date_debut);
		request.setAttribute("date_fin",date_fin);
		request.setAttribute("longueur",longueur);
		request.setAttribute("list_address",list_address);
		dispatcher = request.getRequestDispatcher("./ParkList2.jsp");
        dispatcher.forward(request,response);   
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
}