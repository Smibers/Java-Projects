package com.example.BigPiggie;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class pigController {


    private int randnum2;

    private Random ran = new Random();

    @FXML
    private ImageView dice;

    private String path ="C:/Users/smith/OneDrive/Desktop/BigPiggie/src/main/resources";
   public void onClick(MouseEvent e){
       if (e.getSource().equals(dice)) {
           dice.setImage(new Image(path + randnum2 + ".png"));
       }

    }
    public void onButtonClick(){
        randnum2=ran.nextInt(6)+1;


    }
}