package com.banque.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.banque.beans.Client;
import com.banque.beans.Compte;
import com.banque.dao.ClientImpl;
import com.banque.dao.CompteImpl;
import com.banque.dao.IntCompteDao;
import com.banque.dao.InterfaceClient;

/**
 * Servlet implementation class VirementController
 */
public class VirementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VirementController() {
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numCompte = request.getParameter("numCpt");
		System.out.println(numCompte);
		long numCpt =0;
		long numCpt1 =0;
		String numCompte1 = request.getParameter("numCpt1");
	  if (numCompte != null && numCompte!="") {
			numCpt = Long.parseLong(request.getParameter("numCpt"));
		
		}
	  if (numCompte1 != null && numCompte1!="") {
			numCpt1 = Long.parseLong(request.getParameter("numCpt1"));
		
		}
	
		response.setContentType("application/json");
		JSONObject client = new JSONObject();
		IntCompteDao stubCpt = new CompteImpl();
		Compte cpt = new Compte();
		Compte cpt1 = new Compte();
		InterfaceClient I = new ClientImpl();
		double montant =0.0;
	    String TypeCpt= request.getParameter("type");
	    String TypeCpt1= request.getParameter("type1");
	    System.out.println(TypeCpt);
  if(TypeCpt!=null)
  {	
			try {cpt = stubCpt.getCompteByNumero(numCpt);} catch (ClassNotFoundException e) {e.printStackTrace();
			}
			boolean	cptVerif =false;
	     if(TypeCpt!=""&&TypeCpt!=null) {
	     cptVerif=stubCpt.getComptebyNatureAndNum(Long.parseLong(TypeCpt), numCpt);}
		if(!cptVerif)  client.put("errTypeCompte","verifier données de compte");
		else if(cpt.getSolde()<=0) client.put("errsolde","votre solde ne permet pas d'effectuer l'operation");
		else {
			try {cpt = stubCpt.getCompteByNumero(numCpt);} catch (ClassNotFoundException e) {e.printStackTrace();
			}
		
			try {
				Client C = I.getClientByNumero(cpt.getCodclt());
				 client.put("name",C.getName());
				 client.put("prenom",C.getFirstName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
  }
  
  if(TypeCpt1!=null)
  {	
			try {cpt1 = stubCpt.getCompteByNumero(numCpt1);
			cpt = stubCpt.getCompteByNumero(numCpt);
			System.out.println(cpt1.getCodclt().equals(cpt.getCodclt()));
			} catch (Exception e) {e.printStackTrace();
			}
			boolean	cptVerif =false;
	     if(TypeCpt1!=""&&TypeCpt1!=null) {
	     cptVerif=stubCpt.getComptebyNatureAndNum(Long.parseLong(TypeCpt1), numCpt1);}
		if(!cptVerif)  client.put("errExisteCp2","verifier données de compte");
		else if(!cpt.getCodclt().equals(cpt1.getCodclt())) client.put("errprop","les Deux Compte Doivent avoir le meme propriétaire");
		else {
			try {cpt1 = stubCpt.getCompteByNumero(numCpt1);} catch (ClassNotFoundException e) {e.printStackTrace();
			}
		
			try {
				Client C = I.getClientByNumero(cpt1.getCodclt());
				 client.put("name",C.getName());
				 client.put("prenom",C.getFirstName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
  }
  
 
  
  
		/*	if (request.getParameter("montant") != null && request.getParameter("montant")!="") {
				montant = Double.parseDouble(request.getParameter("montant"));
				double taxe;
				if(TypeCpt==  "100") taxe = montant*000.1/100; 
				else taxe =montant * 000.2/100;
				if((cpt.getSolde()-(montant+taxe))<0) {
					client.put("errMontant","solde insuffisant  :" + cpt.getSolde()+ " < " + montant + " + taxe : " + taxe);
				}
			*/	
			
			
	

		
		response.getWriter().write(client.toString());
		
		
			}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		IntCompteDao  stub = new  CompteImpl();
		long numCpt = Long.parseLong (request.getParameter("numCpt"));
		long numCpt1 = Long.parseLong (request.getParameter("numCpt1"));
		Compte C1= new Compte(),C2 = new Compte();
		try {
			C1 = stub.getCompteByNumero(numCpt);
		    C2 = stub.getCompteByNumero(numCpt1);
		    request.setAttribute("bean",C1);
		    request.setAttribute("bean1",C2);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		double montant =Double.parseDouble(request.getParameter("montant"));
	
		try {
			System.out.println("test"+ stub.virement(C1, C2, montant));
			this.getServletContext().getRequestDispatcher( "/VirementSucces.jsp" ).forward( request, response );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
