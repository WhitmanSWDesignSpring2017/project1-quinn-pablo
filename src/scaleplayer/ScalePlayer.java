/*
 * CS 300-A, 2017S
 */
package scaleplayer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;


/**
 * This JavaFX app lets the user play scales.
 * @author Janet Davis 
 * @author Put your name here!
 * @author Put your partner's name here!
 * @since January 26, 2017
 */
public class ScalePlayer extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Menu file = new Menu("File");
        menuBar.getMenus().add(file);
        MenuItem exitMenuItem = new MenuItem("Exit");
        file.getItems().add(exitMenuItem);
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        Button playBtn = new Button();
        playBtn.setText("Play Scale");
        playBtn.setStyle("-fx-base: #b6e7c9;");
        playBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        Button stopBtn = new Button();
        stopBtn.setText("Stop Playing");
        stopBtn.setStyle("-fx-base: #eda6a6;");
        stopBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        HBox hbox = new HBox();
        hbox.getChildren().addAll(playBtn, stopBtn);
        hbox.setSpacing(10);


        BorderPane root = new BorderPane();
        root.setCenter(hbox);
        root.setTop(menuBar);



        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Scale Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
