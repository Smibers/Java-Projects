package com.example.BigPiggie;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class pigController  {


    private int randnum2;

    private Random ran = new Random();


    @FXML
    private ImageView dice1;

    private String path ="C:\\Users\\ToofEater\\IdeaProjects\\BigPiggie\\src\\main\\resources\\";


   public void onClick(MouseEvent e){
       if (e.getSource().equals(dice1)) {
           dice1.setImage(new Image(path + randnum2 + ".png"));
       }

    }
    public void onButtonClick(Event e) {
        randnum2 = ran.nextInt(6) + 1;

        dice1.setImage(new Image(path + randnum2 + ".png"));

    }
    public void sudoClick() {
        randnum2 = ran.nextInt(6) + 1;

        dice1.setImage(new Image(path + randnum2 + ".png"));


    }

}