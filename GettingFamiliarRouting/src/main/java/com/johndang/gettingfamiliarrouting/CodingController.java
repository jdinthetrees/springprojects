package com.johndang.gettingfamiliarrouting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	
	@RequestMapping("")
	public String Hello() {
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping("/python")
	public String Python() {
		return "Python/Django was awesome!";
	}
	
	@RequestMapping("/java")
	public String Java() {
		return "Java/Spring is better!";
	}

}



