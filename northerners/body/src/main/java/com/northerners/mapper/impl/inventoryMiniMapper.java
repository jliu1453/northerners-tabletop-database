package com.northerners.mapper.impl;

import com.northerners.dto.inventoryMini;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface inventoryMiniMapper {
    int insertMini(inventoryMini inventoryMini);
    inventoryMini checkIfExist(inventoryMini inventoryMini);
    int deleteAllMini(int inventoryId);
    int deleteMini(inventoryMini inventoryMini);
}
