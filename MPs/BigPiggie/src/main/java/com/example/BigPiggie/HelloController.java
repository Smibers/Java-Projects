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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

public class HelloController {
    public boolean playerTurn = true;
    public  String dicePath = "C:\\Users\\smith\\OneDrive\\Desktop\\BigPiggie\\src\\main\\resources\\";
    Player player =new Player("player");
    Computer computer = new Computer("computer");

    @FXML public Button recordButton;
    @FXML public Button PlayButton;
    @FXML public TextField PlayerNameBox;

    @FXML private ImageView dice1;


    @FXML
    public Label insrtuction1;
    public Label PlayerScore;
    public Label ComputerScore;

    public HelloController() throws FileNotFoundException {
    }

    // Get controller
    public static ModuleLayer.Controller getPigController() {
        return pigController;
    }
    private static ModuleLayer.Controller pigController = HelloController.getPigController();
    
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

    public void Play(ActionEvent actionEvent) throws FileNotFoundException {
        player.setName(PlayerNameBox.getText());
        System.out.println(player.getName());
        PrintWriter out = new PrintWriter(new FileOutputStream("C:\\Users\\smith\\OneDrive\\Desktop\\BigPiggie\\src\\main\\resources\\Record",true));
        try {
            // Load the FXML file for the second controller
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pig.fxml"));
            Parent root = loader.load();
            System.out.println(loader);

            // Create a new Scene with the root node
            Scene scene = new Scene(root);
            System.out.println(root);

            // Set the Scene to the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            System.out.println(stage);
            stage.setScene(scene);
            System.out.println(scene);

            // Get the controller for the second view and initialize it
            //pigController controller = loader.getController();


            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void onClick(MouseEvent mouseEvent) {
        System.out.println("click");
    }


    public void Reroll(ActionEvent actionEvent) {
        int currentRoll;
        //if statement determining whether it is the players turn or not.
        //using playerTurn boolean
        if(player.isWinner()) {
            System.out.println(player.getName()+" has won");
            PlayerScore.setText("WINNER");
            player.print(player);
            computer.print(computer);
        }
        if(!player.isWinner()) {
                if (playerTurn) {
                    //then it will invoke the roll method, if 1 is rolled it will end player turn and set subtotal to 0
                    currentRoll = player.roll();
                    dice1.setImage(new Image(dicePath + currentRoll +".png"));
                   // System.out.println(dicePath + currentRoll +".png");
                    if (currentRoll == 1) {
                        playerTurn = false;
                        player.setSubTotal(0);
                        PlayerScore.setText(""+player.getPointTotal());
                    }
                    System.out.println(player.getName() + " Subtotal: " + player.getSubTotal());
                    PlayerScore.setText(""+ (player.getSubTotal() + player.getPointTotal()));
                } else {
//            System.out.println("It isn't your turn.");
                }
        }


        //if statement to check if it's the players turn  anymore, which will run the computers turn.
        if (!playerTurn) {
        computerTurn();
        }
    }
    public void Hold(ActionEvent actionEvent) {

        if (playerTurn) {
            player.totalPoints();
            System.out.println("Player total: " + player.getPointTotal());
            PlayerScore.setText(""+player.getPointTotal());
            player.setSubTotal(0);
//          System.out.println(player.getSubTotal());
//          System.out.println(player.getPointTotal());
            playerTurn = false;
        } else {
            System.out.println("It isn't your turn.");
        }

        if(player.isWinner()) {
            System.out.println(player.getName()+" has won");
            PlayerScore.setText("WINNER");
            player.print(player);
            computer.print(computer);
        }else {
            if (!playerTurn) {
                computerTurn();
            }
        }

    }
    public void Back(ActionEvent actionEvent) {
        player.reset();
        computer.reset();
        try {
            // Load the FXML file for the second controller
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();
            System.out.println(loader);

            // Create a new Scene with the root node
            Scene scene = new Scene(root);
            System.out.println(root);

            // Set the Scene to the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            System.out.println(stage);
            stage.setScene(scene);
            System.out.println(scene);

            // Get the controller for the second view and initialize it
            //pigController controller = loader.getController();


            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }













    }

    public void computerTurn(){
        int roll= 0;
        {
                //check if computer has one.
                if(!computer.isWinner()){
                    //Computer takes first turn
                    roll =  computer.takeTurn();
                    //System.out.println(roll);
                    dice1.setImage(new Image(dicePath + roll +".png"));
                    ComputerScore.setText(""+ (computer.getPointTotal()+computer.getSubTotal()));
                    // computer decides if it wants to hold or not.
                    computer.decideHold();
                    //if not it enters the turn loop
                    while(!computer.isHold()){
                        roll =  computer.takeTurn();
                        //System.out.println(roll);
                        dice1.setImage(new Image(dicePath + roll +".png"));
                        ComputerScore.setText(""+ (computer.getPointTotal()+computer.getSubTotal()));
                        computer.decideHold();
                    }
                    //makes total after computer has taken turn.
                    computer.setPointTotal(computer.getNewTotal());
                    ComputerScore.setText(""+ computer.getPointTotal());
                    computer.setHold(false);
                    System.out.println("Computer total: "+ computer.getPointTotal());
                    //check at the end to see if the computer has won
                    if(computer.isWinner()){
                        System.out.println("The Computer is the winner");
                        ComputerScore.setText("WINNER");
                        player.print(player);
                        computer.print(computer);
                    }else{
                        playerTurn=true;
                    }

                }

        }
    }
}





