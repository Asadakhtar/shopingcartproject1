package com.asad.Shoppingcart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asad.Shoppingcart.DAO.SupplierDAO;
import com.asad.Shoppingcart.modal.Supplier;

@Controller
public class SupplierController {
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired(required=true)
	public void setSupplierDAO(SupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}

	
		@RequestMapping("/addSupplier")
		public ModelAndView addSupplier1()
		{
			ModelAndView mv=new ModelAndView("AddSupplier");
			mv.addObject("supplier",new Supplier());
			return mv;
			
		}
		
		@RequestMapping("/supplieradd")
		public  ModelAndView categoryAdd(@ModelAttribute("supplier") Supplier s)
		{
			ModelAndView mv = new ModelAndView("Home");
			supplierDAO.addSupplier(s);
			return mv;
			
		}
}
