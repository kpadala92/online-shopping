package com.kp.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kp.onlineshoppingbackend.dao.CategoryDAO;
import com.kp.onlineshoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/","/home","/index"},method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","Home");
		mav.addObject("categories", categoryDAO.list());
		mav.addObject("userClickHome",true);
		return mav;
	}
	@RequestMapping(value= "/about",method=RequestMethod.GET)
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","About Us");
		mav.addObject("userClickAbout",true);
		return mav;
	}
	@RequestMapping(value= "/contact",method=RequestMethod.GET)
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","Contact Us");
		mav.addObject("userClickContact",true);
		return mav;
	}
	/*
	 * methods to load all the products based on category
	 * */
	
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllPrducts() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","All Products");
		mav.addObject("categories", categoryDAO.list());
		mav.addObject("userClickAllProducts",true);
		return mav;
	}
	
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showCategoryPrducts(@PathVariable("id")int id ) {
		ModelAndView mav = new ModelAndView("page");
		//CategoryDAO to fetch single category
		Category category=null;
		category= categoryDAO.get(id);
		mav.addObject("title",category.getName());
		//passing the list of categories
		mav.addObject("categories", categoryDAO.list());
		//passing the single category object
		mav.addObject("category",category);
		mav.addObject("userClickCategoryProducts",true);
		return mav;
	}
	
	
	
	
	
	
	
	
	/*@RequestMapping(value= {"/test"},method=RequestMethod.GET)
	public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting) {
		if(greeting==null) greeting="welcome";
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("greeting",greeting);
		return mav;
	}*/
	
}
