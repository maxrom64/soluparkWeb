package com.solupark.utilisateur;

/**
* La classe Utilisateur représente un utilisateur.
* Il contient cinq champs nom,prenom,email,mdp,mdp2,valid et des méthodes pour accéder et manipuler les valeurs de ces champs.
* @author Maxime ROMERO
* @version 1.0
*/
public class Utilisateur {
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private String mdp2;
	public boolean valid;

/**
* Le constructeur de la classe Utilisateur prend cinq paramètres et les affecte aux champs portant le même nom.
* @param nom le nom de l'utilisateur
* @param prenom le prénom de l'utilisateur
* @param email l'email de l'utilisateur
* @param mdp le mot de passe de l'utilisateur
* @param mdp2 le mot de passe confirmé de l'utilisateur
*/
public Utilisateur(String nom, String prenom, String email, String mdp, String mdp2) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.mdp = mdp;
	this.mdp2 = mdp2;
}
	/**
	 * Retourne le nom de l'utilisateur
	 * @return le nom de l'utilisateur
	*/
	public String getNom() {
		return nom;
	}
	/**
     * définit le nom de l'utilisateur
     * @param nom le nom de l'utilisateur
     */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
     * Retourne le prénom de l'utilisateur
     * @return le prénom de l'utilisateur
     */
	public String getPrenom() {
		return prenom;
	}
	/**
     * définit le prenom de l'utilisateur
     * @param prenom le prenom de l'utilisateur
     */
	public void setPrenom(String prenom) {
	    this.prenom = prenom;
	}
	/**
     * Retourne l'email de l'utilisateur
     * @return l'email de l'utilisateur
     */
	public String getEmail() {
		return email;
	}
	/**
     * définit l'email de l'utilisateur
     * @param email l'email de l'utilisateur
     */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
     * Retourne le mot depasse de l'utilisateur
     * @return le mot de passe de l'utilisateur
     */
	public String getMdp() {
		return mdp;
	}
	/**
     * Définit le mot de passe de l'utilisateur
     * @param mdp le mot de passe de l'utilisateur
     */
	public void setMdp(String mdp) {
		this.mdp = mdp;		
	}
	/**
     * Retourne le mot de passe confirmé de l'utilisateur
     * @return le mot de passe confirmé de l'utilisateur
     */
	public String getMdp2() {
		return mdp2;
	}
	/**
    * Définit le mot de passe confirmé de l'utilisateur
    * @param mdp2 le mot de passe confirmé de l'utilisateur
    */
	public void setMdp2(String mdp2) {
		this.mdp2 = mdp2;		
	}
	/**
     * Retourne si l'utilisateur est valide ou non
     * @return vrai si l'utilisateur est valide, faux sinon
     */
	public boolean isValid() {
		return valid();
	}
	public void setValid(boolean newValid) {
		valid = newValid;
	}	

	private boolean valid() {
		return false;
	}
}