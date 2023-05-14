package com.example.BigPiggie;

public class Player {
    private String  name;
    private int pointTotal;

    public Player(String name) {
        this.name = name;
        this.pointTotal = 0;
    }

    public String getName() {
        return name;
    }

    public int getPointTotal() {
        return pointTotal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPointTotal(int pointTotal) {
        this.pointTotal = pointTotal;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pointTotal=" + pointTotal +
                '}';
    }
}
