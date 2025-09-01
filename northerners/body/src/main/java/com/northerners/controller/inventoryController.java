package com.northerners.controller;

import com.northerners.dto.inventoryMini;
import com.northerners.model.inventory;
import com.northerners.model.mini;
import com.northerners.service.impl.inventoryService;
import com.northerners.service.impl.miniService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class inventoryController {
    private final inventoryService inventoryService;
    private final miniService miniService;

    public inventoryController(inventoryService inventoryService, miniService miniService){
        this.inventoryService = inventoryService;
        this.miniService = miniService;
    }

    @GetMapping
    public List<inventory> getAllInventory(){return inventoryService.findAllInventory();}

    @GetMapping("/{inventoryId}/mini")
    public List<mini> listAllMiniUnderInventory(@PathVariable int inventoryId){
       return miniService.findByInventoryId(inventoryId);
    }

    @PostMapping
    public ResponseEntity<inventory> insertInventory(@RequestBody inventory inventory){
        inventory temp = new inventory();
        if(inventoryService.createInventory(inventory) != 0){
            return ResponseEntity.status(HttpStatus.CREATED).body(inventory);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/mini")
    public ResponseEntity<Integer> insertMiniToInventory(@RequestBody inventoryMini inventoryMini){
        int result = inventoryService.insertMini(inventoryMini);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(0);
        }
    }

    @DeleteMapping("/{inventoryId}/mini/{miniId}")
    public ResponseEntity<Void> deleteMiniFromInventory(@PathVariable int inventoryId, @PathVariable int miniId){
        inventoryMini temp = new inventoryMini();
        temp.setInventoryId(inventoryId);
        temp.setMiniId(miniId);
        int result = inventoryService.checkIfInsideInventory(temp);
        if(result > 0){
            inventoryService.deleteMini(temp);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
