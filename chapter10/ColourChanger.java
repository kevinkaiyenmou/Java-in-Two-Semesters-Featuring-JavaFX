import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

//“Below you see an application called ColourChanger which produces the following graphic in which two buttons can be used to change the background colour: Write the code for this application.”

public class ColourChanger extends Application {
    static int clicked = 0;
    public void start(Stage stage) {
        final HBox buttonBox = new HBox(30);
        final Scene scene = new Scene(buttonBox, 500, 500, Color.WHITE);
        
        final Button blueButton = new Button("Blue background");
        final Button redButton = new Button("Red background");
        
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(blueButton, redButton);
        stage.setScene(scene);
        stage.setTitle("Colour Changer");
        stage.show();

        // define the method that will handle the button click for BLUEBUTTON here
        EventHandler<ActionEvent> bluePressed = (event) -> {
            System.out.println("Blue button pressed " + (++clicked) +" times.");
            System.out.println("'buttonBox' had an alignment of "+ buttonBox.getAlignment());
            scene.setFill(Color.BLUE);
        };
        blueButton.addEventHandler(ActionEvent.ANY, bluePressed);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
