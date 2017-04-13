package com.asad.Shoppingcart.Controller;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.asad.Shoppingcart.DAO.ProductDAO;
import com.asad.Shoppingcart.modal.Product;


@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired(required=true)
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@RequestMapping("/addproduct")
	public ModelAndView addProduct1()
	{
		ModelAndView mv=new ModelAndView("AddProduct");
		mv.addObject("product",new Product());
		return mv;
		
	}

	@RequestMapping("/productadd")
	public  ModelAndView productAdd(@Valid @ModelAttribute("product") Product p,BindingResult result, Model model,HttpServletRequest request)
	{
		if(result.hasErrors())
		{
			ModelAndView mv = new ModelAndView("Home");
			productDAO.addProduct(p);
			return mv;
		}
		else{
			ModelAndView mv = new ModelAndView("Home");

		this.productDAO.addProduct(p);
		MultipartFile file=p.getImg();
		System.out.println("hello");
		String filelocation=request.getSession().getServletContext().getRealPath("/resources/images/");
		
		System.out.println(filelocation);
		String filename=filelocation+"\\"+p.getPid()+".jpg";
		System.out.println(filename);
		
		try{
			byte b[]=file.getBytes();
			FileOutputStream fos=new FileOutputStream(filename);
			fos.write(b);
			fos.close();
	    	}
		catch(IOException ex){}
		catch(Exception e){}
		return mv;

			}
	}

}
