package com.realestatewebsite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.realestatewebsite.Repo.Terrain;

public class DaoTerrain implements DaoInterface<Terrain>{
	private DaoFactory factory;
	
	public DaoTerrain(DaoFactory factory) {
		this.factory=factory;
	}

	@Override
	public void ajouter(Terrain terrain) {
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection = factory.getConnection();
			String query = "insert into terrains(superficie,addresse) values (?,?)";
			statement=connection.prepareStatement(query);
			statement.setString(1, terrain.getSuperficie());
			statement.setString(2, terrain.getAddresse());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimer(Terrain terrain) {
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection = factory.getConnection();
			String query = "delete from terrains where id=? ";
			statement=connection.prepareStatement(query);
			statement.setInt(1, terrain.getId());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(Terrain terrain, Terrain newterrain) {
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection = factory.getConnection();
			String query = "update terrains set superficie=?, addresse=? where id= ?";
			statement=connection.prepareStatement(query);
			statement.setString(1, newterrain.getSuperficie());
			statement.setString(2, newterrain.getAddresse());
			statement.setInt(3, terrain.getId());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Terrain> afficherAll() {
		Connection connection= null;
		PreparedStatement statement = null;
		List<Terrain> terrains= new ArrayList<>();
		try {
			connection = factory.getConnection();
			String query = "select * from terrains";
			statement= connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Terrain terrain= new Terrain();
				terrain.setAddresse(results.getString("addresse"));
				terrain.setId(results.getInt("id"));
				terrain.setSuperficie(results.getString("superficie"));
				terrains.add(terrain);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
