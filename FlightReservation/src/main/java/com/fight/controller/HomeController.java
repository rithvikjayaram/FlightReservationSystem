package com.fight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	 @RequestMapping("/")  
	    public String home(){  
	    	return "index"; 
	    }  
	 
		/*
		 * @RequestMapping(value = { "/showRegistration" }, method = RequestMethod.GET)
		 * public ModelAndView ShowRegistration() { ModelAndView model = new
		 * ModelAndView(); model.setViewName("login/registerUser"); return model; }
		 */
}
