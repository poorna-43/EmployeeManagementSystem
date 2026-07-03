package com.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;


@WebServlet("/searchEmployee")
public class SearchEmployeeServlet extends HttpServlet {
	private EmployeeService service=new EmployeeService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword=request.getParameter("keyword");
		
		List<Employee> employees=service.searchEmployee(keyword);
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("viewEmployees.jsp").forward(request, response);
	}
}
