package com.lxc.springbootHelloWord.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lxc.springbootHelloWord.model.Permission;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
