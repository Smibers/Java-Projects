package com.example.BigPiggie;

import java.util.Observable;

public class game extends Observable {
    @Override
    public String toString() {
        return "Game{" +
                "result='" + result + '\'' +
                ", date='" + date + '\'' +
                ", total='" + total + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    String result ;
    String date ;
    String total ;
    String name ;

    public String getResult() {
        return result;
    }

    public String getDate() {
        return date;
    }

    public String getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }

    public game(String result, String date, String total, String name) {
        this.result = result;
        this.date = date;
        this.total = total;
        this.name = name;
    }
}
