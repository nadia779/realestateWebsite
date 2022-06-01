package com.realestatewebsite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.realestatewebsite.Repo.Offre;

public class DaoOffre implements DaoInterface<Offre>{
	private DaoFactory factory;
	
	public DaoOffre(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public void ajouter(Offre offre) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = factory.getConnection();
			String query = "insert into offres(id_enchere,id_client, prix) values(?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1,offre.getIdEnchere());
			statement.setInt(2,offre.getIdClient());
			statement.setDouble(3, offre.getPrix());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimer(Offre offre) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = factory.getConnection();
			String query = "delete from offres where id_enchere=? and id_client=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,offre.getIdEnchere());
			statement.setInt(2,offre.getIdClient());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(Offre offre, Offre newoffre) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = factory.getConnection();
			String query = "update offres set id_enchere=? ,id_client=? , prix=? where id_enchere=? and id_client=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,newoffre.getIdEnchere());
			statement.setInt(2,newoffre.getIdClient());
			statement.setDouble(3, newoffre.getPrix());
			statement.setInt(4,offre.getIdEnchere());
			statement.setInt(5,offre.getIdClient());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Offre> afficherAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Offre> offres = new ArrayList<>();
		try {
			connection = factory.getConnection();
			String query = "select * from offres";
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Offre offre = new Offre();
				offre.setIdClient(results.getInt("id_client"));
				offre.setIdEnchere(results.getInt("id_enchere"));
				offre.setPrix(results.getDouble("id_prix"));
				offres.add(offre);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return offres;
	}
	
}
