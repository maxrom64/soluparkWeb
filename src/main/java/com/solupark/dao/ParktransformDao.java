package com.solupark.dao;
/**
 * Constructeur pour créer un nouvel objet ParktransformDao avec l'adresse, le code postal, la ville et le pays donnés.
 * @param address l'adresse du parking
 * @param codePostal le code postal du parking
 * @param ville la ville du parking
 * @param pays le pays ou se trouve le parking
 */
public class ParktransformDao {
	private String address;									//variable chaine de caractères adress 
	private String codePostal;								//variable chaine de caractères codePostal
	private String ville;									//variable chaine de caractères ville 
	private String pays;									//variable chaine de caractères pays
	
	public ParktransformDao(String address, String codePostal, String ville, String pays) {
		super();
		this.address = address;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}
	/**
	 * Renvoie l'adresse du parking.
	 * @return l'adresse du parking.
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Définit l'adresse du parking.
	 * @param address la nouvelle adresse du parking. 
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Retourne le code postal de l'adresse du parking.
	 * @return le code postal de l'adresse du parking.
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * Définit le code postal de l'adresse du parking.
	 * @param codePostal le nouveau ode postal de l'adresse du parking.
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * Retourne la ville ou se trouve le parking.
	 * @return la ville ou se trouve le parking.
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * Définit la ville ou se trouve le parking.
	 * @param ville la nouvelle ville ou se trouve le parking
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * Retourne le pays ou se trouve le parking.
	 * @return le pays ou se trouve le parking
	 */
	public String getPays() {
		return pays;
	}
	/**
	 * Définit le pays ou se trouve le parking.
	 * @param pays le nouveau parking ou se trouve le parking
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}
}
