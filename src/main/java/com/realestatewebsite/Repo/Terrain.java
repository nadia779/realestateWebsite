package com.realestatewebsite.Repo;

public class Terrain {
	// superficie	addresse
	private String superficie;
	private String addresse;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSuperficie() {
		return superficie;
	}
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public Terrain(String superficie, String addresse, int id) {
		super();
		this.superficie = superficie;
		this.addresse = addresse;
		this.id=id;
	}
	public Terrain(String superficie, String addresse) {
		super();
		this.superficie = superficie;
		this.addresse = addresse;
	}
	public Terrain() {
		super();
	}
	
}
