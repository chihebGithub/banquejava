package com.banque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.banque.beans.Client;
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
				c.setSolde(rs.getDouble("solde"));
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
		String[] nomTAbleau = {"numCpt" ,"codNatCpt" , "solde" , "codClt"};
		try {
			rs=bdd.fcSelectComand(nomTAbleau, "comptes","numCpt = '"+c+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Compte cpt = new Compte();
		try {
			while (rs.next()) {
				cpt.setCodclt(rs.getString("codClt"));
				cpt.setCodNatCpt(rs.getInt("codNatCpt"));
				cpt.setSolde(rs.getDouble("solde"));
				cpt.setNumCpt(rs.getLong("numCpt"));
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cpt ;
		
	}

	public void deleteCompte(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getComptebyNatureAndNum(long nat, long num) {
		String[] nomTAbleau = {"numCpt" ,"codNatCpt" , "solde" , "codClt"};
		try {
			rs=bdd.fcSelectComand(nomTAbleau, "comptes","numCpt = '"+num+"' and codNatCpt ='"+nat+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Compte cpt = new Compte();
		try {
			while (rs.next()) {
				cpt.setCodclt(rs.getString("codClt"));
				cpt.setCodNatCpt(rs.getInt("codNatCpt"));
				cpt.setSolde(rs.getDouble("solde"));
				cpt.setNumCpt(rs.getLong("numCpt"));
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return cpt.getNumCpt()!=0;
	}

	@Override
	public long getNumCompte() {
	
		try {
			rs=bdd.executionQuery("SELECT MAX(numCpt)as max FROM comptes");
			if(rs.next()) return rs.getLong("max");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<Compte> getAllComptesParCLient(long cin) {
		List<Compte> liste = getAllComptes();
		System.out.println(liste);
		//System.out.println(liste.get(1).getNumCpt());
		List<Compte> filtered =
				liste
			        .stream()
			        .filter(p -> Long.parseLong(p.getCodclt())== cin)
			        .collect(Collectors.toList());
		System.out.println(filtered);
		return filtered;
	}

	@Override
	public int virement(Compte C1, Compte C2, double montant) throws SQLException {
	   
	/*if(!C1.getCodclt().equals(C2.getCodclt())){
		return -1;
	}else if(C1.getSolde()-montant<0) {
		return -2;
	}
	else {
		C1.setSolde(C1.getSolde()-montant);
		C2.setSolde(C2.getSolde()+montant);
		try {*/
			bdd.executeUpdate("update comptes set solde = '"+(C1.getSolde()-montant)+"' where numCpt ='"+C1.getNumCpt()+"'");
			bdd.executeUpdate("update comptes set solde = '"+(C2.getSolde()+montant)+"' where numCpt ='"+C2.getNumCpt()+"'");
		    return 0;
/*		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return C1.hashCode();
	}
*/
}
}