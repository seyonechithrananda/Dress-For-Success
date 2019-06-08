package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;

import javafx.scene.text.*;
import javafx.scene.text.Text;

import javax.swing.*;
//import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The LevelTwo class for Dress for Success
 *
 * @author Uroosa Imtiaz
 * @version 1
 */


@SuppressWarnings("Duplicates")
public class LevelTwo{
    private AnchorPane layout;
    private String playerName, currentLevel;
    private MainMenuButton menu, level, next;
    ArrowButton left, right;
    private int levelTwoScore = 0;
    private int count = 0;
    private int done = 0;
    private String choice="";

    public Scene mainWindow()
    {
        layout = new AnchorPane();
        layout.setPadding(new Insets(10, 10, 100, 10));
        layout.setBackground(new Background(new BackgroundImage(new Image("Level 2/choose-one-level2.png", 1002,
                751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        selectButtons();
        menu = new MainMenuButton("Main Menu", 190, 49, 23);
        menu.setLayoutX(700);
        menu.setLayoutY(450);
        layout.getChildren().add(menu);
        menu.setVisible(false);
        level = new MainMenuButton ("Level 3", 190, 49, 23); // this will become level 2 when Uroosa adds her code
        level.setLayoutX(700);
        level.setLayoutY(525);
        layout.getChildren().add(level);
        level.setVisible(false);
        return new Scene (layout, 1000, 750);
    }

    public void selectButtons() // loads level1intro.png as intro, adds Continue button
    {
        LevelButtons rain= new LevelButtons("rain");
        rain.setLayoutX(138);
        rain.setLayoutY(220);
        layout.getChildren().add(rain);

        LevelButtons snow= new LevelButtons("snow");
        snow.setLayoutX(543);
        snow.setLayoutY(222);
        layout.getChildren().add(snow);

        LevelButtons sun= new LevelButtons("sun");
        sun.setLayoutX(340);
        sun.setLayoutY(480);
        layout.getChildren().add(sun);

        rain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(rain, snow, sun);
                choice = "rain";
                display();
            }
        });

        snow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(rain, snow, sun);
                choice="snow";
                display();
            }
        });

        sun.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(rain, snow, sun);
                choice="sun";
                display();
            }
        });
    }

    //order: rain, snow, sun
    public void back(int backg) {
        String background[] = {"Level 2/choose-rain-hat.png", "Level 2/choose-snow-hat.png", "Level 2/choose-sun-hat.png",
                                "Level 2/fchoose-rain-top.png", "Level 2/fchoose-snow-top.png", "Level 2/fchoose-sun-top.png",
                                "Level 2/dchoose-rain-pants.png", "Level 2/dchoose-snow-pants.png","Level 2/dchoose-sun-pants.png",
                                "Level 2/echoose-rain-boots.png", "Level 2/echoose-snow-shoes.png", "Level 2/echoose-sun-shoes.png"};
        layout.setBackground(new Background(new BackgroundImage(new Image(background[backg], 1002,
                751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
    }


    public void display()
    {
        back(0);
        arrowButtons();
        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                count--;
                if (done==0) {
                    if (count == -1)
                        count = 2;
                    else if (count > 2)
                        count = 0;
                }
                else if (done ==1) {
                    if (count < 3)
                        count = 5;
                    else if (count > 5)
                        count = 3;
                }
                else if (done==2){
                    if (count<6)
                        count = 8;
                    else if (count>8)
                        count =6;
                }
                else if (done==3)
                {
                    if (count<9)
                        count=11;
                    else if (count>11)
                        count = 9;
                }
                back(count);
            }
        });

        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                count++;
                if (done==0) {
                    if (count == -1)
                        count = 2;
                    else if (count > 2)
                        count = 0;
                }
                else if (done ==1) {
                    if (count < 3)
                        count = 5;
                    else if (count > 5)
                        count = 3;
                }
                else if (done==2){
                    if (count<6)
                        count = 8;
                    else if (count>8)
                        count =6;
                }
                else if (done==3)
                {
                    if (count<9)
                        count=11;
                    else if (count>11)
                        count = 9;
                }
                back(count);
            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scoreCalculate();
                done++;
                if (done == 1)
                {
                    count =3;
                    back(count);
                }
                else if (done == 2) {
                count =6;
                back(count);
                }
                else if (done ==3)
                {
                    count = 9;
                    back(count);
                }
                else if (done==4)
                {
                    layout.getChildren().removeAll(next,left,right);
                    endScreen();
                }
            }
        });
    }

    public void arrowButtons()
    {
        left= new ArrowButton("left");
        left.setLayoutX(50);
        left.setLayoutY(390);
        layout.getChildren().add(left);

        right= new ArrowButton("right");
        right.setLayoutX(755);
        right.setLayoutY(390);
        layout.getChildren().add(right);

        next = new MainMenuButton("Next", 190, 50, 23);
        next.setLayoutX(778);
        next.setLayoutY(638);
        layout.getChildren().add(next);
    }

    public void scoreCalculate()
    {
        if (choice.equals("rain"))
        {
            if (done==0 && count==0)
                levelTwoScore++;
            else if (done==1 && count==3)
                levelTwoScore++;
            else if (done==2 && count==6)
                levelTwoScore++;
            else if (done==3 && count==9)
                levelTwoScore++;
        }
        else if (choice.equals("snow"))
        {
            if (done==0 && count==1)
                levelTwoScore++;
            else if (done==1 && count==4)
                levelTwoScore++;
            else if (done==2 && count==7)
                levelTwoScore++;
            else if (done==3 && count==10)
                levelTwoScore++;
        }
        else if (choice.equals("sun"))
        {
            if (done==0 && count==2)
                levelTwoScore++;
            else if (done==1 && count==5)
                levelTwoScore++;
            else if (done==2 && count==8)
                levelTwoScore++;
            else if (done==3 && count==11)
                levelTwoScore++;
        }
    }

    public void endScreen()
    {
        if (choice.equals("rain"))
        {
            layout.setBackground(new Background(new BackgroundImage(new Image("Level 2/score-rain.png", 1002,
                    751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        }
        else if (choice.equals("snow"))
        {
            layout.setBackground(new Background(new BackgroundImage(new Image("Level 2/score-snow.png", 1002,
                    751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        }
        else if (choice.equals("sun"))
        {
            layout.setBackground(new Background(new BackgroundImage(new Image("Level 2/score-sun.png", 1002,
                    751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        }

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text t = new Text();
        t.setEffect(ds);
        t.setCache(true);
        t.setX(550.0f);
        if (choice.equals("snow") || choice.equals("sun"))
        {t.setY(706.0f);
        }
        else
            t.setY(725.0f);
        t.setFill(Color.RED);
        t.setText(levelTwoScore*25+"");
        t.setFont(Font.font(null, FontWeight.BOLD, 130));
        layout.getChildren().add(t);
        level.setVisible(true);
        menu.setVisible(true);
        levelTwoScore=0;
        done = 0;
        count=0;
    }


    public MainMenuButton getMainMenuButton()
    {
        return menu;
    }

    public MainMenuButton getLevel3Button()
    {
        return level;
    }
}