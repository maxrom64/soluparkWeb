package com.solupark.dao;

public class ParktransformDao {
	private String address;
	private String codePostal;
	private String ville;
	private String pays;
	
	public ParktransformDao(String address, String codePostal, String ville, String pays) {
		super();
		this.address = address;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
}
