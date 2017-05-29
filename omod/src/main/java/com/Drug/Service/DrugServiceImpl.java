package com.Drug.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Drug.dao.DrugDAO;
import com.beans.Drug;

@Service
public class DrugServiceImpl implements DrugService {
	
	private DrugDAO drugDAO;
	
	@Transactional
	@Override
	public Drug getDrugById(int id) {
		// TODO Auto-generated method stub
		return this.drugDAO.getDrugById(id);
	}
	
	@Transactional
	@Override
	public Drug getDrugdByName(String name) {
		// TODO Auto-generated method stub
		return this.drugDAO.getDrugdByName(name);
	}
	
	@Transactional
	@Override
	public Drug getPersonByName(String Pname) {
		// TODO Auto-generated method stub
		return this.drugDAO.getPersonByName(Pname);
	}
	
	@Transactional
	@Override
	public List<Drug> listDrugs() {
		// TODO Auto-generated method stub
		return this.drugDAO.listDrugs();
	}
	
}
