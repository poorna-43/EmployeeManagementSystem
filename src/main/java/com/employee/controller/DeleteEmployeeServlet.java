package com.employee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.service.EmployeeService;


@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private EmployeeService service=new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		service.deleteEmployee(id);
		response.sendRedirect("employees?msg=deleted");
	}

}
