package com.Drug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.beans.Drug;
import com.Drug.Service.DrugService;
import com.beans.Drug;

//import com.beans.Drug;
@Controller
public class DrugController {
	
	private DrugService drugService;
	
	@Autowired(required = true)
	@Qualifier(value = "drugService")
	public void setDrugService(DrugService ds) {
		this.drugService = ds;
	}
	
	@RequestMapping(value = "/drugs", method = RequestMethod.POST)
	public String listPErsons(Model model) {
		model.addAttribute("drug", new Drug());
		model.addAttribute("ListDrugs", this.drugService.listDrugs());
		return "drug";
	}
	
}
