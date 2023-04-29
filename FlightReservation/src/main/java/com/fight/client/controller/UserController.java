package com.fight.client.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fight.client.model.User;
import com.fight.client.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
private UserService userService;

private Command loginCommand = new LoginCommand();
private Command registerCommand = new RegisterCommand();

@GetMapping("/register")
public ModelAndView showRegistration() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("login/registerUser");
	return modelAndView;
}

@PostMapping("/register")
public ModelAndView registerUser(@ModelAttribute("user") User user) {
	return registerCommand.execute(user);
}

@PostMapping("/login")
public ModelAndView login(@RequestParam("email") String email,
						  @RequestParam("password") String password,
						  ModelMap modelMap) {
	return loginCommand.execute(new LoginRequest(email, password, modelMap));
}
}
