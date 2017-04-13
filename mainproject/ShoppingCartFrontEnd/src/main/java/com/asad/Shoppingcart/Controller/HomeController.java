package com.asad.Shoppingcart.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	private HttpSession session;

	 @RequestMapping("/")
	public ModelAndView showHomePage() {
		System.out.println("home page");
		ModelAndView mv = new ModelAndView("/Home");
		return mv;
	} 
	@RequestMapping("/home")
	public ModelAndView sk() {
		System.out.println("home page2");
		ModelAndView mv =new ModelAndView("/Home");
		return mv;
	}

	

	@RequestMapping("/Login")
	public ModelAndView showLoginPage() {
		ModelAndView m = new ModelAndView("/login1");
		m.addObject("LoginClicked", "true");
		return m;
		
	}



}
