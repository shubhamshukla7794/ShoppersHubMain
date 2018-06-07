package com.shubham.shoppershubmain.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.shoppershubmain.dao.CategoryDAO;
import com.shubham.shoppershubmain.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addCategory(Category category) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public Category getCategory(int categoryId) 
	{
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryId);
		session.close();
		return category;
	}

	public boolean deleteCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public List<Category> getCategories() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategories=(List<Category>)query.list();
		return listCategories;
	}

}
