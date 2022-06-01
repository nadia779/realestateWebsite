package com.realestatewebsite.Repo;

import java.sql.Date;

public class Annonce {

	private int idAnnonceur;
	private int idTerrain;
	private double prix;
	private String description;
	private String titre;
	private Date dateDePub;
	public int getIdAnnonceur() {
		return idAnnonceur;
	}
	public void setIdAnnonceur(int idAnnonceur) {
		this.idAnnonceur = idAnnonceur;
	}
	public int getIdTerrain() {
		return idTerrain;
	}
	public void setIdTerrain(int idTerrain) {
		this.idTerrain = idTerrain;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateDePub() {
		return dateDePub;
	}
	public void setDateDePub(Date dateDePub) {
		this.dateDePub = dateDePub;
	}
	public Annonce(int idAnnonceur, int idTerrain, String description, String titre,double prix,  Date dateDePub) {
		super();
		this.idAnnonceur = idAnnonceur;
		this.idTerrain = idTerrain;
		this.prix = prix;
		this.description = description;
		this.titre = titre;
		this.dateDePub = dateDePub;
	}
	public Annonce() {
		super();
		
	}
	
}

