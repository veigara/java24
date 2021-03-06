package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.entity.User;

public class UserController extends ActionSupport implements ModelDriven<User>,SessionAware{

	User user = new User();
	
	Map<String, Object> session = new HashMap<>();
	
	
	@Override
	public String execute() throws Exception {
		
		if("admin".equals(user.getUsername()) && "123".equals(user.getPassword())){
			
			//把用户的信息保存到session中
			session.put("admin", user.getUsername());
			
			return SUCCESS;
		}
		return LOGIN;
	}
	
	public String query() throws Exception{
		
		return SUCCESS;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}
