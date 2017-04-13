package com.asad.Shoppingcart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asad.Shoppingcart.DAO.UserDAO;
import com.asad.Shoppingcart.modal.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;
		@Autowired(required=true)
		public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

		@RequestMapping("/adduser")
		public ModelAndView addUser1()
		{
			ModelAndView mv=new ModelAndView("AddUser");
			mv.addObject("user",new User());
			return mv;
			
		}
		
		@RequestMapping("/useradd")
		public  ModelAndView userAdd(@ModelAttribute("user") User u)
		{
			ModelAndView mv = new ModelAndView("Home");
			userDAO.addUser(u);
			return mv;
			
		}
		
}
