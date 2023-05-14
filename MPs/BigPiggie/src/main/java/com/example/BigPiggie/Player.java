package com.example.BigPiggie;

import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Player {
    private String  name;
    private int pointTotal;
    private int roll;
    private int subTotal;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    Random random = new Random();
    PrintWriter out = new PrintWriter(new FileOutputStream("C:\\Users\\smith\\OneDrive\\Desktop\\BigPiggie\\src\\main\\resources\\Record",true));
    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public int getRoll() {
        return roll;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public Player(String name) throws FileNotFoundException {
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
    public int roll(){
        int roll;
        Random random = new Random();
        roll=random.nextInt(6)+1;
        subTotal = subTotal+ roll;
        System.out.println( name +" Roll: "+ roll);
        return roll;
    }
    public void totalPoints(){
        pointTotal = subTotal+pointTotal;
    }
    public boolean isWinner(){
        if(pointTotal >= 100) {
            return true;
        }else{
            return false;
        }
    }

    public void print(Player Player){
        try {

            if(Player.getPointTotal() >= 100){
                out.print("Winner ");
            }else{
                out.print("Loser ");
            }
            out.print( formatter.format(date)+" "+Player.getPointTotal()+" "+Player.getName());
            //new Date().getMonth()+"-"+new Date().getDay()+"-"+new Date().getYear()
            out.println();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    public void reset(){
        pointTotal = 0;
        subTotal = 0;
        roll = 0;
    }
}
