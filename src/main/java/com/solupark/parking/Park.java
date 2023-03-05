package com.solupark.parking;
/**
* Cette classe représente un parking, et contient des informations sur son adresse, sa taille et le propriétaire du parking.
* @author Maxime ROMERO
* @version 1.0
*/

public class Park {
	private String user_id;
	/** L'identifiant du propriétaire du parking */
	private String address;
	/** L'adresse du parking */
	private String codePostal;
	/** code postal  du parking */
	private String ville;
	/** User Id du propriétaire du parking */
	private String pays;
	/** User Id du propriétaire du parking */
	private String longueur;
	/** User Id du propriétaire du parking */
	private String largeur;
	/** User Id du propriétaire du parking */

	/**
	* Constructeur qui initialise toutes les propriétés du parking.
	*
	* @param user_id L'identifiant du propriétaire du parking
	* @param address L'adresse du parking
	* @param codePostal Le code postal du parking
	* @param ville La ville où se situe le parking
	* @param pays Le pays où se situe le parking
	* @param longueur La longueur du parking en mètres
	* @param largeur La largeur du parking en mètres
	*/
public Park(String user_id, String address, String codePostal, String ville, String pays, String longueur, String largeur) {
		super();
		this.user_id = user_id;
		this.address = address;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.longueur = longueur;
		this.largeur = largeur;
	}
	/**
	 * Constructeur par défaut, qui crée un objet parking vide.
	 */
	public Park() {
	}
	/**
	* @return L'identifiant du propriétaire du parking
	*/
	public String getUser_id(){
		return user_id;
	}
	/**
	* @param user_id Le nouvel ID utilisateur du propriétaire du parking
	*/
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	* @return la rue ou se trouve le parking.
	*/
	public String getAddress() {
		return address;
	}
	/**
	* @param address La nouvelle rue ou se trouve le parking
	*/
	public void setAdress(String address) {
		this.address = address;
	}
	/**
	* @return le code postal du parking.
	*/
	public String getCodePostal() {
		return codePostal;
	}
	/**
	* @param codePostal le nouveau code postal du parking
	*/
	public void setCodePostal(String codePostal) {
	    this.codePostal = codePostal;
	}
	/**
	* @return la ville du parking.
	*/
	public String getVille() {
		return ville;
	}
	/**
	* @param ville la nouvelle ville du parking
	*/
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	* @return le pays du parking.
	*/
	public String getPays() {
		return pays;
	}
	/**
	* @param pays le nouveau pays du parking
	*/
	public void setPays(String pays) {
		this.pays = pays;		
	}
	/**
	* @return la longueur du parking.
	*/
	public String getLongueur() {
		return longueur;
	}
	/**
	* @param longueur la nouvelle longueur du parking
	*/
	public void setLongueur(String longueur) {
		this.longueur = longueur;		
	}
	/**
	* @return la largeur du parking.
	*/
	public String getLargeur() {
		return largeur;
	}
	/**
	* @param largeur la nouvelle largeur du parking
	*/
	public void setLargeur(String largeur) {
		this.largeur = largeur;		
	}
	
}
