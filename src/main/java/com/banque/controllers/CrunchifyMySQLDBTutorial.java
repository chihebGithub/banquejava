package com.banque.controllers;


import java.util.List;

import com.banque.beans.Client;
import com.banque.beans.Compte;
import com.banque.dao.ClientImpl;
import com.banque.dao.CompteImpl;
import com.banque.dao.IntCompteDao;
import com.banque.dao.InterfaceClient;

import configurationsDB.BDD;


public class CrunchifyMySQLDBTutorial {
	static BDD bdd = new BDD();
    static IntCompteDao i = new CompteImpl();
    static InterfaceClient stubclient = new ClientImpl();
	public static void main(String[] argv) {
 
		try {
			
		  log("\n---------- Let's get Data from DB ----------");
			List <Compte> l1= i.getAllComptes();
		//	Client C = new Client("09832576","chiheb","rabeh","consullat","consultant");
			
		  Client a = stubclient.getClientByNumero("09832570");
		  List <Client> l2 = stubclient.getAllClient();
		  System.out.println(a.getCodClt());
			for (Compte c : l1) {
				System.out.println(c.getCodclt());
				System.out.println(c.getSolde());
			
			}
			

		  
		  
		} catch (Exception e) {
 
			e.printStackTrace();
		}
	}
 
	// Simple log utility
	private static void log(String string) {
		System.out.println(string);
 
	}
	
	  
	  
}