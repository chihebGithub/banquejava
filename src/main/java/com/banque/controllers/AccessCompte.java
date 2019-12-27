package com.banque.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banque.beans.Compte;
import com.banque.dao.CompteImpl;
import com.banque.dao.IntCompteDao;

/**
 * Servlet implementation class AccessCompte
 */
public class AccessCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    static IntCompteDao cpt = new CompteImpl () ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cin =request.getParameter("cin");;
		request.setAttribute("err","err");
		if (cin!=(null) ) {
			
			Compte c = new Compte();
			c.setCodNatCpt(Integer.parseInt( request.getParameter("type")));
			c.setCodclt(cin);
			c.setSolde(0);
			cpt.addCompte(c);
			request.setAttribute("bean",c);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/comptesucces.jsp");
		dispatcher.forward( request, response);
		}
	}

}
