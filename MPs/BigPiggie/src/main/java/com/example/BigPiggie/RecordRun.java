package com.example.BigPiggie;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RecordRun extends Application {

    TableView<game> table;




    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(pigController.class.getResource("RecordScreen.fxml"));

        //column 1
        TableColumn<game,String> gameResult = new TableColumn<>("Game Result");
        gameResult.setMaxWidth(200);
        gameResult.setCellValueFactory(new PropertyValueFactory<>("result"));

// column 2
        TableColumn<game,String> date = new TableColumn<>("Date");
        date.setMaxWidth(200);
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

// column 3
        TableColumn<game,String> total = new TableColumn<>("Total");
        total.setMaxWidth(200);
        total.setCellValueFactory(new PropertyValueFactory<>("total"));

// column 4
        TableColumn<game,String> name = new TableColumn<>("Name");
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
        stage.setTitle("Records");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
      //  RecordController.Read("C:\\Users\\Alvar\\Favorites\\IntellijWorkSpace\\PIG2\\src\\main\\resources\\Record");

        launch();

    }
    public ObservableList<game> getGames(String file){
        String result;
        String date;
        String total;
        String name;
        ObservableList<game> games = FXCollections.observableArrayList();
        try(Scanner reader = new Scanner(new FileInputStream(file))){
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

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return games;
    }
}
