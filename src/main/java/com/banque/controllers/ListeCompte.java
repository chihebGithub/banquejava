package com.banque.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banque.beans.Client;
import com.banque.beans.Compte;
import com.banque.dao.ClientImpl;
import com.banque.dao.CompteImpl;
import com.banque.dao.IntCompteDao;
import com.banque.dao.InterfaceClient;

/**
 * Servlet implementation class ListeCompte
 */
public class ListeCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 IntCompteDao stubcpt= new CompteImpl();
	     List <Compte> l2 = stubcpt.getAllComptes();
	     System.out.println(l2);
	     double sum = 0;
	  for (Compte c: l2) {
		  sum+=c.getSolde();
	  }
	  System.out.println(sum);
	      request.setAttribute("sum",sum);
	     request.setAttribute("liste",l2);
		this.getServletContext().getRequestDispatcher( "/ListeCompte.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
