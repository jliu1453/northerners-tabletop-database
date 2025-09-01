package com.northerners.mapper.impl;

import com.northerners.mapper.repo;
import com.northerners.model.ruleBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ruleBookMapper extends repo<ruleBook, Integer> {
    public ruleBook findByBookName(String name);
}
