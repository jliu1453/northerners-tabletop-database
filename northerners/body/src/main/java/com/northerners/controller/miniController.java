//rest end point for mini
package com.northerners.controller;

import com.northerners.model.mini;
import com.northerners.service.impl.miniService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mini")
public class miniController {
    private final miniService miniService;

    // Constructor injection
    public miniController(miniService miniService) {
        this.miniService = miniService;
    }

    @RequestMapping("/{miniId}")
    public mini getMiniById(@PathVariable int miniId){
         return miniService.findMiniById(miniId);
    }

    @GetMapping
    public List<mini> getAllMini(){
        return miniService.findAllMini();
    }

    @PostMapping
    public ResponseEntity<mini> insertMini(@RequestBody mini mini){
        mini temp =  new mini();
        if(miniService.createNewMini(mini) != 0){
            temp = miniService.findMiniByName(mini.getModelName());
            return ResponseEntity.status(HttpStatus.CREATED).body(temp);
        }
        else{
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{miniId}")
    public ResponseEntity<Integer> updateMini(@PathVariable int miniId, @RequestBody mini mini){
        int result = 0;
        if(mini.getMiniId() != miniId){
            return ResponseEntity.badRequest().build();
        }
        result = miniService.updateMini(mini);
        if(result == 0){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(result);
        }
    }

    @DeleteMapping("/{miniId}")
    public ResponseEntity<Integer> deleteMini(@PathVariable int miniId){
        mini temp = new mini();
        temp = miniService.findMiniById(miniId);
        if(temp == null){
            return ResponseEntity.notFound().build();
        }
        miniService.deleteMini(temp);
        return ResponseEntity.noContent().build();
    }
}

