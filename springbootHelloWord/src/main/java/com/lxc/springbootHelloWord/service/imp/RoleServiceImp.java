package com.lxc.springbootHelloWord.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxc.springbootHelloWord.mapper.RoleMapper;
import com.lxc.springbootHelloWord.model.Role;
import com.lxc.springbootHelloWord.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
	private RoleMapper roleMapper;
    
    public Role getRole(Integer id) {
    	Role role = roleMapper.selectById(id);
    	return role;
    }
    
    
}
