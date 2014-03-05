package com.freddy.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
@RequestMapping("/calculator")
public class CalculatorController {
	
	@RequestMapping(value="/calculatorHome", method = RequestMethod.GET)
	public String calculatorHome(ModelMap model) {
 
		return "/calculator/calculator";
 
	}
	
	@RequestMapping(value="/calculatorResult", method = RequestMethod.POST)
	public String calculatorResult(@RequestParam String number1,@RequestParam String number2,ModelMap model) {
		
		model.addAttribute("result", Integer.parseInt(number1) + Integer.parseInt(number2));
 
		return "/calculator/calculatorResult";
 
	}
 
}