package com.realestatewebsite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.realestatewebsite.Repo.Annonce;



public class DaoAnnonce implements DaoInterface<Annonce>{
	private DaoFactory factory;
	
	public DaoAnnonce(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public void ajouter(Annonce annonce) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = factory.getConnection();
			String query = "insert into annonces(id_annonceur,id_terrain,titre,description,prix,datedepub) values"
					+ "(?,?,?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, annonce.getIdAnnonceur());
			statement.setInt(2, annonce.getIdTerrain());
			statement.setString(3, annonce.getTitre());
			statement.setString(4, annonce.getDescription());
			statement.setDouble(5, annonce.getPrix());
			statement.setDate(6, annonce.getDateDePub());
			statement.execute();
		}catch(SQLException e) {}
	}

	@Override
	public void supprimer(Annonce annonce) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = factory.getConnection();
			String query = "delete from  annonces where id_annonceur= ? and id_terrain= ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, annonce.getIdAnnonceur());
			statement.setInt(2, annonce.getIdTerrain());
			statement.execute();
		}catch(SQLException e) {}
	}

	@Override
	public void modifier(Annonce annonce, Annonce newannonce) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = factory.getConnection();
			String query = "update annonces set id_annonceur= ? , id_terrain=?, titre = ?,description=?, prix=?,datedepub=? "
					+ "where id_annonceur= ? and id_terrain=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, newannonce.getIdAnnonceur());
			statement.setInt(2, newannonce.getIdTerrain());
			statement.setString(3, newannonce.getTitre());
			statement.setString(4, newannonce.getDescription());
			statement.setDouble(5, newannonce.getPrix());
			statement.setDate(6, newannonce.getDateDePub());
			statement.setInt(7, annonce.getIdAnnonceur());
			statement.setInt(8, annonce.getIdTerrain());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Annonce> afficherAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Annonce> annonces = new ArrayList<>();
		try {
			connection = factory.getConnection();
			String query = "select * from annonces";
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Annonce annonce = new Annonce();
				annonce.setDateDePub(results.getDate("datedepub"));
				annonce.setDescription(results.getString("description"));
				annonce.setIdAnnonceur(results.getInt("id_annonceur"));
				annonce.setIdTerrain(results.getInt("id_terrain"));
				annonce.setPrix(results.getDouble("prix"));
				annonce.setTitre(results.getString("titre"));
				annonces.add(annonce);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return annonces;
	}
	
}

