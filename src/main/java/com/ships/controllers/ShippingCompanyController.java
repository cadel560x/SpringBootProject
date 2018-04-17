package com.ships.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ships.model.ShippingCompany;
import com.ships.services.ShippingCompanyService;




@SessionAttributes({"shippingCompany","shippingCompanies"})
@Controller
public class ShippingCompanyController {
//	Fields
	@Autowired
	private ShippingCompanyService shippingCompanyService;
	
	
	
	
	@RequestMapping(value = "/showShippingCompanies", method=RequestMethod.GET)
	public String showShippingCompanies(Model model) {
		Iterable<ShippingCompany> shippingCompanies = shippingCompanyService.findAll();
		model.addAttribute("shippingCompanies", shippingCompanies);
		
		return "showShippingCompanies";
		
	} // end showShippingCompanies
	
} // end class shippingCompanyController
