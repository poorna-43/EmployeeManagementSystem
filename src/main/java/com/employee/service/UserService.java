package com.employee.service;

import com.employee.dao.UserDAO;
import com.employee.model.User;

public class UserService {
	private UserDAO dao=new UserDAO();
	public boolean validateUser(User user) {
		return dao.validateUser(user);
	}
}
