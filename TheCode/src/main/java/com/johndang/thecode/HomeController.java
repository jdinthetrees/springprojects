package com.johndang.thecode;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index () {
	return "index.jsp";
}
	@RequestMapping(path="/process", method=RequestMethod.POST)
	//or @RequestParam String userName if we need userName or for that matter the passWord
	public String submit(@RequestParam String code, HttpSession session, RedirectAttributes redirectAttributes) {
		
//		System.out.println(code.toString());
		if(code.equals("bushido")) {
			return "redirect:/code";
		} else {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
		
	}
	@RequestMapping("/code")
	public String code() {
		
//		Object code = session.getAttribute("code");
//		if(code == null) {
//			model.addAttribute("code", "");
//		} else {
//			model.addAttribute("code", code.toString());
//		}
		return "code.jsp";
	}

}




