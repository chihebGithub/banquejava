package com.banque.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws  IOException {
		// TODO Auto-generated method stub
	
		try {
			this.getServletContext().getRequestDispatcher( "/addClient.jsp" ).forward( request, response );
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	public boolean validateData(String ...args) {
		for (String s : args)
		{
			if(s.equals(null))return false;
		}
		
		return true;
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	if(!validateData(request.getParameter("firstname"),request.getParameter("lastname")
			,request.getParameter("cin"),request.getParameter("email"),request.getParameter("contry"),
			request.getParameter("password")
			))
	 {
		try {
			this.getServletContext().getRequestDispatcher( "/login.jsp" ).forward( request, response );
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}else {
		//request.setAttribute( "test", message );
		ServletContext context = getServletContext();
		 HttpSession session = request.getSession();
		 session.setAttribute("uname",request.getParameter("email"));
		 session.setAttribute("cin",request.getParameter("cin"));
		 System.out.println(request.getParameter("email"));
		context.setAttribute("message", request.getParameter("firstname") +" "+ request.getParameter("lastname") );
		Client C = new Client();
		InterfaceClient stubclient = new ClientImpl();
		C.setCodClt(request.getParameter("cin"));
		C.setName(request.getParameter("firstname"));
		C.setFirstName(request.getParameter("lastname"));
		C.setEmail(request.getParameter("email"));
		C.setSex(request.getParameter("sex"));
		C.setCountry(request.getParameter("contry"));
		C.setPassword(request.getParameter("password"));
		stubclient.addClient(C);
		request.setAttribute("bean",C);
		try {
			this.getServletContext().getRequestDispatcher( "/ajouterClient.jsp" ).forward( request, response );
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		
	  }
		
	}		
	}

}
