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
    
    @Override
    public void start(Stage primaryStage) {
        
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
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Starting Note");
                dialog.setHeaderText("Please enter a note (0-155)");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    System.out.println("Entered Note: " + result.toString());
                    String stringResult = result.toString();
                    stringResult = stringResult.substring(9, stringResult.length()-1);
                    startingNote = Integer.parseInt(stringResult); 
                    //playScale(startingNote);
                }
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
        hbox.setCenterShape(true);
        hbox.setAlignment(Pos.CENTER);
        
        BorderPane root = new BorderPane();
        
        root.setTop(menuBar);
        root.setCenter(hbox);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Scale Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void playScale(int startingNote) {
            
        MidiPlayer sequence = new MidiPlayer(2, 60);
     /**
     * 
     * A convenience method for adding notes to the composition.
     *
     * @param pitch      an integer from 0 to 127 giving the pitch
     * @param volume     an integer from 0 to 127 giving the volume
     * @param startTick  tells when the note is to start playing (in ticks)
     * @param duration   the number of ticks the note is to play
     * @param channel    an integer from 0 to 15; each channel typically
     *                      corresponds to a different instrument.  The default
     *                      instrument for all channels is the grand piano.
     * @param trackIndex an integer from 0 to 7 giving the track for the note
     * pitch, volume, startTick, duration,
                        channel, trackIndex
     */
        sequence.addNote(50, 100, 1, 1,
                        1, 1);
        sequence.addNote(51, 100, 2, 1,
                        1, 1);
        sequence.addNote(52, 100, 3, 1,
                        1, 1);
        sequence.addNote(53, 100, 4, 1,
                        1, 1);
        sequence.addNote(54, 100, 5, 1,
                        1, 1);
        sequence.addNote(55, 100, 6, 1,
                        1, 1);
        sequence.addNote(56, 100, 7, 1,
                        1, 1);        
        sequence.addNote(57, 100, 8, 1,
                        1, 1);
        
        sequence.addNote(57, 100, 10, 1,
                        1, 1);
        sequence.addNote(56, 100, 11, 1,
                        1, 1);
        sequence.addNote(55, 100, 12, 1,
                        1, 1);
        sequence.addNote(54, 100, 13, 1,
                        1, 1);
        sequence.addNote(53, 100, 14, 1,
                        1, 1);
        sequence.addNote(52, 100, 15, 1,
                        1, 1);
        sequence.addNote(51, 100, 16, 1,
                        1, 1);        
        sequence.addNote(50, 100, 17, 1,
                        1, 1);
        sequence.play();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}