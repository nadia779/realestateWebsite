package com.realestatewebsite.Repo;

public class Offre {	
	private double prix;
	private int idEnchere;
	private int idClient;
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getIdEnchere() {
		return idEnchere;
	}
	public void setIdEnchere(int idEnchere) {
		this.idEnchere = idEnchere;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public Offre(int idEnchere, int idClient,double prix) {
		super();
		this.prix = prix;
		this.idEnchere = idEnchere;
		this.idClient = idClient;
	}
	public Offre() {
		super();
	}
	
	
}
