package lvp;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Layer extends Application
{
    public Layer(Stage videoStage, String imageName)
    {
        Stage tripwireStage = new Stage(StageStyle.UNDECORATED);
        tripwireStage.initStyle(StageStyle.TRANSPARENT);
        tripwireStage.setTitle("Tripwire Layer");

        Group root = new Group();
        Scene scene = new Scene(root, 720, 610);

        Image tripwire = new Image(getClass().getResourceAsStream(imageName));
        ImageView imageView = new ImageView();
        imageView.setImage(tripwire);

        root.getChildren().add(imageView);
        scene.setFill(null);
        
        tripwireStage.setScene(scene);
        tripwireStage.initOwner(videoStage);
        
        //start(tripwireStage);
        tripwireStage.show();
    }

    @Override
    public void start(Stage primaryStage)
    {
        
    }
}