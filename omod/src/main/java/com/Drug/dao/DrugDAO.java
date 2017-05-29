package com.Drug.dao;

import java.util.List;

import com.beans.Drug;

public interface DrugDAO {
	
	public Drug getDrugById(int id);
	
	public Drug getDrugdByName(String name);
	
	public Drug getPersonByName(String Pname);
	
	public List<Drug> listDrugs();
	
	public List<Drug> listPeople();
}
