package com.northerners.service.impl;
import com.northerners.mapper.impl.userMapper;
import com.northerners.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService{
    private final userMapper mapper;

    public userService(userMapper mapper){
        this.mapper = mapper;
    }

    public List<user> findAllUser(){
        return mapper.findAll();
    }

    public user getUserById(int id){
        return mapper.findById(id);
    }

    public user getUserByName(String name){return mapper.findByUserName(name);}

    public int createNewUser(user user){
        if(mapper.findByUserName(user.getUserName()) != null){
            return 0;
        }
        else{
            return mapper.insert(user);
        }
    }

    public int updateUser(user user){
        if(mapper.findById(user.getUserId()) == null){
            return 0;
        }
        else{
            return mapper.update(user);
        }
    }

    public int deleteUser(user user){
        return mapper.delete(user.getUserId());
    }

}
