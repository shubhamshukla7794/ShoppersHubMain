package com.shubham.shoppershub.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.shoppershubmain.dao.CategoryDAO;
import com.shubham.shoppershubmain.model.Category;

public class CategoryDAOTestCase 
{

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	@Test
	public void getCategoryDetails()
	{
		Category category = categoryDAO.getCategory(2);
		String name = category.getCategoryName();
		assertEquals("TV and Electronics", name);
	}

}
