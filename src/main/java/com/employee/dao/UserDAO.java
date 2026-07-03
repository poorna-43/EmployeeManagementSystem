package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.employee.model.User;
import com.employee.util.DBUtil;

public class UserDAO {
	private static final String LOGIN_SQL="select * from users where username=? and password=?";
	public boolean validateUser(User user) {
		try(Connection con=DBUtil.getConnection();
				PreparedStatement ps=con.prepareStatement(LOGIN_SQL);){
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs=ps.executeQuery();
			return rs.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
