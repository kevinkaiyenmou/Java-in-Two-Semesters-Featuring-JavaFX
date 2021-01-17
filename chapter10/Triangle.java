import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Triangle extends Application {
    
    public void start(Stage stage) {
        final Line TOP = new Line(); //its been 3 weeks since I've last touched this I have no idea what is happening here - post winter break Kevin
        TOP.setStartX(100.0f);
        TOP.setStartY(70.0f);
        TOP.setEndX(400.0f);
        TOP.setEndY(250.0f);
        TOP.setStroke(Color.BLACK);

        final Line LEFT = new Line();
        LEFT.setStartX(100.0f);
        LEFT.setStartY(250.0f);
        LEFT.setEndX(100.0f);
        LEFT.setEndY(70.0f);
        LEFT.setStroke(Color.BLACK);

        final Line BOTTOM = new Line();
        BOTTOM.setStartX(400.0f);
        BOTTOM.setStartY(250.0f);
        BOTTOM.setEndX(100.0f);
        BOTTOM.setEndY(250.0f);
        BOTTOM.setStroke(Color.BLACK);

        Group triangleGroup = new Group(TOP, LEFT, BOTTOM);

        StackPane trianglePane = new StackPane();
        trianglePane.getChildren().addAll(triangleGroup);
        trianglePane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(trianglePane, 500, 500, Color.YELLOW); //something about triangleGroup causes InvocationTargetException when trying to run. Compiles just fine though.

        stage.setScene(scene);
        stage.setTitle("Triangle");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
