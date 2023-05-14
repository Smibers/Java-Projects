package com.example.BigPiggie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Scanner;

public class HelloController {


    @FXML
    public Label insrtuction1;
    public Label insrtuction2;
    public RadioButton Player1;
    public RadioButton Player2;
    public RadioButton Comp2;
    public RadioButton Comp1;
    public TextField PlayerNameBox1;
    public TextField PlayerNameBox2;


    public static ModuleLayer.Controller getPigController() {
        return pigController;
    }


    private static ModuleLayer.Controller pigController = HelloController.getPigController();


    public void MouseClicked(MouseEvent mouseEvent) {
        System.out.println("you clicked the mouse");
    }

    public void Option1(ActionEvent actionEvent) {
        insrtuction1.setText("Please Enter player name");
        PlayerNameBox1.clear();
        PlayerNameBox1.setDisable(false);
    }

    public void Option2(ActionEvent actionEvent) {
        insrtuction1.setText("Computer Selected");
        PlayerNameBox1.setText("COMPUTER1");
        PlayerNameBox1.setDisable(true);
    }

    public void Option3(ActionEvent actionEvent) {
        insrtuction2.setText("Please Enter player name");
        PlayerNameBox2.clear();
        PlayerNameBox2.setDisable(false);
    }

    public void Option4(ActionEvent actionEvent) {
        insrtuction2.setText("Computer Selected");
        PlayerNameBox2.setText("COMPUTER2");
        PlayerNameBox2.setDisable(true);
    }

    public void NameEntered1(ActionEvent actionEvent) {

    }

    public void NameEntered2(ActionEvent actionEvent) {

    }

    public void setStage() {
        getPigController();
    }


    public void Record(ActionEvent actionEvent) {

        TableView<game> table;
        //column 1
        TableColumn<game, String> gameResult = new TableColumn<>("Game Result");
        gameResult.setMaxWidth(200);
        gameResult.setCellValueFactory(new PropertyValueFactory<>("result"));

// column 2
        TableColumn<game, String> date = new TableColumn<>("Date");
        date.setMaxWidth(200);
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

// column 3
        TableColumn<game, String> total = new TableColumn<>("Total");
        total.setMaxWidth(200);
        total.setCellValueFactory(new PropertyValueFactory<>("total"));

// column 4
        TableColumn<game, String> name = new TableColumn<>("Name");
        name.setMaxWidth(200);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

//table
        table = new TableView<>();
        table.getColumns().addAll(gameResult, date, total, name);


        //table


        table.setItems(getGames("C:\\Users\\smith\\OneDrive\\Desktop\\BigPiggie\\src\\main\\resources\\Record"));
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);
        Scene scene = new Scene(vBox);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Records");
        stage.setScene(scene);
        stage.show();


    }


    public ObservableList<game> getGames(String file) {
        String result;
        String date;
        String total;
        String name;
        ObservableList<game> games = FXCollections.observableArrayList();
        try (Scanner reader = new Scanner(new FileInputStream(file))) {
            while (reader.hasNext()) {
                result = reader.next();
                date = reader.next();
                total = reader.next();
                name = reader.next();
                System.out.println(result + date + total + name);
                game g = new game(result, date, total, name);
                System.out.println(g);
                games.add(g);
                System.out.println(games);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return games;
    }

    public void Play(ActionEvent actionEvent) {
        Computer c1= null;
        Computer c2=null;
        Player p1 = null;
        Player p2 = null;
        int c1Total = 0;
        int c2Total = 0;
        int p1Total = 0;
        int p2Total = 0;
        if (Comp1.isSelected() || Player1.isSelected() && Comp2.isSelected() || Player2.isSelected()) {


            if (Comp1.isSelected()) {
                Computer computer1 = new Computer("COMPUTER");
                System.out.println(computer1);
                c1=computer1;
            }
            if (Comp2.isSelected()) {
                Computer computer2 = new Computer("COMPUTER2");
                System.out.println(computer2);
                c2=computer2;
            }
            if (Player1.isSelected()) {
                Player play1 = new Player(PlayerNameBox1.getText());
                System.out.println(play1);
            }
            if (Player2.isSelected()) {
                Player play2 = new Player(PlayerNameBox2.getText());
                System.out.println(play2);
            }

            try {
                // Load the FXML file for the second controller
                FXMLLoader loader = new FXMLLoader(getClass().getResource("pig.fxml"));
                Parent root = loader.load();

                // Create a new Scene with the root node
                Scene scene = new Scene(root);

                // Set the Scene to the current stage
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(scene);

                // Get the controller for the second view and initialize it
                pigController controller = loader.getController();


                // Show the stage
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (c1Total < 100 || c2Total < 100 || p1Total < 100 || p2Total <100) {
                if (Comp1.isSelected()) {
                    if (c1Total >= 100 || c2Total >= 100) {
                        break;
                    } else {
                        try {
                            c1.turn();
                            c1Total = c1.getPointTotal();
                        } catch (RuntimeException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (Comp2.isSelected()) {
                    if (c1Total >= 100 || c2Total >= 100) {
                        break;
                    } else {
                        try {

                            c2.turn();
                            c2Total = c2.getPointTotal();
                        } catch (RuntimeException e) {
                            e.printStackTrace();
                        }
                    }
                } if (Player1.isSelected()) {
                    if (p1Total >= 100 || p2Total >= 100) {
                        break;
                    } else {
                        try {
                            p1.Turn();
                            p1Total = p1.getPointTotal();
                        } catch (RuntimeException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (Player2.isSelected()) {
                        if (p1Total >= 100 || p2Total >= 100) {
                            break;
                        } else {
                            try {
                                p2.Turn();
                                p2Total = p2.getPointTotal();
                            } catch (RuntimeException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }



                }
    }
}}}




