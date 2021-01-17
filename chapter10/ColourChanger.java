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
        Group root = new Group();
        final Scene scene = new Scene(root, 500, 500, Color.WHITE);
        
        final Button BLUEBUTTON = new Button("Blue background");
        final Button REDBUTTON = new Button("Red background");
        
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(BLUEBUTTON, REDBUTTON);
        root.getChildren().add(buttonBox);
        stage.setScene(scene);
        stage.setTitle("Colour Changer");
        stage.show();

        // define the method that will handle the button click for BLUEBUTTON here
        EventHandler<ActionEvent> bluePressed = (event) -> {
            System.out.println("Blue button pressed " + (++clicked) +" times.");
            scene.setFill(Color.BLUE);
        };
        BLUEBUTTON.addEventHandler(ActionEvent.ANY, bluePressed);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
