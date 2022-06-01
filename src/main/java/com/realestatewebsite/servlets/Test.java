package com.realestatewebsite.servlets;

import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realestatewebsite.DAO.DaoClient;
import com.realestatewebsite.DAO.DaoFactory;
import com.realestatewebsite.DAO.DaoOffre;
import com.realestatewebsite.Repo.Client;
import com.realestatewebsite.Repo.Offre;


@WebServlet("/Test")
public class Test extends HttpServlet {
	private DaoFactory factory;
	
	@Override
	public void init (ServletConfig config) throws ServletException
    {
       super.init(config);
       factory = DaoFactory.getInstance();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoClient doa = factory.getDaoClient();
		Client client = new Client("nadia" , "mofid","email","123" ,"kenitra","0625874984");
		doa.ajouter(client);
	}



}