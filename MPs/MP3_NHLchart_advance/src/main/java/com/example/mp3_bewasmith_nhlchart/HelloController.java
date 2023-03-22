package com.example.mp3_bewasmith_nhlchart;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public BarChart<String, Integer>barChart ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        XYChart.Series<String,Integer> series1= new XYChart.Series<>();
        series1.setName("Goal stats");
        series1.getData().add(new XYChart.Data("Winnipeg",270));
        series1.getData().add(new XYChart.Data("Tampa Bay",319));
        series1.getData().add(new XYChart.Data("Nashville",236));
        series1.getData().add(new XYChart.Data("Detroit",224));
        series1.getData().add(new XYChart.Data("Los Angeles",199));
        series1.getData().add(new XYChart.Data("Boston",257));
        series1.getData().add(new XYChart.Data("Toronto",286));


        barChart.getData().add(series1);





    }
}