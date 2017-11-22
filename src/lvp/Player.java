package lvp;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Player extends Application {

    @Override
    public void start(Stage primaryStage) {
        boolean videoLoaded = false;
        primaryStage.setTitle("Layered Video Player");
        primaryStage.setResizable(false);

        Group root = new Group();
        Scene scene = new Scene(root, 720, 610);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open MP4 Video");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("mp4", "*.mp4"),
                new FileChooser.ExtensionFilter("flv", "*.flv"));
        File videoFile = fileChooser.showOpenDialog(primaryStage);

        if (videoFile != null) {
            videoLoaded = true;
        }

        if (videoLoaded) {
            String videoFilePath = videoFile.toURI().toASCIIString();

            // create media player
            Media media = new Media(videoFilePath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);

            MediaBar mediaControl = new MediaBar(mediaPlayer, primaryStage);
            scene.setRoot(mediaControl);

            root.getChildren().add(mediaView);
        } else {
            JOptionPane.showMessageDialog(null, "You must choose a file.", "Error", JOptionPane.ERROR_MESSAGE);
            primaryStage.hide();
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}