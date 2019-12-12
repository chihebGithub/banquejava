package com.banque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banque.beans.Client;
import com.banque.beans.Compte;

import configurationsDB.BDD;

public class ClientImpl implements InterfaceClient  {
   
    BDD bdd = new BDD();
	
	ResultSet rs=null;
	
	@Override
	public List<Client> getAllClient() {

		
		   List<Client> l = new ArrayList<Client>();
			try {
				ResultSet rs = bdd.querySelectAll("Client");
				 while(rs.next()) {
					 Client c = new Client();
				     c.setCodClt(rs.getString(1));
				     c.setName(rs.getString(2));
				     c.setFirstName(rs.getString(3));
				     c.setAdress(rs.getString(4));
				     c.setEmail(rs.getString(5));
				     c.setSex(rs.getString(6));
				     c.setCountry(rs.getString(7));
					l.add(c);
				
				}
	             
			} catch (
	 
			Exception e) {
				e.printStackTrace();
			}
			return l;
		
	}

	@Override
	public void addClient(Client C) {
		// TODO Auto-generated method stub
	
			String[] nomTAbleau = {"codClt" ,"name" , "firstName" , "adress" , "email",
					"Sex","Country"};
			String[] contenuTAbleau = new String [7];
			contenuTAbleau[0]= String.valueOf(C.getCodClt());
			contenuTAbleau[1]= String.valueOf(C.getName());
			contenuTAbleau[2]= String.valueOf(C.getFirstName());
			contenuTAbleau[3]= String.valueOf(C.getAdress());
			contenuTAbleau[4]= String.valueOf(C.getEmail());
			contenuTAbleau[5]= String.valueOf(C.getSex());
			contenuTAbleau[6]= String.valueOf(C.getCountry());
			try {
			
				bdd.queryInsert("Client",nomTAbleau,contenuTAbleau);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			
		
	}

	@Override
	public Client getClientByNumero(String c) throws ClassNotFoundException {
		String[] nomTAbleau = {"codClt" ,"name" , "firstName" , "adress" , "email",
				"Sex","Country"};
		try {
			rs=bdd.fcSelectComand(nomTAbleau, "Client","codClt = '"+c+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Client clt = new Client();
		try {
			while (rs.next()) {
				
				clt.setCodClt(rs.getString(1));
				clt.setName(rs.getString("name"));
				clt.setFirstName(rs.getString("firstName"));
				clt.setName(rs.getString("name"));
				clt.setAdress(rs.getString("adress"));
				clt.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clt ;
		
	}

	@Override
	public void deleteClient(long id) {
		// TODO Auto-generated method stub
		
	}

}
