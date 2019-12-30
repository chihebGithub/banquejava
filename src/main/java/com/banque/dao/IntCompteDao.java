package com.banque.dao;

import java.sql.SQLException;
import java.util.List;

import com.banque.beans.Compte;

public interface IntCompteDao {
	public List<Compte> getAllComptes();
	public List<Compte> getAllComptesParCLient(long cin);
	public void addCompte(Compte C);
	public Compte getCompteByNumero(long c) throws ClassNotFoundException;
	public void deleteCompte(long id);
    public boolean getComptebyNatureAndNum(long nat , long num);	
    public long  getNumCompte();
    public int  virement(Compte C1 , Compte C2 , double montant) throws SQLException;
}
