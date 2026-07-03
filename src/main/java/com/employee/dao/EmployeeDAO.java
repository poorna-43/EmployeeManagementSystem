package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee.model.Employee;
import com.employee.util.DBUtil;

public class EmployeeDAO {

    private static final String INSERT_EMPLOYEE =
            "INSERT INTO employee(emp_name, department, salary) VALUES (?, ?, ?)";

    public boolean registerEmployee(Employee employee) {

        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEE);
        ) {

            ps.setString(1, employee.getEmpName());
            ps.setString(2, employee.getDepartment());
            ps.setDouble(3, employee.getSalary());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public List<Employee> getAllEmployees(){
    	List<Employee> employees=new ArrayList<>();
    	String sql="Select * from employee";
    	Connection con=DBUtil.getConnection();
    	try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee employee=new Employee();
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setEmpName(rs.getString("emp_name"));
				employee.setDepartment(rs.getString("department"));
				employee.setSalary(rs.getDouble("salary"));
				
				employees.add(employee);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return employees;
    }
    public Employee getEmployeeById(int id) {
    	String sql="select * from employee where emp_id=?";
    	Connection con=DBUtil.getConnection();
    	try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Employee employee=new Employee();
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setEmpName(rs.getString("emp_name"));
				employee.setDepartment(rs.getString("department"));
				employee.setSalary(rs.getDouble("salary"));
				
				return employee;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return null;
    	
    }
    public boolean updateEmployee(Employee employee) {
    	String sql="update employee set emp_name=?,department=?,salary=? where emp_id=?";
    	Connection con=DBUtil.getConnection();
    	try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,employee.getEmpName());
			ps.setString(2,employee.getDepartment());
			ps.setDouble(3, employee.getSalary());
			ps.setInt(4, employee.getEmpId());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return false;
    }
    public boolean deleteEmployee(int id) {
		String sql="delete from employee where emp_id=?";
		Connection con=DBUtil.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
    public List<Employee> searchEmployee(String keyword){

        List<Employee> list = new ArrayList<>();

        String sql = "SELECT * FROM employee WHERE emp_name LIKE ?";

        try(
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Employee emp = new Employee();

                emp.setEmpId(rs.getInt("emp_id"));
                emp.setEmpName(rs.getString("emp_name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));

                list.add(emp);

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;

    }
    
}