package com.banque.beans;

import java.util.Date;

public class Operation {
	
	private  Date DateMouvement ;
	private long CompteX;
	private long CompteY;
	private double Montant ;
	private double SoldeAvant;
	private double SoldeApres;
	private String TypeOperation ;
	
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date dateMouvement, long compteX, double montant, double soldeAvant, double soldeApres,
			String typeOperation) {
		super();
		DateMouvement = dateMouvement;
		CompteX = compteX;
		Montant = montant;
		SoldeAvant = soldeAvant;
		SoldeApres = soldeApres;
		TypeOperation = typeOperation;
	}
	public Date getDateMouvement() {
		return DateMouvement;
	}
	public void setDateMouvement(Date dateMouvement) {
		DateMouvement = dateMouvement;
	}
	public long getCompteX() {
		return CompteX;
	}
	public void setCompteX(long compteX) {
		CompteX = compteX;
	}
	public double getMontant() {
		return Montant;
	}
	public void setMontant(double montant) {
		Montant = montant;
	}
	public double getSoldeAvant() {
		return SoldeAvant;
	}
	public void setSoldeAvant(double soldeAvant) {
		SoldeAvant = soldeAvant;
	}
	public double getSoldeApres() {
		return SoldeApres;
	}
	public void setSoldeApres(double soldeApres) {
		SoldeApres = soldeApres;
	}
	public String getTypeOperation() {
		return TypeOperation;
	}
	public void setTypeOperation(String typeOperation) {
		TypeOperation = typeOperation;
	}
	@Override
	public String toString() {
		return "Operation [DateMouvement=" + DateMouvement + ", CompteX=" + CompteX + ", Montant=" + Montant
				+ ", SoldeAvant=" + SoldeAvant + ", SoldeApres=" + SoldeApres + ", TypeOperation=" + TypeOperation
				+ "]";
	}
	@Override
	public int hashCode() {
		return DateMouvement.hashCode();
	}
	public long getCompteY() {
		return CompteY;
	}
	public void setCompteY(long compteY) {
		CompteY = compteY;
	}
	
	
	
	

}
