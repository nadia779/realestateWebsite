package com.realestatewebsite.Repo;

public class Vendeur  {
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String adresse;
	private String tele;
	private boolean isParticulier;
	private int compteurvente;
	
	public Vendeur(String nom, String prenom, String email, String password, String adresse, String tele,
			boolean isParticulier, int compteurvente) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.adresse = adresse;
		this.tele = tele;
		this.isParticulier = isParticulier;
		this.compteurvente = compteurvente;
	}
	
	public Vendeur() {
		super();
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public boolean isParticulier() {
		return isParticulier;
	}
	public void setParticulier(boolean isParticulier) {
		this.isParticulier = isParticulier;
	}
	public int getCompteurvente() {
		return compteurvente;
	}
	public void setCompteurvente(int compteurvente) {
		this.compteurvente = compteurvente;
	}
}
