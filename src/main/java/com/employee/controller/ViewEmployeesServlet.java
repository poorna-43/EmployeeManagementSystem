package com.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;


@WebServlet("/employees")
public class ViewEmployeesServlet extends HttpServlet {
	private EmployeeService service=new EmployeeService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employees=service.getAllEmployees();
		request.setAttribute("employees", employees);
		String message=request.getParameter("msg");
		request.setAttribute("message",message);
		RequestDispatcher rd=request.getRequestDispatcher("viewEmployees.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
