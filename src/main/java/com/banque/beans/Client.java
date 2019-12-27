package com.banque.beans;

public class Client {
	//id client
	private String codClt ;
	private String name;
	private String firstName;
	private String password;
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
	
	
	
	public Client() {
		super();
	}
	public Client(String codClt, String name, String firstName, String password) {
		super();
		this.codClt = codClt;
		this.name = name;
		this.firstName = firstName;
		this.password = password;
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
