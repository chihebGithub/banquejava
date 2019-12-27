package com.banque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


import com.banque.beans.Compte;
import com.banque.beans.Operation;

import configurationsDB.BDD;

public class OperationImpl implements InterfaceOperation {
	  BDD bdd = new BDD();
		
		ResultSet rs=null;
	
	@Override
	public List<Operation> getAllOperations(Compte C) {
		 List<Operation> l = new ArrayList<>();		
		 try {
				ResultSet rs = bdd.executionQuery("select * from Operation where numCompte = '" + C.getNumCpt() +"'");
				 while(rs.next()) {
					l.add(new Operation(rs.getDate(1), rs.getLong(2), rs.getDouble(3),rs.getDouble(4), 
							rs.getDouble(5),rs.getString(6)));
				}
	             
			} catch (
	 
			Exception e) {
				e.printStackTrace();
			}
		  
		return l;
	}

	@Override
	public void addOperation(Operation O) {
		String[] nomTAbleau = {"dateMouvement" ,"numCompte" , "montant" ,"soldeAvant","soldeApres"
			,"CompteY","typeOperation"
		 };
		String[] contenuTAbleau = new String [7];
		
	    
		contenuTAbleau[0]= String.valueOf(O.getDateMouvement());
		contenuTAbleau[1]= String.valueOf(O.getCompteX());
		contenuTAbleau[2]= String.valueOf(O.getMontant());
		
		
		try {
			 
		
			 IntCompteDao stubcompte = new CompteImpl();
			
			 Compte C = new Compte();
			 C = stubcompte.getCompteByNumero(O.getCompteX());
			 O.setSoldeAvant(C.getSolde());
			 System.out.println(C.getSolde());
			 double sld=0.0;
			 if(O.getTypeOperation()=="VRS")  sld=(C.getSolde()+O.getMontant());
			 else sld=(C.getSolde()-O.getMontant());
			 O.setSoldeApres(sld);
			    contenuTAbleau[3]= String.valueOf(O.getSoldeAvant());
			    contenuTAbleau[4]= String.valueOf(O.getSoldeApres());
				contenuTAbleau[5]= String.valueOf(O.getCompteY());
				contenuTAbleau[6]= String.valueOf(O.getTypeOperation());
				bdd.queryInsert("Operation",nomTAbleau,contenuTAbleau);
			bdd.executeUpdate("update comptes set solde = '" +sld  +"' where numCpt = '" +O.getCompteX() +"'" );
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
