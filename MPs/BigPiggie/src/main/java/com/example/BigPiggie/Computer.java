package com.example.BigPiggie;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Computer {
    private String name;
    private int pointTotal;

    public int getSubTotal() {
        return subTotal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public void setPointTotal(int pointTotal) {
        this.pointTotal = pointTotal;
    }

    boolean hold = false;
    int subTotal = 0;

    private boolean Win;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    Random random = new Random();
    PrintWriter out = new PrintWriter(new FileOutputStream("C:\\Users\\smith\\OneDrive\\Desktop\\BigPiggie\\src\\main\\resources\\Record",true));
    public Computer(String name) throws FileNotFoundException {
        this.name = name;
        this.pointTotal = 0;
    }

    public int getPointTotal() {
        return pointTotal;
    }

    public String getName() {
        return name;
    }

    public void print(Computer computer){
        try {

            if(computer.getPointTotal() >= 100){
                out.print("Winner ");
            }else{
                out.print("Loser ");
            }
            out.print( formatter.format(date)+" "+computer.getPointTotal()+" "+computer.getName());
            //new Date().getMonth()+"-"+new Date().getDay()+"-"+new Date().getYear()
            out.println();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public boolean isHold() {
        return hold;
    }

    public int takeTurn() {
        int roll;
        roll = random.nextInt(6)+1;

        if(roll == 1) {
            hold = true;
            subTotal =0;
        }else{
            subTotal = subTotal+roll;
            System.out.println("Computer Subtotal is : "+subTotal);
        }
        System.out.println("Computer Roll is : "+roll);
        return roll;

    }
    public boolean isWinner(){
        if(pointTotal >= 100) {
            return true;
        }else{
            return false;
        }
    }
    public void decideHold(){
        int numb = 0;
        numb = random.nextInt(6);
        if(!hold) {
            if (numb == 0 || numb == 1 || numb == 2 || numb == 3) {
                hold = false;
            } else if (numb == 4 || numb == 5) {
                getNewTotal();
                subTotal = 0;
                hold = true;
            } else {
                hold = true;
            }
        }
    }
    public int getNewTotal(){
        pointTotal+=subTotal;
        return pointTotal;
    }
    public void reset(){
        pointTotal = 0;
        subTotal = 0;
    }
}
