package com.northerners.service.impl;

import com.northerners.dto.inventoryMini;
import com.northerners.mapper.impl.inventoryMapper;
import com.northerners.mapper.impl.inventoryMiniMapper;
import com.northerners.model.inventory;
import com.northerners.model.mini;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inventoryService {
    private final inventoryMapper inventoryMapper;
    private final inventoryMiniMapper inventoryMiniMapper;

    public inventoryService(inventoryMapper inventoryMapper, inventoryMiniMapper inventoryMiniMapper){
        this.inventoryMapper = inventoryMapper;
        this.inventoryMiniMapper = inventoryMiniMapper;
    }

    public List<inventory> findAllInventory(){

        List<inventory> inventory = inventoryMapper.findAll();
        for(inventory temp :  inventory){
            temp.setOwnedMinis(inventoryMapper.getInventoryMini(temp.getInventoryId()));
        }
        return inventory;
    }

    public inventory findByUserId(int id){return inventoryMapper.findByUserId(id);}

    public int createInventory(inventory inventory){
        if(inventoryMapper.findByUserId(inventory.getUserId()) != null){
            return 0;
        }
        else{
            return inventoryMapper.insert(inventory);
        }
    }
    public int insertMini(inventoryMini inventoryMini){
        if(inventoryMiniMapper.checkIfExist(inventoryMini) == null){
            return inventoryMiniMapper.insertMini(inventoryMini);
        }
        else{
            return 0;
        }
    }

    public int checkIfInsideInventory(inventoryMini inventoryMini){
        if(inventoryMiniMapper.checkIfExist(inventoryMini)  == null){
            return 0;
        }
        else{
            return 1;
        }
    }

    public int deleteMini(inventoryMini inventoryMini){
        return inventoryMiniMapper.deleteMini(inventoryMini);
    }

    public int updateInventory(inventory inventory){
        if(inventoryMapper.findById(inventory.getInventoryId()) == null){
            return 0;
        }
        else{
            return inventoryMapper.update(inventory);
        }
    }

    public int deleteInventory(int id){
        return inventoryMapper.delete(id);
    }
}
