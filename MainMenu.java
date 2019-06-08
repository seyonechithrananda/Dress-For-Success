package sample;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.application.Platform;
import javafx.scene.image.Image;
import java.awt.*;

/**
 * The MainMenu class.
 *
 * @author Seyone Chithrananda
 * @version 1
 */


public class MainMenu {

    private AnchorPane layout1;
    private LevelButtons playButton, scoreButton, instructionsButton, exitButton;

    public Scene menuWindow ()
    {
        System.out.println("warriors in 7");

        layout1 = new AnchorPane();
        layout1.setPadding(new Insets(10, 10, 100, 10));

        playButton = new LevelButtons("play");
        playButton.setLayoutX(463);
        playButton.setLayoutY(89);
        layout1.getChildren().add(playButton);

        scoreButton = new LevelButtons("scores");
        scoreButton.setLayoutX(743);
        scoreButton.setLayoutY(98);
        layout1.getChildren().add(scoreButton);

        instructionsButton = new LevelButtons("instructions");
        instructionsButton.setLayoutX(397);
        instructionsButton.setLayoutY(498);
        layout1.getChildren().add(instructionsButton);

        exitButton = new LevelButtons("exit");
        exitButton.setLayoutX(720);
        exitButton.setLayoutY(471);
        layout1.getChildren().add(exitButton);

        BackgroundImage background;
        background = new BackgroundImage(new Image("/Backgrounds/mainmenu.png", 1002,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layout1.setBackground(new Background(background));

        System.out.println("warriors in 6");

        return new Scene(layout1, 1000, 750);

    }


    public LevelButtons getPlayButton (){
        return playButton;
    }

    public LevelButtons getExitButton (){
        return exitButton;
    }

    public LevelButtons getInstructionsButton (){
        return instructionsButton;
    }

    public LevelButtons getScoreButton(){
        return scoreButton;
    }

}
