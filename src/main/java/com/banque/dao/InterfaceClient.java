package com.banque.dao;

import java.util.List;

import com.banque.beans.Client;


public interface InterfaceClient {
	public List<Client> getAllClient();
	public void addClient(Client C);
	public boolean login(Client C);
	public Client getClientByNumero(String c) throws ClassNotFoundException;
	public void deleteClient(long id);
	public boolean emailExists(String email);

}
