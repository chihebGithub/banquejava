package com.banque.controllers;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.banque.beans.Client;
import com.banque.dao.ClientImpl;
import com.banque.dao.InterfaceClient;



/**
 * Servlet implementation class CompteController
 */
public class CompteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 	this.getServletContext().getRequestDispatcher("/addCompte.jsp" ).forward( request, response );
	//	;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Code =request.getParameter("name");;
		System.out.println(Code);
		if (Code!=(null) ) {
			InterfaceClient stubclient = new ClientImpl();
			try {
				this.getServletContext().getRequestDispatcher("/addCompte.jsp" );
				Client ab = new Client();

				String nom = request.getParameter("name");
				ab = stubclient.getClientByNumero(nom);
				;
				response.setContentType("application/json");
				JSONObject client = new JSONObject();
				client.put("name", ab.getName());
				client.put("firstname", ab.getFirstName());

				response.getWriter().write(client.toString());
				

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
	}else {
		request.setAttribute("err", "Veuillez renseigner le champ code client");
	}
	
		
}	
	
}
