package com.johndang.gettingfamiliarrouting;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("{dojo}")

public class DojoController {
//	@RequestMapping("")
//	public  String showDojo() {
//		return "The dojo is awesome!";
//}

	
	@RequestMapping("/{location}")
	public String showLocation(@PathVariable("location") String location) {
		//could have done it this way to be more organized
//		String dojod+ "dojo";
//		String dojob = "burbank-dojo";
//		String dojos = "san-jose";
		
		if (location.equals("dojo")) {
			return "The dojo is awesome";
		} else if
			(location.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California.";
			} else if (location.equals("san-jose")) {
			return "SJ Dojo is the headquarters.";
			}
		return location;

}
	


	

}


	
