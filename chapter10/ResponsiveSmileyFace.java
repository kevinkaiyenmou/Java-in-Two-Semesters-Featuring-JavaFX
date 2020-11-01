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
    @Override
    final static int FACE_X = 125, FACE_Y = 125, FACE_RADIUS = 80, FACE_EYE_X = 86, FACE_EYE_Y = 100, FACE_EYE_RADIUS = 10;
    public void start(Stage stage) {


        // create and configure the main circle for the face
        Circle face = new Circle(FACE_X, FACE_Y, FACE_RADIUS);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.RED);

        // create and configure the circle for the right eye
        Circle rightEye = new Circle(FACE_EYE_X, FACE_EYE_Y, FACE_EYE_RADIUS);
        rightEye.setFill(Color.YELLOW);
        rightEye.setStroke(Color.BLUE);

        // create and configure the circle for the left eye
        Circle leftEye = new Circle(162, 100, 10);
        leftEye.setFill(Color.YELLOW);
        leftEye.setStroke(Color.BLUE);

        // create and configure a smiling mouth
        Arc mouth = new Arc(125, 150, 45, 35, 0, -180);
        mouth.setFill(Color.YELLOW);
        mouth.setStroke(Color.BLUE);
        mouth.setType(ArcType.OPEN);

        // create and configure the text
        Text caption = new Text(80, 240, "Smiley Face");
        caption.setFill(Color.BLUE);
        caption.setFont(Font.font("Verdana", 15));

        // create a group that holds all the features
        Group root = new Group(face, rightEye, leftEye, mouth, caption);

        // create and configure a new scene
        Scene scene = new Scene(root, 250, 275, Color.YELLOW);
        
        // How to listen resize event of Stage in JavaFX?
        // https://stackoverflow.com/a/38216917/1757756
        ChangeListener<Number> stageWidthListener = (observable, oldValue, newValue) -> {
            System.out.println("Stage height: " + stage.getHeight() + " Stage width: " + stage.getWidth());
            //'face' width and height
            //'rightEye' width and height
            //'leftEye' width and height
            //'mouth' width and height
            //'caption' positionx, positiony, font size
            Text captionWithNewFont = new Text()
            do{

            } while();
            double fontSize=caption.getFont() * newValue.intValue()/oldValue.intValue();
            if(captionWithNewFont.getLayoutBounds().getHeight() < scene.getHeight() - face.getHeight()){
                //Height is OK, there is enough height space in the stage to accomodate font size change
            }
            if(captionWithNewFont.getLayoutBounds().getWidth() < scene.getWidth() - face.getWidth()){
                //'Width is OK'  means there is enough width space in the stage to accomodate font size change
            }

            //'Height is NOK' means not enough stage height to accomodate font size change
            
            //'Width is NOK' means not enough stage width to accomodate font size change
            
            
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
            caption.setFont(Font.font(caption.getFont().getName(),caption.getFont().getSize()*1.0*newValue.intValue()/oldValue.intValue()));
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
