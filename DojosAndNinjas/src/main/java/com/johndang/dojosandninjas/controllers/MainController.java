package com.johndang.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.johndang.dojosandninjas.models.Dojo;
import com.johndang.dojosandninjas.models.Ninja;
import com.johndang.dojosandninjas.services.DojoService;
import com.johndang.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/")
	public String allDojos(Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "index.jsp";
	}
	
	//this takes form info with help of Model model attribute into form 
	//so that user can update with data
	@GetMapping("/createDojo")
	public String showDojoCreate(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	//place where submitted form info goes to
	@PostMapping("/createDojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		dojoService.save(dojo);
		return "redirect:/";
	}
	
	//repeat form getting info with Ninja model, will need to pass info through
	//Model model
	@GetMapping("/createNinja")
	public String showNinjaCreate(@ModelAttribute("ninja") Ninja ninja, Model model) {
		//model attribute with "dojos" so that we can see locations in drop down menu
		model.addAttribute("dojos", dojoService.allDojos()); 
		return "newNinja.jsp";
	}
	
	//receiving function of getmapping of ninjaform
	@PostMapping("createNinja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		//this prints out name of dojo connected to ninja being created
//		System.out.println(ninja.getDojo().getName());
		ninjaService.save(ninja);
		return "redirect:/";
	}
	
}
	
	

