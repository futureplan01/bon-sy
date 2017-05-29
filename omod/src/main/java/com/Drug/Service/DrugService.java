package com.Drug.Service;

import java.util.List;

import com.beans.Drug;

public interface DrugService {
	
	public Drug getDrugById(int id);
	
	public Drug getDrugdByName(String name);
	
	public Drug getPersonByName(String Pname);
	
	public List<Drug> listDrugs();
	
}
