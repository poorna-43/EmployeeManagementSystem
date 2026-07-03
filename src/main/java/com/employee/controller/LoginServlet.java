package com.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.model.User;
import com.employee.service.UserService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserService service=new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User(username,password);
		boolean status=service.validateUser(user);
		if(status) {
			HttpSession session=request.getSession();
			session.setAttribute("loggedInUser", user);
			session.setAttribute("username", user.getUsername());
			response.sendRedirect("dashboard.jsp");
		}else {
			request.setAttribute("error","invalid usernaame or password");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
