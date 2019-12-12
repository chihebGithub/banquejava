package com.banque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banque.beans.Compte;

import configurationsDB.BDD;

public class CompteImpl implements IntCompteDao {
	BDD bdd = new BDD();
	
	ResultSet rs=null;
	public List<Compte> getAllComptes() {
		
	   List<Compte> l = new ArrayList<Compte>();
		try {
			ResultSet rs = bdd.querySelectAll("comptes");
			 while(rs.next()) {
				 Compte c = new Compte();
				 c.setNumCpt(rs.getInt(1));
				 c.setCodNatCpt(rs.getInt("codNatCpt"));
				 c.setCodclt(rs.getString("codclt"));
				//System.out.println(rs.getInt(1));
				l.add(c);
			
			}
             
		} catch (
 
		Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public void addCompte(Compte C) {
		String[] nomTAbleau = {"codNatCpt" ,"solde" , "codClt"};
		String[] contenuTAbleau = new String [3];
		contenuTAbleau[0]= String.valueOf(C.getCodNatCpt());
		contenuTAbleau[1]= String.valueOf(C.getSolde());
		contenuTAbleau[2]= String.valueOf(C.getCodclt());
		try {
			bdd.queryInsert("comptes",nomTAbleau,contenuTAbleau);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	public Compte getCompteByNumero(long c) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteCompte(long id) {
		// TODO Auto-generated method stub
		
	}

}
