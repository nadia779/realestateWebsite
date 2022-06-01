package com.realestatewebsite.Repo;

public class Wishlist {
	// id_annonce	id_client
	private int idAnnonce;
	private int idClient;
	public int getIdAnnonce() {
		return idAnnonce;
	}
	public void setIdAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public Wishlist(int idAnnonce, int idClient) {
		super();
		this.idAnnonce = idAnnonce;
		this.idClient = idClient;
	}
	public Wishlist() {
		super();
	}
	
	
}
