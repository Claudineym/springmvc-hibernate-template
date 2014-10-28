package com.example.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDAO;
import com.example.domain.User;

@Service
@Transactional
public class UserBO {

	private UserDAO userDAO;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void createUser(User user) {
		userDAO.createUser(user);
	}
	
	public void deleteUser(int userId) {
		User userToDelete = userDAO.getUserById(userId);
		userDAO.deleteUser(userToDelete);
	}
	
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public List<User> getUserList() {
		return userDAO.getUserList();
	}
	
	public User getUserByUserName(String username) {
		return userDAO.getUserByUserName(username);
	}

	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}
}
