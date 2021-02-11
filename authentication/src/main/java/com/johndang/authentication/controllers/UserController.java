package com.johndang.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.johndang.authentication.models.User;
import com.johndang.authentication.services.UserService;
import com.johndang.authentication.validator.UserValidator;


@Controller
public class UserController {
	
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private UserValidator userValidator;
	    
	   
	 	@GetMapping("/registration")
	    public String registerForm(@ModelAttribute User user) {
	        return "registrationPage.jsp";
	    }
	    
	    @GetMapping("/login")
	    public String login() {
	        return "loginPage.jsp";
	    }
	    
	    @PostMapping("/registration")
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	        // if result has errors, return the registration page (don't worry about validations just now)
	        // else, save the user in the database, save the user id in session, and redirect them to the /home route
	    	userValidator.validate(user, result);
	    	if(result.hasErrors()) {
				return "registrationPage.jsp";
			}
			userService.registerUser(user);
			session.setAttribute("userId", user.getId());
			return "redirect:/home";
	    }
	    
	    @PostMapping("/login")
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	        // if the user is authenticated, save their user id in session
			boolean isAuthenticated  = userService.authenticateUser(email, password);
	    	if(isAuthenticated) {
	    		User user = userService.findByEmail(email);
	    		session.setAttribute("userId", user.getId());
	    		return "redirect:/home";  		
	    	} else {
	        // else, add error messages and return the login page
	    		model.addAttribute("error",  "Invalid Credentials.  Please try again");
	    		return "loginPage.jsp";
//	    		flashMessage.addFlashAttribute("error", "failed to login"); use with in params RedirectAttributes flashMessage
//	    		return "redirect:/login";
	        	
	    	}
	    }
	    
//	    
//	    <!DOCTYPE html>
//	    <html>
//	    <head>
//	        <meta charset="UTF-8">
//	        <title>Login Page</title>
//	    </head>
//	    <body>
//	        <h1>Login</h1>
//	        <p><c:out value="${error}" /></p>
//	        <form method="post" action="/login">
//	            <p>
//	                <label for="email">Email</label>
//	                <input type="text" id="email" name="email"/>
//	            </p>
//	            <p>
//	                <label for="password">Password</label>
//	                <input type="password" id="password" name="password"/>
//	            </p>
//	            <input type="submit" value="Login!"/>
//	        </form>    
//	    </body>
//	    </html>
//	    
//	    
	    
	    
	    @GetMapping("/home")
	    public String home(HttpSession session, Model model) {
	    	// get user from session, save in the model and return the home page
			Long userId = (Long) session.getAttribute("userId") ;
			if (userId == null) {
				return "redirect:/login";
			}
	    	User user = userService.findUserById(userId);
	    	model.addAttribute("user", user);
	    	return "homePage.jsp";// get user from session, save them in the model and return the home page
	    
	    
	    }
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        // invalidate session
	    	session.invalidate();
	        // redirect to login page
	    	return "redirect:/login";
	    }

}
