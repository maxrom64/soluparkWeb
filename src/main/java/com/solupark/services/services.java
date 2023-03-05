package com.solupark.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.solupark.dao.ParkDao;
import com.solupark.dao.ParktransformDao;

/**
 * Services de classe d'implémentation de servlet
 */
//@WebServlet(name="services",urlPatterns= {"/apiparkings"})
public class services extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public services() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Headers","*");																// n'importe quelle requete est autorisée 
		response.setHeader("Access-Control-Allow-Origin","*");																// les domaines sont autorisés à accéder à la ressource
		response.setContentType("application/json");																		// on indique que la réponse est un document JSON
		PrintWriter resultat= response.getWriter();																			
		List<ParktransformDao> list_address;																				//variable nommée list_address de type list contenant des objets 
		list_address = ParkDao.Parkandroid();																				// on récupère une liste d'objet transformée à partir de données brutes dans la base de donnéee
		Gson gson = new Gson();																								// creation de la classe Gson qui permet de convertir des objets java 
		String json = gson.toJson(list_address);																			// on convertit la liste list_address en format Json "json" qui prend une entree Java et transforme au format JSON
		response.getWriter().println(json);																					// réponse de l'PAI qui contient les données en format JSON
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}