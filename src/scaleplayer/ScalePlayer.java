/*
 * CS 300-A, 2017S
 */
package scaleplayer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.*;
import java.util.*;

/**
 * This JavaFX app lets the user play scales.
 * @author Pablo Fernandez
 * @author Quinn Salkind
 * @since January 26, 2017
 */
public class ScalePlayer extends Application {

    private static int startingNote;
    private MidiPlayer sequence = new MidiPlayer(2, 60);

    /**
     * Start: Handles the menu bar, buttons, exits, and events. 
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        
        //create menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Menu file = new Menu("File");
        menuBar.getMenus().add(file);
        MenuItem exitMenuItem = new MenuItem("Exit");
        file.getItems().add(exitMenuItem);
        exitMenuItem.setOnAction(actionEvent -> System.exit(0));
        primaryStage.setOnCloseRequest(e -> System.exit(0));
                        
        //play button
        Button playBtn = new Button();
        playBtn.setText("Play Scale");
        playBtn.setStyle("-fx-base: #b6e7c9;");
        playBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            /**
             * Handles the start and gets a note from the user, and starts the MidiPlayer using sequence. 
             * @param event 
             */
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Starting Note");
                dialog.setHeaderText("Please enter a note (0-115)");

                //get result, parse it into an int in a roundabout way, then play scale once its had
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    String stringResult = result.toString();
                    stringResult = stringResult.substring(9, stringResult.length()-1);
                    startingNote = Integer.parseInt(stringResult); 
                    stopScale(sequence);
                    clearScale(sequence);
                    playScale(sequence, startingNote);
                }
            }
        });

        //stop button
        Button stopBtn = new Button();
        stopBtn.setText("Stop Playing");
        stopBtn.setStyle("-fx-base: #eda6a6;");
        stopBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            /**
             * Stops and Clears Scale on Stop Button trigger
             * @param event 
             */
            @Override
            public void handle(ActionEvent event) {
                stopScale(sequence);
                clearScale(sequence);
            }
        });
        
        //create layout
        HBox hbox = new HBox();
        hbox.getChildren().addAll(playBtn, stopBtn);
        hbox.setSpacing(10);
        hbox.setCenterShape(true);
        hbox.setAlignment(Pos.CENTER);
        
        //Overhead for showing screen
        BorderPane root = new BorderPane();
        
        root.setTop(menuBar);
        root.setCenter(hbox);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Scale Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Stops the current MidiPlayer sequence
     * @param sequence 
     */
    public void stopScale(MidiPlayer sequence) {
        sequence.stop();
    }
    
    /**
     * Clears the current MidiPlayer sequence 
     * @param sequence 
     */
    public void clearScale(MidiPlayer sequence) {
        sequence.clear();
    }
    
    /**
     * Plays a scale from the MidiPlayer that starts at startingNote
     * and continues for 8 pitches up, and 8 pitches down. 
     * @param sequence
     * @param startingNote 
     */
    public void playScale(MidiPlayer sequence, int startingNote) {     
        for(int i=1; i<9; i++)
        {
            sequence.addNote(startingNote, 100, i, 1,
                        1, 1);
            startingNote = startingNote + 1;
        }

        startingNote = startingNote - 1;
        for(int i=10; i<18; i++)
        {
            sequence.addNote(startingNote, 100, i, 1,
                        1, 1);
            startingNote = startingNote - 1;
        }
            sequence.play();
    }
    
    /**
     * Starts the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}