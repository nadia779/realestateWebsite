package com.realestatewebsite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.realestatewebsite.Repo.Client;

public class DaoClient implements DaoInterface<Client>{
	private DaoFactory factory;
	
	public DaoClient(DaoFactory factory) {
		this.factory=factory;
	}

	@Override
	public void ajouter(Client client) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = this.factory.getConnection();
			String query= "insert into clients(nom, prenom,email,password,adresse,tele) values (?,?,?,?,?,?)";
			statement= connection.prepareStatement(query);
			statement.setString(1, client.getNom());
			statement.setString(2, client.getPrenom());
			statement.setString(3, client.getEmail());
			statement.setString(4, client.getPassword());
			statement.setString(5, client.getAdresse());
			statement.setString(6, client.getTele());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimer(Client client) {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = this.factory.getConnection();
			String query= "delete from clients where email=?";
			statement= connexion.prepareStatement(query);
			statement.setString(1, client.getEmail());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(Client client, Client newClient) {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = this.factory.getConnection();
			String query= "update clients set nom=? , prenom= ? , email= ?, password = ?, adresse = ? , tele = ? "
					+ "where email=?";
			statement= connexion.prepareStatement(query);
			statement.setString(1, newClient.getNom());
			statement.setString(2, newClient.getPrenom());
			statement.setString(3, newClient.getEmail());
			statement.setString(4, newClient.getPassword());
			statement.setString(5, newClient.getAdresse());
			statement.setString(6, newClient.getTele());
			statement.setString(7, client.getEmail());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Client> afficherAll() {
		Connection connexion = null;
		PreparedStatement statement = null;
		List<Client> clients= new ArrayList<>();
		try {
			connexion = this.factory.getConnection();
			String query = "select * from clients";
			statement= connexion.prepareStatement(query);
			ResultSet results=statement.executeQuery();
			while(results.next()) {
				Client client = new Client();
				client.setNom(results.getString("nom"));
				client.setPassword(results.getString("password"));
				client.setPrenom(results.getString("prenom"));
				client.setAdresse(results.getString("adresse"));
				client.setEmail(results.getString("email"));
				client.setTele(results.getString("tele"));
				clients.add(client);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}
}
