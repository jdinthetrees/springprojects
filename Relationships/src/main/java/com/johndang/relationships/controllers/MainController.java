package com.johndang.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.johndang.relationships.models.License;
import com.johndang.relationships.models.Person;
import com.johndang.relationships.services.LicenseService;
import com.johndang.relationships.services.PersonService;

@Controller
public class MainController { 
	
	@Autowired
	private PersonService personService;
	@Autowired
	private LicenseService licenseService;
	
	
	//display all people
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("persons", personService.findAllPersons());
		return "index.jsp";
	}
	
	//show new person page
	@GetMapping("/persons/new")
	public String newPersonForm(@ModelAttribute("person") Person newPerson) {
		return "newPerson.jsp";
		}
	
	//show one person
	@GetMapping("/persons/{id}")
	public String showNewPerson(Model model, @PathVariable("id") Long id) {
		Person person= personService.findPerson(id);
		model.addAttribute("person", person);
		return "showPerson.jsp";
	}
	
		//this is to create person
	@PostMapping("/persons/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("We had an error");
			return "index.jsp";
			}
		personService.createPerson(person);
		return "redirect:/";
		}
	
	//show license page
	@GetMapping("/licenses/new")
	public String newLicenseForm(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.findAllPersons();
		model.addAttribute("persons", persons);
		return "newLicense.jsp";
	}
	
	//create a new license
	@PostMapping("/licenses/new")
	public String newLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Error creating a license");
			return "redirect:/licenses/new";
		} else {
			license.setNumber(String.format("%05d", license.getPerson().getId()));
			licenseService.createLicense(license);
			return "redirect:/persons/" + license.getPerson().getId();
		}
	}

}
