package com.lxc.springbootHelloWord.service;

import com.lxc.springbootHelloWord.model.User;

public interface UserService {
  
	public User getUser(Integer id);
	
	public void updateUser(User user);
	
	public void deleteUser(Integer id);
	
	public void insertUser(User user);

	public User selectUserByUsername(String username);
}
