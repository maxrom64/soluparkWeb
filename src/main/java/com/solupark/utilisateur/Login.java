package com.solupark.utilisateur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.solupark.dao.LoginDao;
/**
* La classe Login Servlet gère les demandes de connexion des utilisateurs.
* @author Maxime ROMERO
* @version 1.0
* @since 2022
*/

public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * Constructeur pour la classe Login.
     */
    public Login() {
        super();
    }
    /**
     * Il gère les requêtes HTTP POST. Il obtient les informations de connexion (e-mail et mot de passe) de la demande
     * les vérifie par rapport à la base de données à l'aide de la méthode LoginDao.checkuser. Si la connexion est réussie,
     * il crée une nouvelle session pour l'utilisateur et transmet la demande à la vue profil2.jsp.
     * Sinon, il affiche un message d'erreur et transmet la demande à la vue index.jsp.
     *
     * @param demander l'objet HttpServletRequest
     * @param réponse l'objet HttpServletResponse
     * @throws ServletException quand la requête ne peut pas être traitée
     * @throws IOException lorsqu'il y a une erreur IO
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");									//récupérer la valeur de l'attribut "email" envoyé par le client dans une requête HTTP
        String mdp = request.getParameter("mdp");										//récupérer la valeur de l'attribut "mdp" envoyé par le client dans une requête HTTP
        HttpSession session = request.getSession();										//crée une session HTTP pour l'utilisateur ou renvoie la session existante associée à la requête HTTP entrante
        session.setAttribute("email", email);											//on stocke l'adresse email de l'utilisateur dans la session HTTP afin de pouvoir l'utiliser dans d'autres parties de l'application.
        if(LoginDao.checkUser(email, mdp))												//on vérifie si les informations de connexion entrées par l'utilisateur sont correctes en appelant la méthode "checkUser" de la classe "LoginDao"
        {
        	out.println("connexion ok");												//affichage du message "connexion ok"
            RequestDispatcher rs = request.getRequestDispatcher("profil.jsp");			//récupère un objet "RequestDispatcher" pour rediriger la requête vers la page "profil.jsp" en utilisant la méthode "getRequestDispatcher"
            rs.forward(request, response);												//instruction utilisée pour rediriger la requête et la réponse actuelles vers une autre ressource de l'application web.
        }
        else
        {
           out.println("Username or Password incorrect");								//affichage du message "Nom d'utilisateur ou mot de passe incorrect" 
           RequestDispatcher rs = request.getRequestDispatcher("index.jsp");			//récupère un objet "RequestDisponatcher" pour rediriger la requête vers la page "index.jsp" en utilisant la méthode "getRequestDispatcher"
           rs.include(request, response);												//La méthode "include" est ensuite utilisée pour inclure la requête et la réponse actuelles dans la réponse envoyée au client, ce qui permet d'afficher la page "index.jsp" avec le message d'erreur approprié
        }
    }  
}