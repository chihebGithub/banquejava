package com.banque.beans;

public class Nature {
	private int codnat;
	private String libnat;
	private double taxe;
	public int getCodnat() {
		return codnat;
	}
	public void setCodnat(int codnat) {
		this.codnat = codnat;
	}
	public String getLibnat() {
		return libnat;
	}
	public void setLibnat(String libnat) {
		this.libnat = libnat;
	}
	public double getTaxe() {
		return taxe;
	}
	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}
	public Nature() {
		super();
	}
	public Nature(int codnat, String libnat, double taxe) {
		super();
		this.codnat = codnat;
		this.libnat = libnat;
		this.taxe = taxe;
	}
	
	

}
