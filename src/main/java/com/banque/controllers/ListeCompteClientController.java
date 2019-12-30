package com.banque.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banque.beans.Compte;
import com.banque.dao.CompteImpl;
import com.banque.dao.IntCompteDao;

/**
 * Servlet implementation class ListeCompteClientController
 */
public class ListeCompteClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeCompteClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IntCompteDao stubcpt= new CompteImpl();
		ServletContext context = getServletContext();
		long cin=0;
		if(context.getAttribute("cin")!=null)cin  = (long)context.getAttribute("cin");
		 System.out.println(cin);
	     List <Compte> l2 = stubcpt.getAllComptesParCLient(cin);
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
