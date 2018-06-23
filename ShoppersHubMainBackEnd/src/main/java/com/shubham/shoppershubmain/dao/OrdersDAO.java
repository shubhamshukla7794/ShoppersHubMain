package com.shubham.shoppershubmain.dao;

import com.shubham.shoppershubmain.model.Orders;

public interface OrdersDAO
{
	public boolean receiptGenerate(Orders order);
	public boolean updateCartItemStatus(String username);
}
