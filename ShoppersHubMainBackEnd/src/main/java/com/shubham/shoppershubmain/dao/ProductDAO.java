package com.shubham.shoppershubmain.dao;

import java.util.List;

import com.shubham.shoppershubmain.model.Product;



public interface ProductDAO 
{
	public boolean saveProduct(Product product);
	public boolean deleteProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> listProducts();
	
}
