//service for mini entity
package com.northerners.service.impl;

import com.northerners.mapper.impl.miniMapper;
import com.northerners.model.mini;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class miniService {
    private final miniMapper miniMapper;

    public miniService(miniMapper miniMapper){
        this.miniMapper = miniMapper;
    }

    public List<mini> findAllMini(){return miniMapper.findAll();}

    public mini findMiniById(int id){return miniMapper.findById(id);};

    public mini findMiniByName(String name){return miniMapper.findByMiniName(name);}

    public List<mini> findByInventoryId(int id){return miniMapper.findByInventoryId(id);}

    public int createNewMini(mini mini) {
        if (miniMapper.findByMiniName(mini.getModelName()) != null) {
            return 0;
        } else {
            return miniMapper.insert(mini);
        }
    }

    public int updateMini(mini mini){
        if(miniMapper.findById(mini.getMiniId()) == null){
            return 0;
        }
        else{
           return miniMapper.update(mini);
        }
    }

    public int deleteMini(mini mini){
        return miniMapper.delete(mini.getMiniId());
    }
}

