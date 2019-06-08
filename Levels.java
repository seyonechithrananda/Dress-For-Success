package sample;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import sun.plugin.javascript.navig.Anchor;

/**
 * The Levels class.
 *
 * @author Seyone Chithrananda
 * @version 1
 */

public class Levels {

    private AnchorPane layout;
    private MainMenuButton level1,level2,level3,learn;

    public Scene mainWindow() {
        layout = new AnchorPane();
        layout.setPadding(new Insets(10, 10, 100, 10));

        addButtons();


        BackgroundImage background;
        background = new BackgroundImage(new Image("/Backgrounds/levels.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layout.setBackground(new Background(background));
        return new Scene(layout, 1000, 750);

    }

    public void addButtons() {
        learn = new MainMenuButton("Learn", 190, 49, 23);
        learn.setLayoutX(400);
        learn.setLayoutY(260);
        layout.getChildren().add(learn);

        level1 = new MainMenuButton("Level 1", 190, 49, 23);
        level1.setLayoutX(400);
        level1.setLayoutY(335);
        layout.getChildren().add(level1);

        level2 = new MainMenuButton("Level 2", 190, 49, 23);
        level2.setLayoutX(400);
        level2.setLayoutY(410);
        layout.getChildren().add(level2);

        level3 = new MainMenuButton("Level 3", 190, 49, 23);
        level3.setLayoutX(400);
        level3.setLayoutY(485);
        layout.getChildren().add(level3);
    }

    public MainMenuButton getLearnButton()
    { return learn;}

    public MainMenuButton getLevelOneButton()
    { return level1;}

    public MainMenuButton getLevelTwoButton()
    { return level2;}

    public MainMenuButton getLevelThreeButton()
    { return level3;}
}
