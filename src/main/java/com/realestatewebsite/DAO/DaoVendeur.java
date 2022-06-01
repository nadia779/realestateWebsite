package com.realestatewebsite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.realestatewebsite.Repo.Vendeur;

public class DaoVendeur implements DaoInterface<Vendeur> {
	private DaoFactory factory;
	
	public DaoVendeur(DaoFactory factory) {
		this.factory=factory;
	}
	
	@Override
	public void ajouter(Vendeur vendeur) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = this.factory.getConnection();
			String query= "insert into vendeurs(nom, prenom,email,password,adresse,tele,isParticulier,compteurvente) values (?,?,?,?,?,?,?,?)";
			statement= connection.prepareStatement(query);
			statement.setString(1, vendeur.getNom());
			statement.setString(2, vendeur.getPrenom());
			statement.setString(3, vendeur.getEmail());
			statement.setString(4, vendeur.getPassword());
			statement.setString(5, vendeur.getAdresse());
			statement.setString(6, vendeur.getTele());
			statement.setBoolean(7, vendeur.isParticulier());
			statement.setInt(8, vendeur.getCompteurvente());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimer(Vendeur vendeur) {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = this.factory.getConnection();
			String query= "delete from vendeurs where email=?";
			statement= connexion.prepareStatement(query);
			statement.setString(1, vendeur.getEmail());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifier(Vendeur vendeur, Vendeur newvendeur) {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = this.factory.getConnection();
			String query= "update vendeurs set nom=? , prenom= ? , email= ?, password = ?, adresse = ? , tele = ?, "
					+ "isparticulier= ?, compteurvente=? where email=?";
			statement= connexion.prepareStatement(query);
			statement.setString(1, newvendeur.getNom());
			statement.setString(2, newvendeur.getPrenom());
			statement.setString(3, newvendeur.getEmail());
			statement.setString(4, newvendeur.getPassword());
			statement.setString(5, newvendeur.getAdresse());
			statement.setString(6, newvendeur.getTele());
			statement.setBoolean(7,newvendeur.isParticulier());
			statement.setInt(8, newvendeur.getCompteurvente());
			statement.setString(9, vendeur.getEmail());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Vendeur> afficherAll() {
		Connection connexion = null;
		PreparedStatement statement = null;
		List<Vendeur> vendeurs= new ArrayList<>();
		try {
			connexion = this.factory.getConnection();
			String query = "select * from vendeurs";
			statement= connexion.prepareStatement(query);
			ResultSet results=statement.executeQuery();
			while(results.next()) {
				Vendeur vendeur = new Vendeur();
				vendeur.setNom(results.getString("nom"));
				vendeur.setPassword(results.getString("password"));
				vendeur.setPrenom(results.getString("prenom"));
				vendeur.setAdresse(results.getString("adresse"));
				vendeur.setEmail(results.getString("email"));
				vendeur.setTele(results.getString("tele"));
				vendeur.setParticulier(results.getBoolean("isparticulier"));
				vendeur.setCompteurvente(results.getInt("compteurvente"));
				vendeurs.add(vendeur);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return vendeurs;
	}
	

}
