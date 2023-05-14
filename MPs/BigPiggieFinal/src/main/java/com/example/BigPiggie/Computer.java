package com.example.BigPiggie;

import java.util.Random;

public class Computer {
    public String getName() {
        return name;
    }

    private String name;
    private int pointTotal;
    public Computer(String name) {
        this.name = name;
        this.pointTotal = 0;
    }

    public int getPointTotal() {
        return pointTotal;
    }

    public void turn(){


        boolean hold = false;
        int numb = 0;
        int roll;
        int subtotal = 0;
        if(pointTotal >= 100 ){
            System.out.println(getName()+" Wins");
            hold= true;
            }
        if(pointTotal<100) {
            Random random = new Random();
            roll = random.nextInt(6) + 1;
            if (roll == 1) {
                roll = random.nextInt(1, 6);
                subtotal += roll;
                System.out.println(getName()+" has rolled " + roll);
                System.out.println(getName()+" new score is " + subtotal);
            } else {
                subtotal += roll;
                System.out.println(getName()+" has rolled " + roll);
                System.out.println(getName()+" new score is " + subtotal);
            }

        }
        while(hold != true){

            if(pointTotal >= 100 ){
                System.out.println(getName()+" Wins");
                hold= true;
                break;}

            Random random = new Random();
            numb = random.nextInt(6);
            if(numb == 0 || numb == 1 || numb == 2 || numb == 3){
                //"click roll"
                roll = random.nextInt(6)+1;
                if(roll == 1){
                    hold = true;
                    System.out.println(getName()+" has rolled a 1 turn over LOSER");
                    if(pointTotal >= 100 ){
                        System.out.println(getName()+" Wins");
                        hold= true;
                        }
                    break;
                }
                    subtotal+=roll;
                System.out.println(getName()+" has rolled "+roll);
                System.out.println(getName()+" new score is "+subtotal);
            }else if(numb == 4 || numb == 5){
                //hold
                hold = true;
                pointTotal+=subtotal;
                System.out.println(getName()+" has held");
                break;
            }

        }       if (hold == true){
            System.out.println(getName()+"s turn has ended with this total "+pointTotal);
            if(pointTotal>=100){
                System.out.println(getName()+" wins");
            }
        }

}}

