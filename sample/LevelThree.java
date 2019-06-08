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
 * The LevelThree class for Dress for Success
 *
 * @author Uroosa Imtiaz
 * @version 1
 */


@SuppressWarnings("Duplicates")
public class LevelThree{
    private AnchorPane layout;
    private String playerName, currentLevel;
    private MainMenuButton menu, level, next;
    ArrowButton left, right;
    private int levelThreeScore = 0;
    private int count = 0;
    private int done = 0;
    private String choice="";

    public Scene mainWindow()
    {
        layout = new AnchorPane();
        layout.setPadding(new Insets(10, 10, 100, 10));
        layout.setBackground(new Background(new BackgroundImage(new Image("Level 3/choose-one.png", 1002,
                751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        menu = new MainMenuButton("Main Menu", 190, 49, 23);
        menu.setLayoutX(700);
        menu.setLayoutY(450);
        layout.getChildren().add(menu);
        menu.setVisible(false);
        level = new MainMenuButton ("Levels", 190, 49, 23); // this will become level 2 when Uroosa adds her code
        level.setLayoutX(700);
        level.setLayoutY(525);
        layout.getChildren().add(level);
        level.setVisible(false);
        selectButtons();
        return new Scene (layout, 1000, 750);
    }

    public void selectButtons() // loads level1intro.png as intro, adds Continue button
    {
        LevelButtons swim= new LevelButtons("swim");
        swim.setLayoutX(119);
        swim.setLayoutY(209);
        layout.getChildren().add(swim);

        LevelButtons bike= new LevelButtons("bike");
        bike.setLayoutX(530);
        bike.setLayoutY(209);
        layout.getChildren().add(bike);

        LevelButtons job = new LevelButtons("job");
        job.setLayoutX(530);
        job.setLayoutY(469);
        layout.getChildren().add(job);

        LevelButtons hockey= new LevelButtons("hockey");
        hockey.setLayoutX(119);
        hockey.setLayoutY(469);
        layout.getChildren().add(hockey);

        swim.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(swim,bike,hockey,job);
                choice = "swim";
                display();
            }
        });

        bike.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(swim,bike,hockey,job);
            choice = "bike";
            display();
            }
        });

        job.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            layout.getChildren().removeAll(swim,bike,hockey,job);
            choice = "job";
            display();
            }
        });

        hockey.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            layout.getChildren().removeAll(swim,bike,hockey,job);
            choice = "hockey";
            display();
        }
    });
    }

    //order: rain, snow, sun
    public void back(int backg) {
        String background[] = {"Level 3/cswim-hat.png", "Level 3/cbike-hat.png", "Level 3/cno-hat.png", "Level 3/chockey-hat.png",
                "Level 3/eswim-shirt.png", "Level 3/ebike-shirt.png", "Level 3/ejob-shirt.png", "Level 3/ehockey-shirt.png",
                "Level 3/bswim-bottom.png", "Level 3/bbike-bottom.png","Level 3/bjob-bottom.png", "Level 3/bhockey-bottom.png",
                "Level 3/dswim-shoes.png", "Level 3/dbike-shoes.png", "Level 3/djob-shoes.png", "Level 3/dhockey-shoes.png"};
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
                        count = 3;
                    else if (count > 3)
                        count = 0;
                }
                else if (done ==1) {
                    if (count < 4)
                        count = 7;
                    else if (count > 7)
                        count = 4;
                }
                else if (done==2){
                    if (count<8)
                        count = 11;
                    else if (count>11)
                        count =8;
                }
                else if (done==3)
                {
                    if (count<12)
                        count=15;
                    else if (count>15)
                        count = 12;
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
                        count = 3;
                    else if (count > 3)
                        count = 0;
                }
                else if (done ==1) {
                    if (count < 4)
                        count = 7;
                    else if (count > 7)
                        count = 4;
                }
                else if (done==2){
                    if (count<8)
                        count = 11;
                    else if (count>11)
                        count =8;
                }
                else if (done==3)
                {
                    if (count<12)
                        count=15;
                    else if (count>15)
                        count = 12;
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
                    count =4;
                    back(count);
                }
                else if (done == 2) {
                    count =8;
                    back(count);
                }
                else if (done ==3)
                {
                    count = 12;
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
        if (choice.equals("swim"))
        {
            if (done==0 && count==0)
                levelThreeScore++;
            else if (done==1 && count==4)
                levelThreeScore++;
            else if (done==2 && count==8)
                levelThreeScore++;
            else if (done==3 && count==12)
                levelThreeScore++;
        }
        else if (choice.equals("bike"))
        {
            if (done==0 && count==1)
                levelThreeScore++;
            else if (done==1 && count==5)
                levelThreeScore++;
            else if (done==2 && count==9)
                levelThreeScore++;
            else if (done==3 && count==13)
                levelThreeScore++;
        }
        else if (choice.equals("job"))
        {
            if (done==0 && count==2)
                levelThreeScore++;
            else if (done==1 && count==6)
                levelThreeScore++;
            else if (done==2 && count==10)
                levelThreeScore++;
            else if (done==3 && count==14)
                levelThreeScore++;
        }
        else if (choice.equals("hockey"))
        {
            if (done==0 && count==2)
                levelThreeScore++;
            else if (done==1 && count==7)
                levelThreeScore++;
            else if (done==2 && count==11)
                levelThreeScore++;
            else if (done==3 && count==15)
                levelThreeScore++;
        }
    }

    public void endScreen()
    {
        if (choice.equals("swim"))
        {
            layout.setBackground(new Background(new BackgroundImage(new Image("Level 3/fswim-score.png", 1002,
                    751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        }
        else if (choice.equals("bike"))
        {
            layout.setBackground(new Background(new BackgroundImage(new Image("Level 3/fbike-score.png", 1002,
                    751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        }
        else if (choice.equals("job"))
        {
            layout.setBackground(new Background(new BackgroundImage(new Image("Level 3/fjob-score.png", 1002,
                    751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        }
        else if (choice.equals("hockey"))
        {
            layout.setBackground(new Background(new BackgroundImage(new Image("Level 3/fhockey-score.png", 1002,
                    751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        }
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text t = new Text();
        t.setEffect(ds);
        t.setCache(true);
        t.setX(550.0f);
        t.setY(725.0f);
        t.setFill(Color.RED);
        t.setText(levelThreeScore*25+"");
        t.setFont(Font.font(null, FontWeight.BOLD, 130));
        layout.getChildren().add(t);
        menu.setVisible(true);
        level.setVisible(true);
        levelThreeScore=0;
        done = 0;
        count=0;
    }


    public MainMenuButton getMainMenuButton()
    {
        return menu;
    }

    public MainMenuButton getLevelButton()
    {
        return level;
    }
}