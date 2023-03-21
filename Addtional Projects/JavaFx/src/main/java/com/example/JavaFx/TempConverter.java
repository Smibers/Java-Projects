package com.example.JavaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TempConverter extends Application
{
	@Override
	public void start(Stage stage) throws Exception
	{


		HBox hBox = new HBox(4);
		Button Far = new Button("Convert to Farenhieht");
		Button Cel = new Button("Convert to Celcius");

		TextField result=new TextField();
		TextField tempbox=new TextField("Result Here");

		hBox.setAlignment(Pos.CENTER);

		hBox.getChildren().add(Cel);
		hBox.getChildren().add(Far);
		hBox.getChildren().add(result);
		hBox.getChildren().add(tempbox);



		Cel.setOnAction(event -> {
			double c = Double.parseDouble(result.getText());
			System.out.println("click the convert to Celicius box");

			tempbox.setText(String.valueOf((c - 32) * 5/9));
		});
		Far.setOnAction(event -> {
			double f = Double.parseDouble(result.getText());
			System.out.println("click the convert to Farenhiet box");

			tempbox.setText(String.valueOf((f * 9/5) + 32));
		});



		Scene scene = new Scene(hBox,650,500);
		stage.setScene(scene);
		stage.show();





	}
	class ButtonEventHandlerCels implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event)
		{
			System.out.printf("you click the button");
		}
	}
}
