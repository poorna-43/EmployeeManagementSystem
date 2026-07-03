package com.employee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;


@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
	

	private EmployeeService service=new EmployeeService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("empName");
		String department=request.getParameter("department");
		Double salary=Double.parseDouble(request.getParameter("salary"));
		Employee employee=new Employee(id,name,department,salary);
		service.updateEmployee(employee);
		response.sendRedirect("employees?msg=updated");
	}

}
