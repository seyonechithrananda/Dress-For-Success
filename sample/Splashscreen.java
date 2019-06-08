package sample;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * The Splashscreen class.
 *
 * @author Seyone Chithrananda
 * @version 1
 */

public class Splashscreen {

    public Scene mainWindow () throws IOException {
            /*
            Image image = new Image("/Backgrounds/logo.png");
            // /Users/seyonechithrananda/IdeaProjects/dress_for_success/src/Backgrounds
            ImageView logo = new ImageView(image);
            logo.setPreserveRatio(true);
            Group root = new Group(logo);
            VBox layout = new VBox();
            layout.getChildren().add(logo);
            root.getChildren().add(layout);
            logo.setFitHeight(400);
            logo.setFitWidth(700);
            logo.setLayoutX(150);
            logo.setLayoutY(175);
            System.out.println(logo.getLayoutX());
            System.out.println(logo.getLayoutY());
            FadeTransition ft = new FadeTransition(Duration.millis(3000), layout);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.setCycleCount(2);
            ft.setAutoReverse(true);
            ft.play();
            return new Scene (root, 1000, 750, Color.BLACK); */


            Image image = new Image("/Backgrounds/logo.png", 700, 400, false, true);

            // Setting the image view 1
            ImageView logo = new ImageView(image);

            Group root = new Group(logo);
            VBox layout = new VBox();
            layout.getChildren().add(logo);
            root.getChildren().add(logo);

            // Setting the position of the image
            logo.setX(150);
            logo.setY(175);

            // setting the fit height and width of the image view
            logo.setFitHeight(400);
            logo.setFitWidth(700);

            FadeTransition ft = new FadeTransition(Duration.millis(4000), logo);
            ft.setFromValue(2);
            ft.setToValue(0);
            ft.setAutoReverse(true);
            ft.play();
            ft.setCycleCount(1);

            return new Scene (root, 1000, 750, Color.BLACK);

    }

}
