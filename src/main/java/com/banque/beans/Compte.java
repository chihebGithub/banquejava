package com.banque.beans;

public class Compte {
	private long numCpt;
	private int codNatCpt;
	private double solde ;
	private String codclt ;
	
	public long getNumCpt() {
		return numCpt;
	}
	public void setNumCpt(long numCpt) {
		this.numCpt = numCpt;
	}
	public int getCodNatCpt() {
		return codNatCpt;
	}
	public void setCodNatCpt(int codNatCpt) {
		this.codNatCpt = codNatCpt;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(long numCpt, int codNatCpt, double solde) {
		super();
		this.numCpt = numCpt;
		this.codNatCpt = codNatCpt;
		this.solde = solde;
	}
	public String getCodclt() {
		return codclt;
	}
	public void setCodclt(String codclt) {
		this.codclt = codclt;
	}

	
}
