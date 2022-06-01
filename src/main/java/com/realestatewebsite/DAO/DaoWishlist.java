package com.realestatewebsite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.realestatewebsite.Repo.Wishlist;

public class DaoWishlist implements DaoInterface<Wishlist>{
	private DaoFactory factory;
	
	public DaoWishlist(DaoFactory factory) {
		this.factory=factory;
	}

	@Override
	public void ajouter(Wishlist wishlist) {
		Connection connection =  null;
		PreparedStatement statement = null;
		
		try {
			connection = factory.getConnection();
			String query="Insert into wishlists values(?,?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, wishlist.getIdAnnonce());
			statement.setInt(2,wishlist.getIdClient());
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimer(Wishlist wishlist) {
		Connection connection =  null;
		PreparedStatement statement = null;
		
		try {
			connection = factory.getConnection();
			String query="delete from wishlists where id_annonce=? and id_client=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, wishlist.getIdAnnonce());
			statement.setInt(2,wishlist.getIdClient());
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(Wishlist wishlist, Wishlist newwishlist) {
		Connection connection =  null;
		PreparedStatement statement = null;
		
		try {
			connection = factory.getConnection();
			String query="update wishlists set id_annonce=?, id_client=? where id_annonce=? and id_client=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, newwishlist.getIdAnnonce());
			statement.setInt(2, newwishlist.getIdClient());
			statement.setInt(3, wishlist.getIdAnnonce());
			statement.setInt(4,wishlist.getIdClient());
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Wishlist> afficherAll() {
		Connection connection =  null;
		PreparedStatement statement = null;
		List<Wishlist> wishlists = new ArrayList<>();
		try {
			connection = factory.getConnection();
			String query="select * from wishlists where id_client= ?";
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Wishlist wishlist = new Wishlist();
				wishlist.setIdAnnonce(results.getInt("id_annonce"));
				wishlist.setIdClient(results.getInt("id_client"));
				wishlists.add(wishlist);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return wishlists;
	}
	
	public List<Wishlist> afficherAll(int id) {
		Connection connection =  null;
		PreparedStatement statement = null;
		List<Wishlist> wishlists = new ArrayList<>();
		try {
			connection = factory.getConnection();
			String query="select * from wishlists where id_client= ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Wishlist wishlist = new Wishlist();
				wishlist.setIdAnnonce(results.getInt("id_annonce"));
				wishlist.setIdClient(results.getInt("id_client"));
				wishlists.add(wishlist);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return wishlists;
	}
	
}
