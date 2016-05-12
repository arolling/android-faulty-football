package com.epicodus.faultyfootballleague.models;

/**
 * Created by Guest on 5/12/16.
 */
public class Player {
    String name;
    String position;
    int arrestCount;

    public Player() {}

    public Player(String name, String position, int arrestCount){
        this.name = name;
        this.position = position;
        this.arrestCount = arrestCount;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getArrestCount() {
        return arrestCount;
    }
}
