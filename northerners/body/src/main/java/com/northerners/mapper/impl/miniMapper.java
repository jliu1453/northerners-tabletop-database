package com.northerners.mapper.impl;

import com.northerners.mapper.repo;
import com.northerners.model.mini;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface miniMapper extends repo<mini, Integer> {
    public mini findByMiniName(String name);
    public List<mini> findByInventoryId(int id);
}
