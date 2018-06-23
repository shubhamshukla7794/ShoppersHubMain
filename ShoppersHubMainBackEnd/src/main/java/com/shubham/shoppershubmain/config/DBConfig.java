package com.shubham.shoppershubmain.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.shubham.shoppershubmain.model.*;
import com.shubham.shoppershubmain.dao.*;
import com.shubham.shoppershubmain.dao.impl.*;

@Configuration
@ComponentScan("com.shubham")
@EnableTransactionManagement
public class DBConfig 
{
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ShoppersHubMain");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		System.out.println("---Data Source Created---");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		
		Properties hibernateProp=new Properties();
		
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(Product.class);
		factoryBuilder.addAnnotatedClass(User.class);
		factoryBuilder.addAnnotatedClass(Cart.class);
		factoryBuilder.addAnnotatedClass(Orders.class);
		
		factoryBuilder.addProperties(hibernateProp);
		
		System.out.println("---- Creating SessionFactory Bean ----");
		return factoryBuilder.buildSessionFactory();
	}
	
	@Bean(name="userDAO")
	public UserDAO getUserDAO()
	{
		System.out.println("---- User DAO Implementation ----");
		return new UserDAOImpl();
	}
	
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("---- Category DAO Implementation ----");
		return new CategoryDAOImpl();
	}
	
	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("---- Product DAO Implementation ----");
		return new ProductDAOImpl();
	}
	
	@Bean(name="cartDAO")
	public CartDAO getCartDAO()
	{
		System.out.println("---- Cart DAO Implementation ----");
		return new CartDAOImpl();
	}
	
	@Bean(name="orderDAO")
	public OrdersDAO getOrderDAO()
	{
		System.out.println("---- Order DAO Implementation ----");
		return new OrdersDAOImpl();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---- Transaction Manager ----");
		return new HibernateTransactionManager(sessionFactory);
	}
	
	
}
