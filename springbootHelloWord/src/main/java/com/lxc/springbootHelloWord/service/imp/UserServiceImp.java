package com.lxc.springbootHelloWord.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.lxc.springbootHelloWord.mapper.UserMapper;
import com.lxc.springbootHelloWord.model.User;
import com.lxc.springbootHelloWord.service.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService{
    
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUser(Integer id) {
		User user = userMapper.selectById(id);
		return user;
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateById(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userMapper.deleteById(id);
	}
	
	@Override
	public void insertUser(User user) {
	    userMapper.insert(user);	
	}

	@Override
	public User selectUserByUsername(String username) {
		Wrapper<User> wrapper = new EntityWrapper<User>();
		wrapper.eq("name", username);
		List<User> list = userMapper.selectList(wrapper);
		return list.get(0);
	}
	
}
