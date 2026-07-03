package com.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;




@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private EmployeeService service = new EmployeeService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("empName");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee employee = new Employee(name, department, salary);

        boolean status = service.registerEmployee(employee);

        if (status) {

            response.sendRedirect("employees?msg=added");

        } else {

            response.getWriter().println("<h2>Employee Registration Failed!</h2>");

        }

    }

}