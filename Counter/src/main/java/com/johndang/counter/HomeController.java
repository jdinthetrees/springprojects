package com.johndang.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {

			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
			return "index.jsp";
			
	}
	
	@RequestMapping("/counter")
	//Model model is like context
	public String counter(HttpSession session, Model model) {
//to use session you have to set session
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		
		model.addAttribute("totalCount", session.getAttribute("count"));
		return "counter.jsp";
	}
	
	@RequestMapping("/clear")
	// clear session
	public String clear(HttpSession session) {
		session.invalidate();
		return "redirect:/counter";
	}

}
