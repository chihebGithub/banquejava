package com.banque.dao;

import java.util.List;

import com.banque.beans.Compte;

public interface IntCompteDao {
	public List<Compte> getAllComptes();
	public void addCompte(Compte C);
	public Compte getCompteByNumero(long c) throws ClassNotFoundException;
	public void deleteCompte(long id);
    public boolean getComptebyNatureAndNum(long nat , long num);	

}
