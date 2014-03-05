package com.freddy.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
@RequestMapping("/")
public class BaseController {
 
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
 
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
 
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
 
	}
 
	@RequestMapping(value="/welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - " + name);
		return "index";
 
	}
	
	@RequestMapping(value="/calculatorHome", method = RequestMethod.GET)
	public String calculatorHome(ModelMap model) {
 
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "calculator";
 
	}
	
	@RequestMapping(value="/calculatorResult", method = RequestMethod.POST)
	public String calculatorResult(@RequestParam String number1,@RequestParam String number2,ModelMap model) {
		
		model.addAttribute("result", Integer.parseInt(number1) + Integer.parseInt(number2));
 
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "calculatorResult";
 
	}
 
}
