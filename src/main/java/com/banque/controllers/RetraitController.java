package com.banque.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banque.beans.Operation;
import com.banque.dao.InterfaceOperation;
import com.banque.dao.OperationImpl;

/**
 * Servlet implementation class RetraitController
 */
public class RetraitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetraitController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Operation O = new Operation();
		O.setTypeOperation("RTRD");
		O.setCompteX(Integer.parseInt(request.getParameter("numCpt")));
		O.setMontant(Double.parseDouble(request.getParameter("montant")));
		InterfaceOperation stub = new OperationImpl ();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		final String stringDate= dateFormat.format(new Date());
		final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
		O.setDateMouvement(sqlDate);
	    stub.addOperation(O);
	    request.setAttribute("bean",O);
	    try {
			this.getServletContext().getRequestDispatcher( "/OperationSucces.jsp" ).forward( request, response );
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		
	  }
	}

}
