package com.shubham.shoppershub.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.shoppershubmain.dao.UserDAO;
import com.shubham.shoppershubmain.model.User;

import junit.framework.Assert;

public class UserDAOTestCase 
{

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void saveUserTestCase()
	{
		User user = new User();
		user.setUsername("asd");
		user.setPassword("ae@123");
		user.setRole("user");
		user.setCustomerName("a Banner");
		user.setMobileNo("9a654321");
		user.setEmailId("ae@gmail.com");
		user.setAddress("a York");
		
		boolean result = userDAO.save(user);
		Assert.assertEquals("Save user", true, result);
	}
	
	@Ignore
	@Test
	public void deleteUserTestCase()
	{
		boolean actual = userDAO.delete("asd");
		Assert.assertEquals("Delete User", true, actual);
	}
	@Ignore
	@Test
	public void getParticularUsers()
	{
		int size = userDAO.list("user").size();
		Assert.assertEquals(2, size);
	}

}











