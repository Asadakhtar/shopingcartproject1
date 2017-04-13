package com.asad.Shoppingcart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asad.Shoppingcart.DAO.CategoryDAO;
import com.asad.Shoppingcart.modal.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired(required=true)
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
		@RequestMapping("/addcategory")
		public ModelAndView addCategory1()
		{
			ModelAndView mv=new ModelAndView("AddCategory");
			mv.addObject("category",new Category());
			mv.addObject("categoryList",categoryDAO.list());
			return mv;		
		}
		
		@RequestMapping("/categoryadd")
		public  String categoryAdd(@ModelAttribute("category") Category c)
		{
			
			if(c.getCategoryId()==null||c.getCategoryId().isEmpty()){
			categoryDAO.addCategory(c);
			}
			else
			{
				System.out.println("category add");
				categoryDAO.update(c);
			}
		return "redirect:/addcategory";
		}
		@RequestMapping("/deleteCategory/{catid}")
		public  String categoryDelete(@PathVariable("catid")String catid,Model model)
		{
			categoryDAO.delete(catid);
			return "redirect:/addcategory";		
		}

		@RequestMapping("/editCategory/{catid}")
		public  String categoryEdit(@PathVariable("catid")String catid,Model model)
		{
			model.addAttribute("category",categoryDAO.getCategoryByID(catid));
			model.addAttribute("categoryList",categoryDAO.list());
			return "/AddCategory";		
		}
		
		
		
		
		
		
		
}
