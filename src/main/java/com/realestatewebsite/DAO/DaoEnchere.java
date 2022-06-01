package com.realestatewebsite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.realestatewebsite.Repo.Enchere;

public class DaoEnchere implements DaoInterface<Enchere>{
private DaoFactory factory;
	
	public DaoEnchere(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public void ajouter(Enchere enchere) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = factory.getConnection();
			String query = "insert into encheres (id_annonceur, id_terrain, prix, datedebut,datefin) values(?,?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1,enchere.getIdAnnonceur());
			statement.setInt(2,enchere.getIdTerrain());
			statement.setDouble(3,enchere.getPrix());
			statement.setDate(4,enchere.getDateDebut());
			statement.setDate(5,enchere.getDateFin());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimer(Enchere enchere) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = factory.getConnection();
			String query = "delete from encheres where id_annonceur = ? and  id_terrain= ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,enchere.getIdAnnonceur());
			statement.setInt(2,enchere.getIdTerrain());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifier(Enchere enchere, Enchere newenchere) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = factory.getConnection();
			String query = "update encheres set id_annonceur=? , id_terrain=?, prix=?, datedebut=?,datefin=? where "
					+ "id_annonceur=? and id_terrain=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,newenchere.getIdAnnonceur());
			statement.setInt(2,newenchere.getIdTerrain());
			statement.setDouble(3,newenchere.getPrix());
			statement.setDate(4,newenchere.getDateDebut());
			statement.setDate(5,newenchere.getDateFin());
			statement.setInt(6,enchere.getIdAnnonceur());
			statement.setInt(7,enchere.getIdTerrain());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Enchere> afficherAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Enchere> encheres = new ArrayList<>();
		try {
			connection = factory.getConnection();
			String query = "select * from encheres";
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Enchere enchere = new Enchere();
				enchere.setDateDebut(results.getDate("datedebut"));
				enchere.setDateDebut(results.getDate("datefin"));
				enchere.setIdAnnonceur(results.getInt("id_annonceur"));
				enchere.setIdTerrain(results.getInt("id_terrain"));
				enchere.setPrix(results.getDouble("prix"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return encheres;
	}
}
