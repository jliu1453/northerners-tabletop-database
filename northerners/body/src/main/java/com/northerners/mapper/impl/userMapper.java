package com.northerners.mapper.impl;

import com.northerners.mapper.repo;
import com.northerners.model.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper extends repo<user, Integer> {
    public user findByUserName(String name);
}
