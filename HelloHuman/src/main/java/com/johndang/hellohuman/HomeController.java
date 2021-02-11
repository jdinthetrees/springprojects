package com.johndang.hellohuman;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class HomeController {
	
	@RequestMapping("/") 
		public String index() {
			return "Hello Human. Welcome to SpringBoot.";
		}

	@RequestMapping("/name")
	//add another param is easy if you add them in..../name?name=john&lastname=dang
		public String name(@RequestParam(value="name") String name, @RequestParam(value="lastname") String lastname) {
		return "Hello " + name + " " + lastname + ". Welcome to SpringBoot";
	}
		

}
