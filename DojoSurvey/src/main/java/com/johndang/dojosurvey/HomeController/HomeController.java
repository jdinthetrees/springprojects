package com.johndang.dojosurvey.HomeController;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class HomeController {
	
	@RequestMapping("/") 
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/process", method=RequestMethod.POST) 
		public String process(
				HttpSession session,
				@RequestParam String name,
				@RequestParam String location,
				@RequestParam String language,
				@RequestParam String message) {
		//set session with form data, string in quotes refer to form name
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("message", message);
	
//		System.out.println(" in session" + name + location + language + message);
		return "redirect:/results";
	}
	
	
	@RequestMapping("/results") 
	//set session in process, get session here
	public String results(HttpSession session, Model model) {
		
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("location", session.getAttribute("location"));
		model.addAttribute("language", session.getAttribute("language"));
		model.addAttribute("message", session.getAttribute("message"));
//		System.out.println(session.getAttribute("name"));
		return "results.jsp";
	}
}
