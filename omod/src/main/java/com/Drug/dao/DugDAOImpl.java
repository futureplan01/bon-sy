package com.Drug.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.beans.Drug;

@Repository
public class DugDAOImpl implements DrugDAO {
	
	// TODO Auto-generated constructor stub
	
	private static final Logger logger = LoggerFactory.getLogger(DrugDAO.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
		
	}
	
	@Override
	public Drug getDrugById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Drug d = (Drug) session.load(Drug.class, new Integer(id));
		logger.info("Drug loaded successfully, Drug details =" + d);
		return d;
		
	}
	
	@Override
	public Drug getPersonByName(String Pname) {
		Session session = this.sessionFactory.getCurrentSession();
		Drug d = (Drug) session.load(Drug.class, new String(Pname));
		logger.info("Person Retrieved successfully: " + d);
		return d;
		
	}
	
	@Override
	public Drug getDrugdByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Drug d = (Drug) session.load(Drug.class, new String(name));
		logger.info("Person Retrieved successfully: " + d);
		return d;
		
	}
	
	String LName, FName;
	
	String Qry = "Select drug.name From drug as D inner join concept as C on D.concept_id = C.concept_id inner join "
	        + "person as P on C.Concept_id = P.person_id inner join person_name as PN on P.person_id = PN. person_name_id "
	        + "Where family_name = " + LName + " AND given_name = " + FName;
	
	@Override
	public List<Drug> listDrugs() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Drug> druglist = session.createQuery(Qry).list();
		for (Drug d : druglist) {
			logger.info("Drug List: " + d);
			
		}
		
		return druglist;
	}
	
	@Override
	public List<Drug> listPeople() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
