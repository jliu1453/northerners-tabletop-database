//entity mini, has many to many relation with inventory
package com.northerners.model;
import org.springframework.stereotype.Component;

@Component
public class mini {
    private  int miniId;
    private int baseSize;
    private int points;
    private String modelName;
    private String faction;

    public int getMiniId() {
        return miniId;
    }

    public int getBaseSize() {
        return baseSize;
    }

    public int getPoints() {
        return points;
    }

    public String getFaction() {
        return faction;
    }

    public String getModelName() {
        return modelName;
    }

    public void setBaseSize(int baseSize) {
        this.baseSize = baseSize;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setMiniId(int miniId) {
        this.miniId = miniId;
    }
}

