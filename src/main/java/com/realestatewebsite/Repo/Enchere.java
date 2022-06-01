package com.realestatewebsite.Repo;

import java.sql.Date;

public class Enchere {
	// 	id	dateFin	dateDebut	prix	id_terrain	id_annonceur	

	private int idAnnonceur;
	private int idTerrain;
	private double prix;
	private Date dateDebut;
	private Date dateFin;
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
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Enchere(int idAnnonceur, int idTerrain, double prix, Date dateDebut, Date dateFin) {
		super();
		this.idAnnonceur = idAnnonceur;
		this.idTerrain = idTerrain;
		this.prix = prix;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	public Enchere() {
		super();
	}
	
	
}
