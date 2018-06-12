package com.shubham.shoppershubmainfrontend.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shubham.shoppershubmain.dao.UserDAO;
import com.shubham.shoppershubmain.model.User;

@Controller
public class UserController 
{	
	@Autowired
	private UserDAO  userDAO;
	
	@Autowired
	private User user;
	
	@RequestMapping(value="/login")
	public String loginPage()
	{
		return "Login";
	}
	
	/*@RequestMapping(value="perform_login",method=RequestMethod.POST)
	public String performLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model m)
	{
		user = userDAO.validate(username, password);
		
		if(user==null)
		{
			m.addAttribute("msg", "Invalid");
		}
		else
		{
			session.setAttribute("welcomeMessage", "Welcome Mr./Ms " + user.getCustomerName());
		}
		
		return "Home";
	}*/
	
	
	@RequestMapping(value="login_success")
	public String loginSuccess(HttpSession session, Model m)
	{
		String page="";
		
		boolean loggedIn = false;
		
		SecurityContext securitycontext = SecurityContextHolder.getContext();
		Authentication authentic = securitycontext.getAuthentication();
		
		String username = authentic.getName();
		
		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>)authentic.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn = true;
				page="AdminHomePage";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				if(role.getAuthority().equals("ROLE_USER"))
				{
					loggedIn = true;
					page="UserHomePage";
					session.setAttribute("loggedIn", loggedIn);
					session.setAttribute("username", username);
				}
				else
				{
					loggedIn = true;
					page="SupplierHomePage";
					session.setAttribute("loggedIn", loggedIn);
					session.setAttribute("username", username);
				}
			}
		}
		
		return page;
	}
}








