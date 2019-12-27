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
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static InterfaceClient stubclient = new ClientImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(!validateData(request.getParameter("password"),request.getParameter("emailname")))
		 {
			try {
				this.getServletContext().getRequestDispatcher( "/login.jsp" ).forward( request, response );
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else {
			//request.setAttribute( "test", message );
		
			
		
			Client C = new Client();
			C.setEmail(request.getParameter("emailname"));
			C.setPassword(request.getParameter("password"));
			System.out.println("pass +" + C.getPassword());
			System.out.println(C.getEmail());
		 if(stubclient.login(C))
		 {
			 HttpSession session = request.getSession();
			 session.setAttribute("uname",request.getParameter("emailname"));
			request.setAttribute("bean",C);
			ServletContext context = getServletContext();
			context.setAttribute("message", request.getParameter("emailname") );
			
			try {
				this.getServletContext().getRequestDispatcher( "/ajouterClient.jsp" ).forward( request, response );
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			
		  }
		 }else {
			 try {
					this.getServletContext().getRequestDispatcher( "/login.jsp" ).forward( request, response );
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				
			  }
		 }
		 
		 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public boolean validateData(String ...args) {
		for (String s : args)
		{
			if(s.equals(null))return false;
		}
		
		return true;
		
	}
	

}
