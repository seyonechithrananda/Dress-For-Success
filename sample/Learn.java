package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Learn {

private AnchorPane layout;
private BackgroundImage backgroundSun, backgroundSnow, backgroundRain;
private BackgroundImage[] learnBackground;
private int currentBackground;
private MainMenuButton home;


/**
 * The Learn class for Dress for Success
 *
 * @author Seyone Chithrananda
 * @version 1
 */

    public Scene mainWindow() {

        currentBackground = 0;

        layout = new AnchorPane();
        layout.setPadding(new Insets(10, 10, 100, 10));

        loadBackgrounds();
        layout.setBackground(new Background(learnBackground[currentBackground]));
        addButtons();

        /*
        BackgroundImage background;
        background = new BackgroundImage(new Image("/Backgrounds/levels.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layout.setBackground(new Background(background));
        */

        return new Scene(layout, 1000, 750);

    }

    public void loadBackgrounds() {

        learnBackground = new BackgroundImage[3];
        Image sun = new Image ("/Learn/1.png");
        Image snow = new Image ("/Learn/3.png");
        Image rain = new Image("/Learn/2.png");

        backgroundSun = new BackgroundImage(new Image("/Learn/1.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        backgroundSnow = new BackgroundImage(new Image("/Learn/3.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        backgroundRain = new BackgroundImage(new Image("/Learn/2.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        learnBackground[0] = backgroundSun;
        learnBackground[1] = backgroundSnow;
        learnBackground[2] = backgroundRain;
    }

    public void addButtons() {
        MainMenuButton next = new MainMenuButton("Next", 190, 49, 23);
        next.setLayoutX(750);
        next.setLayoutY(700);
        layout.getChildren().add(next);

        MainMenuButton back = new MainMenuButton("Back", 190, 49, 23);
        back.setLayoutX(60);
        back.setLayoutY(700);
        layout.getChildren().add(back);

        home = new MainMenuButton("Main Menu", 190, 49, 23);
        home.setLayoutX(405);
        home.setLayoutY(700);
        layout.getChildren().add(home);
       // home.setOnAction(event -> displayMainMenu());

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (currentBackground != learnBackground.length - 1) {
                    currentBackground++;
                } else {
                    currentBackground = 0;
                }
                layout.setBackground(new Background(learnBackground[currentBackground]));
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (currentBackground!=0) {
                    currentBackground--;
                }
                else
                {
                    currentBackground= learnBackground.length - 1;
                }
                layout.setBackground(new Background(learnBackground[currentBackground]));
            }
        });
    }

    public MainMenuButton getMainMenuButton (){
        return home;
    }

}
