package com.shubham.shoppershub.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.shoppershubmain.dao.OrdersDAO;
import com.shubham.shoppershubmain.model.Orders;

import junit.framework.Assert;

public class OrdersDAOTestCase 
{
	private static AnnotationConfigApplicationContext context;
	private static OrdersDAO orderDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		orderDAO = (OrdersDAO) context.getBean("orderDAO");
	}
	
	@Test
	public void receipt()
	{
		Orders order = new Orders();
		order.setUsername("Peter");
		order.setPurchaseValue(200);
		order.setPaymentMode("Cash");
		order.setOrderDate(new java.util.Date());
		
		boolean result = orderDAO.receiptGenerate(order);
		Assert.assertEquals("New Order", true, result);
		
	}
}
