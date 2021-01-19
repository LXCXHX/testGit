package com.lxc.springbootHelloWord.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lxc.springbootHelloWord.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{
    
	//用MyBatis-plus 不需要写简单的crud sql语句
    
}
