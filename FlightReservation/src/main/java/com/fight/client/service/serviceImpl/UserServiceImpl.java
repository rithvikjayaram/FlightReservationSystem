package com.fight.client.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fight.client.dao.daoImpl.UserDaoImpl;
import com.fight.client.model.User;
import com.fight.client.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDaoImpl userDao;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
