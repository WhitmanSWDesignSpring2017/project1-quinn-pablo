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

    //TODO: Why does this field exist? 
    private static int startingNote;
    //TODO: Could this field be static, final?
    private MidiPlayer sequence = new MidiPlayer(2, 60);

    /**
     * Start: Handles the menu bar, buttons, exits, and events. 
     * @param primaryStage //TODO: What is it for?
     */
    @Override
    public void start(Stage primaryStage) {
        
        //create menu bar
        MenuBar menuBar = new MenuBar();
        //TODO: Is the next line necessary?
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Menu file = new Menu("File");
        menuBar.getMenus().add(file);
        MenuItem exitMenuItem = new MenuItem("Exit");
        file.getItems().add(exitMenuItem);
        exitMenuItem.setOnAction(actionEvent -> System.exit(0));
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        //TODO: Confusing that the above line is here, 
        //as it's not part of creating the menu bar
                        
        //play button
        Button playBtn = new Button();
        playBtn.setText("Play Scale");
        //NOTE: The below is ugly, but you'll fix it with CSS
        playBtn.setStyle("-fx-base: #b6e7c9;");
        //TODO: Is an anonymous inner class necessary?
        playBtn.setOnAction(new EventHandler<ActionEvent>() {
            //TODO: This is way too much code to nest inside another method.
            /**
             * Handles the start and gets a note from the user, and starts the MidiPlayer using sequence. 
             * @param event 
             */
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Starting Note");
                dialog.setHeaderText("Please enter a note (0-115)");
                //TODO: Set a default text input value

                //get result, parse it into an int in a roundabout way, then play scale once its had
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    //TODO: Why not just set startingNote to Integer.parseInt(result)?
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
        //TODO: See comments above
        Button stopBtn = new Button();
        stopBtn.setText("Stop Playing");
        stopBtn.setStyle("-fx-base: #eda6a6;");
        //TODO: Is an anonymous inner class necessary?
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
        //NOTE: Good choice
        BorderPane root = new BorderPane();

        root.setTop(menuBar);
        root.setCenter(hbox);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Scale Player");
        primaryStage.setScene(scene);
        primaryStage.show();

        //NOTE: This method is much too long.
    }
    
    
    /**
     * Stops the current MidiPlayer sequence
     * @param sequence //TODO: What is it?
     */
     //TODO: Why is this public?
    public void stopScale(MidiPlayer sequence) {
        //TODO: Why do you need to define a one line method?
        sequence.stop();
    }
    
    /**
     * Clears the current MidiPlayer sequence 
     * @param sequence 
     */
    public void clearScale(MidiPlayer sequence) {
        //TODO: See above
        sequence.clear();
    }
    
    /**
     * Plays a scale from the MidiPlayer that starts at startingNote
     * and continues for 8 pitches up, and 8 pitches down. 
     * @param sequence
     * @param startingNote 
     */
     //TODO: Why public?
    public void playScale(MidiPlayer sequence, int startingNote) {     
        //TODO: Fix this so it's a Do-Re-Mi scale
        //https://en.wikipedia.org/wiki/Solfège#Major
        //TODO: Replace magic numbers with constants
        //TODO: Fix indentation
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
