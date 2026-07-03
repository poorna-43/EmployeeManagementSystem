package com.employee.service;

import java.util.List;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAO();

    public boolean registerEmployee(Employee employee) {

        if(employee.getSalary() < 0) {
            return false;
        }

        return dao.registerEmployee(employee);
    }
    public List<Employee> getAllEmployees(){
    	return dao.getAllEmployees();
    }
    public Employee getEmployeeById(int id) {
    	return dao.getEmployeeById(id);
    }
    public boolean updateEmployee(Employee employee) {
    	return dao.updateEmployee(employee);
    }
    public boolean deleteEmployee(int id) {
    	return dao.deleteEmployee(id);
    }
    public List<Employee> searchEmployee(String keyword){

        return dao.searchEmployee(keyword);

    }
}