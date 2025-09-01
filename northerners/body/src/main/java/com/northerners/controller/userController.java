package com.northerners.controller;

import com.northerners.model.inventory;
import com.northerners.model.user;
import com.northerners.service.impl.inventoryService;
import com.northerners.service.impl.userService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    private final userService userService;
    private final inventoryService inventoryService;
    public userController(userService userService, inventoryService inventoryService){
        this.userService = userService;
        this.inventoryService = inventoryService;
    }

    @GetMapping("{userId}")
    public user getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<user> getAllUser(){
        return userService.findAllUser();
    }

    @RequestMapping("{userId}/inventory")
    public inventory getByUserId(@PathVariable int userId){ return inventoryService.findByUserId(userId);}

    @PostMapping
    public ResponseEntity<user> insertUser(@RequestBody user user){
        user temp = new user();
        if(userService.createNewUser(user) != 0){
            temp = userService.getUserByName(user.getUserName());
            return ResponseEntity.status(HttpStatus.CREATED).body(temp);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Integer> updateUser(@PathVariable int userId, @RequestBody user user){
        int result = 0;
        if(user.getUserId() != userId){
            return ResponseEntity.badRequest().build();
        }
        result = userService.updateUser(user);
        if(result == 0){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(result);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Integer> deleteUser(@PathVariable int userId){
        user temp = userService.getUserById(userId);
        if(temp == null){
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(temp);
        return ResponseEntity.noContent().build();
    }
}
