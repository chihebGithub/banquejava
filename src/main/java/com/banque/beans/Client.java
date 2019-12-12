package com.banque.beans;

public class Client {
	//id client
	private String codClt ;
	private String name;
	private String firstName;
	private String adress;
	private String Email;
	private String Sex;
	private String Country;

	public String getCodClt() {
		return codClt;
	}
	public void setCodClt(String codClt) {
		this.codClt = codClt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	public Client() {
		super();
	}
	public Client(String codClt, String name, String firstName, String adress) {
		super();
		this.codClt = codClt;
		this.name = name;
		this.firstName = firstName;
		this.adress = adress;
		
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}

	
	
}
