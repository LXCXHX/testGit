package com.lxc.springbootHelloWord.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.lxc.springbootHelloWord.mapper.PermissionMapper;
import com.lxc.springbootHelloWord.model.Permission;
import com.lxc.springbootHelloWord.service.PermissionService;

@Service
public class PermissionServiceImp implements PermissionService {
    
	@Autowired
	private PermissionMapper permapper;

	@Override
	public List<String> getPerList(Integer roleid) {
		Wrapper<Permission> wrapper = new EntityWrapper<Permission>();
	    wrapper.eq("roleid", roleid);
	    List<Permission> list = permapper.selectList(wrapper);
	    List<String> perList = new ArrayList<String>();
	    list.forEach(per -> {
	    	perList.add(per.getPername());
	    });
		return perList;
	}
	
	
		
}
