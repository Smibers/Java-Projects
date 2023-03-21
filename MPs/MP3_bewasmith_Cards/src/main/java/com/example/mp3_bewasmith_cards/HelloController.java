package com.example.mp3_bewasmith_cards;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class HelloController {

    private int randnum1;
    private int randnum2;
    private int randnum3;
    private Random ran = new Random();
    @FXML
    private ImageView card1;
    @FXML
    private ImageView card2;
    @FXML
    private ImageView card3;
    private String path ="file:/C:/Users/smith/IdeaProjects/MP3_bewasmith_Cards/src/main/resources/";
   public void onClick(MouseEvent e){
       if (e.getSource().equals(card1)){
           card1.setImage(new Image(path+randnum1+".png"));
       }      else if (e.getSource().equals(card2)){
           card2.setImage(new Image(path+randnum2+".png"));
       } else if (e.getSource().equals(card3)){
           card3.setImage(new Image(path+randnum3+".png"));
       }

    }
    public void onButtonClick(){
        randnum1=ran.nextInt(54)+1;
        randnum2=ran.nextInt(54)+1;
        randnum3=ran.nextInt(54)+1;


    }
}