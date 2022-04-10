package com.shubham.shoppershubmain.dao;

import java.util.List;

import com.shubham.shoppershubmain.model.Category;



public interface CategoryDAO 
{
	public boolean addCategory(Category category);
	public Category getCategory(int categoryId);
	public boolean deleteCategory(Category category);
	public List<Category> getCategories();
}
