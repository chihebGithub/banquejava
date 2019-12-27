package com.banque.dao;

import java.util.List;

import com.banque.beans.Compte;
import com.banque.beans.Operation;

public interface InterfaceOperation {
	
	public List<Operation> getAllOperations(Compte C);
	public void addOperation(Operation O);

}
