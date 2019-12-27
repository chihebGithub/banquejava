package com.banque.controllers;

import java.io.IOException;
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
 * Servlet implementation class CompteController
 */
public class CompteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CompteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/addCompte.jsp").forward(request, response);
		// ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long numCpt = 0;
		String Code = request.getParameter("name");
		String numCompte = request.getParameter("numCpt");
		String cinExist = request.getParameter("cinExist");
		double montant = 0.0;
		
		System.out.println("variable cin contient" + cinExist);
		System.out.println("variable contient :" + numCompte);
		if (numCompte != null && numCompte!="") {
			numCpt = Long.parseLong(request.getParameter("numCpt"));
			System.out.println("numero de compte +" + numCpt);
			System.out.println(Code);
		}
		response.setContentType("application/json");
		JSONObject client = new JSONObject();
		InterfaceClient stubclient = new ClientImpl();
		IntCompteDao stubCpt = new CompteImpl();
		Compte cpt = new Compte();
		
        String TypeCpt= request.getParameter("TypeCpt");
        System.out.println("type de compte" + TypeCpt);
		try {
			cpt = stubCpt.getCompteByNumero(numCpt);
			boolean	cptVerif =false;
	     if(TypeCpt!=""&&TypeCpt!=null) {		cptVerif=stubCpt.getComptebyNatureAndNum(Long.parseLong(TypeCpt), numCpt);}
		System.out.println("compte after verification " +cptVerif);
		if(!cptVerif)  client.put("errTypeCompte","verifier données de compte");
			
			System.out.println("test"+request.getParameter("montant"));
			if (request.getParameter("montant") != null && request.getParameter("montant")!="") {
				montant = Double.parseDouble(request.getParameter("montant"));
				double taxe;
				if(TypeCpt==  "100") taxe = montant*000.1/100; 
				else taxe =montant * 000.2/100;
				if((cpt.getSolde()-(montant+taxe))<0) {
					client.put("errMontant","solde insuffisant  :" + cpt.getSolde()+ " < " + montant + " + taxe : " + taxe);
				}
				
			}
			
			
			if (cpt.getCodclt() != "")
			System.out.println("apres get :" + cpt.getCodclt());
			if (cpt.getCodclt() != null) {
				Client trouve = stubclient.getClientByNumero(cpt.getCodclt());
				client.put("nomClient", trouve.getName());
				client.put("prnClient", trouve.getFirstName());
			//	System.out.println("code client :" + cpt.getCodclt());
				//System.out.println("cin get is :" + cinExist);
				if (!cpt.getCodclt().equals(cinExist)) {
					client.put("cinExist", "carte identité invalide");
				}
			/*	if (cpt.getSolde() > 100) {
					client.put("cinExist", "carte identité invalide");
				}
				*/

			} else {
				client.put("errCompteExiste", "Compte n'existe pas ");
				System.out.println("compte n'existe pas");
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		if (Code != (null)) {

			try {
				this.getServletContext().getRequestDispatcher("/addCompte.jsp");
				Client ab = new Client();

				String nom = request.getParameter("name");

				ab = stubclient.getClientByNumero(nom);
				System.out.println("truve " + ab.getCodClt());

				System.out.println(ab.getCodClt());
				if (ab.getCodClt() == null) {
					client.put("errClient", "Client n'existe pas");
				}

				if (ab.getCodClt() != null) {
					client.put("err", "Client déja existe");
				}

				client.put("name", ab.getName());
				client.put("firstname", ab.getFirstName());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			request.setAttribute("err", "Veuillez renseigner le champ code client");
		}

		String email = request.getParameter("email");

		boolean verif = stubclient.emailExists(email);
		System.out.println(verif);
		if (!verif)
			client.put("erremail", "email n'existe pas ");
		if (verif)
			client.put("errexist", "email déja utilisé");
		response.getWriter().write(client.toString());

	}

}
