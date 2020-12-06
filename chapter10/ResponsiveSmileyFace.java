import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ResponsiveSmileyFace extends Application {
    final static double FACE_X = 125f, FACE_Y = 125f, FACE_RADIUS = 80f, FACE_EYE_LEFT_X = 86f, FACE_EYE_Y = 100f, FACE_EYE_RADIUS = 10f,
    FACE_EYE_RIGHT_X = FACE_X + (FACE_X - FACE_EYE_LEFT_X), SMILE_RADIUS_X = 45f, SMILE_RADIUS_Y = 35f,
    SCENE_HEIGHT = 2f * FACE_Y + 25f, SCENE_WIDTH = 2 * FACE_X, FONT_HEIGHT = 15f, CAPTION_X = FACE_RADIUS,
    CAPTION_Y = FACE_RADIUS + FACE_Y + 35f, ORIG_FACE_HRATIO = (FACE_RADIUS / SCENE_HEIGHT), ORIG_FACE_WRATIO = (FACE_RADIUS / SCENE_WIDTH), 
    ORIG_EYE_HORIZ_RATIO = (FACE_X - FACE_EYE_LEFT_X) / FACE_RADIUS, ORIG_EYE_VERT_RATIO = (FACE_Y - FACE_EYE_Y) / FACE_RADIUS, 
    EYE_TO_FACE_RADIUS_RATIO = FACE_EYE_RADIUS / FACE_RADIUS, MOUTH_TO_FACE_RADIUS_X_RATIO = SMILE_RADIUS_X / FACE_RADIUS, 
    MOUTH_TO_FACE_RADIUS_Y_RATIO = SMILE_RADIUS_Y / FACE_RADIUS, FONT_TO_FACE_RATIO = FONT_HEIGHT / FACE_RADIUS;


    public void start(Stage stage) {

        // create and configure the main circle for the face
        final Circle face = new Circle(FACE_X, FACE_Y, FACE_RADIUS);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.RED);

        // create and configure the circle for the right eye
        final Circle leftEye = new Circle(FACE_EYE_LEFT_X, FACE_EYE_Y, FACE_EYE_RADIUS);
        leftEye.setFill(Color.YELLOW);
        leftEye.setStroke(Color.BLUE);

        // create and configure the circle for the left eye
        final Circle rightEye = new Circle(FACE_EYE_RIGHT_X, FACE_EYE_Y, FACE_EYE_RADIUS);
        rightEye.setFill(Color.YELLOW);
        rightEye.setStroke(Color.BLUE);

        // create and configure a smiling mouth
        final Arc mouth = new Arc(FACE_X, FACE_Y + (FACE_RADIUS - SMILE_RADIUS_Y)/2, SMILE_RADIUS_X, SMILE_RADIUS_Y, 0, -180);
        mouth.setFill(Color.YELLOW);
        mouth.setStroke(Color.BLUE);
        mouth.setType(ArcType.OPEN);

        // create and configure the text
        final Text caption = new Text( CAPTION_X, CAPTION_Y , "Smiley Face");
        caption.setFill(Color.BLUE);
        caption.setFont(Font.font("Verdana", FONT_HEIGHT));
        caption.setTextAlignment(TextAlignment.CENTER);

        // create a group that holds all the features
        Group mainGroup = new Group(face, rightEye, leftEye, mouth);

        StackPane faceCaption = new StackPane();
        faceCaption.getChildren().addAll(mainGroup, caption);
        StackPane.setAlignment(mainGroup,Pos.CENTER);
        StackPane.setAlignment(caption, Pos.BOTTOM_CENTER);
        // create and configure a new scene
        Scene scene = new Scene(faceCaption, SCENE_WIDTH, SCENE_HEIGHT, Color.YELLOW);
        
        // How to listen resize event of Stage in JavaFX?
        // https://stackoverflow.com/a/38216917/1757756
        ChangeListener<Number> stageListener = (observable, oldValue, newValue) -> {
            System.out.println("Stage height: " + stage.getHeight() + " Stage width: " + stage.getWidth());
            double newFaceRadius = stage.getWidth() > stage.getHeight() ? stage.getHeight() * ORIG_FACE_HRATIO : stage.getWidth() * ORIG_FACE_WRATIO; 
            /** Line above is equivalent to:
             * 
             * double newFaceRadius;
             * if(stage.getWidth() > stage.getHeight()) {
             *  newFaceRadius = stage.getHeight() * FACE_;
             * } else {
             *  stage.getWidth() * FACE_
             * }
            */
            double newFaceX = stage.getWidth()/2;
            double newFaceY = stage.getHeight()/2;
            leftEye.setCenterX(newFaceX - newFaceRadius * ORIG_EYE_HORIZ_RATIO); // newFaceCentreX - ΔX
            leftEye.setCenterY(newFaceY - newFaceRadius * ORIG_EYE_VERT_RATIO); // newFaceCentreY - ΔY
            leftEye.setRadius(EYE_TO_FACE_RADIUS_RATIO * newFaceRadius);

            rightEye.setCenterY(newFaceY - newFaceRadius * ORIG_EYE_VERT_RATIO);
            rightEye.setCenterX(newFaceX + ORIG_EYE_HORIZ_RATIO * newFaceRadius);
            rightEye.setRadius(EYE_TO_FACE_RADIUS_RATIO * newFaceRadius);
            
            
            mouth.setRadiusX(MOUTH_TO_FACE_RADIUS_X_RATIO * newFaceRadius); 
            mouth.setRadiusY(MOUTH_TO_FACE_RADIUS_Y_RATIO * newFaceRadius);
            mouth.setCenterX(newFaceX);
            mouth.setCenterY(newFaceY + (newFaceRadius - mouth.getRadiusY())/2);
            face.setRadius(newFaceRadius);
            face.setCenterX(newFaceX);
            face.setCenterY(newFaceY);

            double fontSize = FONT_TO_FACE_RATIO * newFaceRadius;
            caption.setFont(Font.font("Verdana",fontSize));


            System.out.println("Caption height: " + caption.getLayoutBounds().getHeight() + " Caption width: " + caption.getLayoutBounds().getWidth() + " Caption font: " + caption.getFont());
        };
        
        // add the scene to the stage, then set the title
        stage.setScene(scene);
        stage.setTitle("Smiley Face");
        // show the stage
        stage.show();
        stage.widthProperty().addListener(stageListener);
        stage.heightProperty().addListener(stageListener);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
