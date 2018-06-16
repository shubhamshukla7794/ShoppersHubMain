package com.shubham.shoppershubmainfrontend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shubham.shoppershubmain.dao.ProductDAO;
/*import com.shubham.shoppershubmain.dao.CategoryDAO;
import com.shubham.shoppershubmain.model.Category;*/
import com.shubham.shoppershubmain.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/product/save",method= RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product")Product product,Model m,@RequestParam(value="pimage")MultipartFile pImage)
	{
		productDAO.saveProduct(product);
		
		Product prod = new Product();	//blank object which will be sent to Product.jsp
		m.addAttribute(prod);
		
		//------------------------------- I M A G E   I N S E R T I O N -------------------------------
		
		String path = "G:\\Programs\\Softwares\\project\\ShoppersHub\\ShoppersHubMain\\ShoppersHubMainFrontEnd\\src\\main\\webapp\\resources\\images\\";
		path = path + String.valueOf(product.getProductId()) + ".jpg";
		File filepath = new File(path);
		
		if(!pImage.isEmpty())
		{
			try
			{
				byte[] buffer=pImage.getBytes();
				FileOutputStream fos=new FileOutputStream(filepath);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("errorInfo",e.getMessage());
			}
		}
		else
		{
			m.addAttribute("errorInfo", "There is System Problem");
		}
		
		return "redirect:/manage_products";
	}
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String displayProductPage(Model m)
	{
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		
		return "productPage";
	}
		
}
