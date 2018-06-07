package com.shubham.shoppershubmain.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.shoppershubmain.dao.OrderDAO;
import com.shubham.shoppershubmain.model.Order;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean receiptGenerate(Order order) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(order);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCartItemStatus(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("update CartItem set status='P' where username=:username");
		query.setParameter("username", username);
		int row_eff=query.executeUpdate();
		return row_eff>0;
	}

}
