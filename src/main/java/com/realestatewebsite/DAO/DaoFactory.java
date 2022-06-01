package com.realestatewebsite.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	private String url;
	private String username;
	private String password;
	private static DaoFactory instance= null;
	
	private DaoFactory(String url, String username,String password) {
		this.url=url;
		this.username=username;
		this.password=password;
	}
	
	public static  DaoFactory getInstance() {
		if(instance==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			instance= new DaoFactory("jdbc:mysql://localhost:3306/realestatedb","root","123");
			return instance;
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(this.url,this.username,this.password);
	}
	
	public DaoClient getDaoClient() {
		return new DaoClient(this);
	}
	
	public DaoVendeur getDaoVendeur() {
		return new DaoVendeur(this);
	}
	
	public DaoTerrain getDaoTerrain() {
		return new DaoTerrain(this);
	}
	
	public DaoWishlist getDaoWishlist() {
		return new DaoWishlist(this);
	}
	
	public DaoAnnonce getDaoAnnonce() {
		return new DaoAnnonce(this);
	}
	
	public DaoOffre getDaoOffre() {
		return new DaoOffre(this);
	}
	
	public DaoEnchere getDaoEnchere() {
		return new DaoEnchere(this);
	}
}

