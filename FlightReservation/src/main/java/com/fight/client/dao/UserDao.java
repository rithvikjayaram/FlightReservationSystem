package com.fight.client.dao;

import java.util.List;

import com.fight.client.model.User;


public interface UserDao {

	public List<User> getAllUsers();
	 
	 public User findUserById(int id);
	 
	 public void addUser(User User);
	 
	 public void updateUser(User User);
	 
	 public void deleteUser(int id);
	 
	 public User findByEmail(String email);
}
