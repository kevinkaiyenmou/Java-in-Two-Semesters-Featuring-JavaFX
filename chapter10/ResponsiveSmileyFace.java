import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;

public class ResponsiveSmileyFace extends Application {
    final static int FACE_X = 125, FACE_Y = 125, FACE_RADIUS = 80, FACE_EYE_LEFT_X = 86, FACE_EYE_Y = 100, FACE_EYE_RADIUS = 10,
    FACE_EYE_RIGHT_X = FACE_X + (FACE_X - FACE_EYE_LEFT_X), MOUTH_WIDTH = 25, radiusX = 45, radiusY = 35;

    private static boolean captionSizeTooLarge(Text captionToCheck, Scene sceneToCheck, Circle faceToCheck){
        return captionToCheck.getLayoutBounds().getWidth() > sceneToCheck.getWidth() || captionToCheck.getLayoutBounds().getHeight() > sceneToCheck.getHeight() - faceToCheck.getLayoutBounds().getHeight();
    }
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
        final Arc mouth = new Arc(FACE_X, FACE_X + MOUTH_WIDTH, radiusX, radiusY, 0, -180);
        mouth.setFill(Color.YELLOW);
        mouth.setStroke(Color.BLUE);
        mouth.setType(ArcType.OPEN);

        // create and configure the text
        final Text caption = new Text(FACE_RADIUS, FACE_RADIUS + FACE_Y + 35, "Smiley Face");
        caption.setFill(Color.BLUE);
        caption.setFont(Font.font("Verdana", 15));

        // create a group that holds all the features
        Group root = new Group(face, rightEye, leftEye, mouth, caption);

        // create and configure a new scene
        Scene scene = new Scene(root, 2 * FACE_X, 2 * FACE_Y + 25, Color.YELLOW);
        
        // How to listen resize event of Stage in JavaFX?
        // https://stackoverflow.com/a/38216917/1757756
        ChangeListener<Number> stageWidthListener = (observable, oldValue, newValue) -> {
            System.out.println("Stage height: " + stage.getHeight() + " Stage width: " + stage.getWidth());
            //'face' width and height
            //'rightEye' width and height
            //'leftEye' width and height
            //'mouth' width and height
            //'caption' positionx, positiony, font size
            Text captionWithNewFont = new Text(FACE_RADIUS, FACE_RADIUS + FACE_Y + 35, "Smiley Face");
            
            int newFaceRadius = face.getRadius() * newValue / oldValue; //bad operand types for binary operator '*' 
            //I'm pretty sure * isn't a binary operator though.
            //is only changing the radius okay?
            Circle newFace = new Circle(FACE_X, FACE_Y, newFaceRadius); //bad operand types for binary operator '*'
            
            newFace.
            double fontSize = caption.getFont().getSize() * (double)newValue.intValue()/(double)oldValue.intValue();

            for(int newAttemptValue = newValue.intValue();(newAttemptValue > 0) && (captionSizeTooLarge(captionWithNewFont,scene,face));newAttemptValue--){
                //test shrinking values for font size to see if they fit  
                newAttemptValue--;
                fontSize = caption.getFont().getSize() * (double)newAttemptValue/(double)oldValue.intValue();
                captionWithNewFont.setFont(Font.font("Verdana",fontSize));
            }
            captionWithNewFont = null;
            if(fontSize == 0){
                fontSize = 1;
            }
            caption.setFont(Font.font("Verdana",fontSize));
            
            // suppose program state 1 is (Width is OK, Height is OK), then we want
            // to find value of Font size such that caption.getLayoutBounds().getWidth() will grow/shrink by same percentage as newValue.intValue()/oldValue.intValue()
            //loop start by guessing newFontSize = oldFontSize * newValue.intValue()/oldValue.intValue()
            // fontSizeChangeRatio = captionWithNewFont.getLayoutBounds().getWidth() / captionWithOldFont.getLayoutBounds().getWidth()
            
            // suppose program state 2 is (Width is NOK, Height is OK), then width shrunk and we want
            //to find value of Font size such that caption.getLayoutBounds().getWidth() fits

            System.out.println("Caption height: " + caption.getLayoutBounds().getHeight() + " Caption width: " + caption.getLayoutBounds().getWidth() + " Caption font: " + caption.getFont());
            // not needed: 'scene' width and height
        };
        ChangeListener<Number> stageHeightListener = (observable, oldValue, newValue) -> {
            System.out.println("Stage height: " + stage.getHeight() + " Stage width: " + stage.getWidth());
            //'face' width and height
            //'rightEye' width and height
            //'leftEye' width and height
            //'mouth' width and height
            //'caption' positionx, positiony, font size
            
            Text captionWithNewFont = new Text(FACE_RADIUS, FACE_RADIUS + FACE_Y + 35, "Smiley Face");

            int newFaceRadius = face.getRadius() * newValue / oldValue; //bad operand types for binary operator '*'
            Circle  = new Circle(FACE_X, FACE_Y, newFaceRadius);
            
            double fontSize = (double)newValue.intValue() - (double)face.getLayoutBounds().getHeight();
            for(int newAttemptValue = newValue.intValue();(newAttemptValue > 0) && (captionSizeTooLarge(captionWithNewFont,scene,face));newAttemptValue--){
                //test shrinking values for font size to see if they fit
                newAttemptValue--;
                fontSize = caption.getFont().getSize() * (double)newAttemptValue/(double)oldValue.intValue();
                captionWithNewFont.setFont(Font.font("Verdana",fontSize));
            }
            captionWithNewFont = null;
            if(fontSize < 1){
                fontSize = 1;
            }
            caption.setFont(Font.font("Verdana",fontSize));
            
            System.out.println("Caption height: " + caption.getLayoutBounds().getHeight() + " Caption width: " + caption.getLayoutBounds().getWidth() + " Caption font: " + caption.getFont());
            // not needed: 'scene' width and height

            
        };
        // add the scene to the stage, then set the title
        stage.setScene(scene);
        stage.setTitle("Smiley Face");
        // show the stage
        stage.show();
        stage.widthProperty().addListener(stageWidthListener);
        stage.heightProperty().addListener(stageHeightListener);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
