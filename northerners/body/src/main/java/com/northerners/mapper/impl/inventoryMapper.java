package com.northerners.mapper.impl;

import com.northerners.dto.inventoryMini;
import com.northerners.mapper.repo;
import com.northerners.model.inventory;
import com.northerners.model.mini;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface inventoryMapper extends repo<inventory, Integer> {
    inventory findByUserId(int id);

    List<mini> getInventoryMini(int inventoryId);
}

