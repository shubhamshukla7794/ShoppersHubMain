package com.shubham.shoppershubmainfrontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shubham.shoppershubmain.dao.CategoryDAO;
import com.shubham.shoppershubmain.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	private HttpSession httpsession;

	
	@RequestMapping(value = "/category/save", method = RequestMethod.POST)
	public String saveCategory(@RequestParam String categoryName,@RequestParam String cateogryDesc,Model m)
	{
		Category category = new Category();
		
		category.setCategoryName(categoryName);
		category.setCateogryDesc(cateogryDesc);
		
			if(categoryDAO.addCategory(category))
			{
				m.addAttribute("msg", "Category created Successfully");
			}
			else
			{
				m.addAttribute("msg", "Could not create category");
			}
		
		return "redirect:/manage_categories";
	}
	
	@RequestMapping(value = "/category/edit/", method = RequestMethod.GET)
	public String editCategory(@RequestParam int categoryId, Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		httpsession.setAttribute("selectedCategory", category);
		//m.addAttribute("selectedCategory", category);		
		return "redirect:/manage_categories";
	}
	
	@RequestMapping(value = "/category/delete/", method = RequestMethod.GET)
	public String deleteCategory(@RequestParam int categoryId, Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		if(categoryDAO.deleteCategory(category))
		{
			m.addAttribute("msg", "Category deleted Successfully");
		}
		else
		{
			m.addAttribute("msg", "Could not delete category");
		}
	
	return "redirect:/manage_categories";
	}

}








