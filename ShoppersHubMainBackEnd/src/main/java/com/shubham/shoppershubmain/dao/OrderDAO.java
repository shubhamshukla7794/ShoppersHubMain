package com.shubham.shoppershubmain.dao;

import com.shubham.shoppershubmain.model.Order;

public interface OrderDAO
{
	public boolean receiptGenerate(Order order);
	public boolean updateCartItemStatus(String username);
}
