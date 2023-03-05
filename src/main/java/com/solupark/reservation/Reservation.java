package com.solupark.reservation;
/**
* La réservation est une classe qui représente une réservation.
* Elle contient quatre champs park_id,user_id,date_debut,date_fin.
* Elle founit des méthodes pour accéder et manipuler les valeurs de ces champs.
* 
* @author maxime ROMERO
* @version 1.0
*/
public class Reservation {
		private String park_id;
		private String user_id;
		private String date_debut;
		private String date_fin;

/**
* Constructeur qui prend quatre paramètres et les affecte aux champs portant le même nom.
* @param park_id le park_id de la réservation
* @param user_id the user_id de la reservation
* @param date_debut la date de début de la réservation
* @param date_fin la date de fin de la réservation
*/		
public Reservation(String park_id, String user_id, String date_debut, String date_fin) {
		super();
		this.park_id = park_id;
		this.user_id = user_id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		}
		/**
	 	* Retourne le park_id de la réservation
	 	* @return le park_id de la réservation
	 	*/
		public String getPark_id() {
			return park_id;
		}
		/**
	     * définit le park_id de la réservation
	     * @param park_id le park_id de la réservation
	     */
		public void setPark_id(String park_id) {
			this.park_id = park_id;
		}
		/**
	     * Retourne le user_id de la reservation
	     * @return user_id le user_id de la reservation
	     */
		public String getUser_id() {
			return user_id;
		}
		/**
	     * définit l'user_id de la réservation
	     * @param user_id l'user_id de la réservation
	     */
		public void setUser_id(String user_id) {
		    this.user_id = user_id;
		}
		/**
	     * Retourne la date de debut de la réservation
	     * @return date_debut la date de debut de la réservation
	     */
		public String getDate_debut() {
			return date_debut;
		}
		/**
	     * définit la date de debut de la réservation
	     * @param date_debut la date de debut de la réservation
	     */
		public void setDate_debut(String date_debut) {
			this.date_debut = date_debut;
		}
		/**
	     * Renvoie la date de fin de la réservation
	     * @return a date de fin de la réservation
	     */
		public String getDate_fin() {
			return date_fin;
		}
		/**
	     * définit la date de fin de la réservation
	     * @param date_debut la date de fin de la réservation
	     */
		public void setDate_fin(String date_fin) {
			this.date_fin = date_fin;		
		}
}
