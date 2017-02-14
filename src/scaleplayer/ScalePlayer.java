/*
 * CS 300-A, 2017S
 */

package scaleplayer;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.*;
import javafx.fxml.FXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


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

    @Override
    public void start(Stage primaryStage) throws Exception {  
    try {
        AnchorPane page = FXMLLoader.load(ScalePlayer.class.getResource("ScalePlayer.fxml"));
        Scene scene = new Scene(page);
        primaryStage.setTitle("ScalePlayer");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e->System.exit(0));
        } catch (Exception ex) {
        }
    }    
    

    @FXML
    private MenuItem closeItem;

    @FXML
    private Button startButton;

    @FXML
    private Button closeButton;

    @FXML
    void handleCloseClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void handleStartClick(ActionEvent event) {

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

    @FXML
    void handleStopClick(ActionEvent event) {
       stopScale(sequence);
       clearScale(sequence);
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
