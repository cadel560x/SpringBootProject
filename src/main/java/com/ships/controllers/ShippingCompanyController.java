package com.ships.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.GET)
	public String addShippingCompanyGet(Model model) {
		ShippingCompany shippingCompany = new ShippingCompany();
		model.addAttribute("shippingCompany", shippingCompany);
		
		return "addShippingCompany";
		
	} // end addShippingCompanyGet
	
	
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.POST)
	public String addShippingCompanyPost(@Valid @ModelAttribute("shippingCompany") ShippingCompany shippingCompany, BindingResult result) {
		if (result.hasErrors()) {
			return "addShippingCompany";
		}
		else {
			shippingCompanyService.save(shippingCompany);
			return "redirect:showShippingCompanies";
		}
		
	} // end addShippingCompanyPost
	
} // end class shippingCompanyController
