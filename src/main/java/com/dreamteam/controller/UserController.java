package com.dreamteam.controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamteam.dao.UserDao;


public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao dao;

	public UserController() {
		super();
		dao = new UserDao();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) {
		//String forward="";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("insert")){
			dao.addUser();
		}
	}
}
