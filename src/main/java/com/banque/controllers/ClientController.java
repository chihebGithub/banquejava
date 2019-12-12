package com.banque.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banque.beans.Client;
import com.banque.dao.ClientImpl;
import com.banque.dao.InterfaceClient;

/**
 * Servlet implementation class ClientController
 */
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		this.getServletContext().getRequestDispatcher( "/addClient.jsp" ).forward( request, response );
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client C = new Client();
		InterfaceClient stubclient = new ClientImpl();
		C.setCodClt(request.getParameter("cin"));
		C.setName(request.getParameter("name"));
		C.setFirstName(request.getParameter("lastname"));
		C.setEmail(request.getParameter("email"));
		C.setSex(request.getParameter("sex"));
		C.setCountry(request.getParameter("country"));
		C.setAdress(request.getParameter("adress"));
		stubclient.addClient(C);
		request.setAttribute("bean",C);
		this.getServletContext().getRequestDispatcher( "/Ajoutsucces.jsp" ).forward( request, response );
		
	}

}
