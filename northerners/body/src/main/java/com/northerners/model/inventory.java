//inventory, each user have one and only one, each inventory can own one or more minis
package com.northerners.model;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //change, user should HAS-A inventory
public class inventory {
    private int userId;
    private int inventoryId;
    private List<mini> ownedMinis;


    public inventory(){

    }

    public inventory(int userId, List<mini> ownedMinis,){
        this.userId = userId;
        this.ownedMinis = ownedMinis;
    }

    public List<mini> getOwnedMinis() {
        return ownedMinis;
    }

    public int getUserId(){
        return userId;
    }

    public List<ruleBook> getOwnedBooks() {
        return ownedBooks;
    }


    public void setOwnedBooks(List<ruleBook> ownedBooks) {
        this.ownedBooks = ownedBooks;
    }

    public void setOwnedMinis(List<mini> ownedMinis) {
        this.ownedMinis = ownedMinis;
    }



    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }
}

