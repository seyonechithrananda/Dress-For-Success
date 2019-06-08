package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
//import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;

import javafx.scene.text.*;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The LevelOne class for Dress for Success
 *
 * @author Seyone Chithrananda
 * @version 1
 */


@SuppressWarnings("Duplicates")
public class LevelOne {
    private AnchorPane layout;
    private String playerName, currentLevel;
    private MainMenuButton optionA, optionB, optionC, continueButton, menu, level;

    private int levelOneScore = 0;
    private QuizQuestion q1, q2, q3;

    public Scene mainWindow()
    {
        layout = new AnchorPane();
      //  layout.setAlignment(Pos.BOTTOM_CENTER);
        layout.setPadding(new Insets(10, 10, 100, 10));

        introScreen();

        return new Scene (layout, 1000, 750);

    }

    public void introScreen() // loads level1intro.png as intro, adds Continue button
    {
        layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/level1intro.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        final TextField name = new TextField();
        name.setPromptText("Enter your username (maximum 15 letters):");
        name.setPrefColumnCount(15); // max size of username - 15 characters
        name.setPrefSize(100, 40);
        name.setMinWidth(200);
        name.setMaxWidth(200);
        name.setMinHeight(40);
        name.setMaxHeight(40);
        name.setLayoutX(420);
        name.setLayoutY(450);

        name.setOnAction(event -> playerName = name.getText());

        MainMenuButton enterBtn = new MainMenuButton("Enter", 190, 50, 23);
        enterBtn.setLayoutX(450);
        enterBtn.setLayoutY(520);
        enterBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (name.getText().length()!=0) {
                    playerName = name.getText();
                    layout.getChildren().removeAll(name, enterBtn);
                    questionOne();
                }
                else
                    name.setText("You didn't enter an username.");
            }
        });

        layout.getChildren().addAll(name, enterBtn);
    }

    public void questionOne()
    {
        q1 = new QuizQuestion("C");

        currentLevel= "1";

        layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/summerquestion.png",
                1000, 750, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        addQuestionButtons();

        optionA.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(optionA, optionB, optionC);
                if (optionA.getButtonText().equals(q1.getAnswer())) {
                    levelOneScore++;
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/summeranswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });


        optionB.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(optionA, optionB, optionC);
                if (optionB.getButtonText().equals(q1.getAnswer())) {
                    levelOneScore++;
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/summeranswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });


        optionC.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(optionA, optionB, optionC);
                if (optionC.getButtonText().equals(q1.getAnswer())) {
                    levelOneScore++;
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/summeranswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
                System.out.println("check this");
            }
        });

    }

    public void questionTwo()
    {
        q2 = new QuizQuestion("B");
        currentLevel= "2";

        System.out.println("");
        System.out.println("YOLO");

        layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/rain_question.png",
                1000, 750, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        addQuestionButtons();

        optionA.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                if (optionA.getButtonText().equals(q2.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/rainanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });


        optionB.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(optionA, optionB, optionC);
                if (optionB.getButtonText().equals(q2.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/rainanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });


        optionC.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                if (optionC.getButtonText().equals(q2.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/rainanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });
    }

    public void questionThree()
    {
        q3 = new QuizQuestion("A");
        currentLevel= "3";

        System.out.println("");
        System.out.println("YOLO");

        layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/snowquestion.png",
                1000, 750, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        addQuestionButtons();

        optionA.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                if (optionA.getButtonText().equals(q3.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/snowanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });


        optionB.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(optionA, optionB, optionC);
                if (optionB.getButtonText().equals(q3.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/snowanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });

        optionC.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                if (optionC.getButtonText().equals(q3.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/snowanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });



    }

    public void endScreen()
    {
        int totalQuestions = 3;
        final Font comicFont;
        if (levelOneScore/3 * 100 > 60) {
            layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/pass_message.png",
                    1000, 750, false, true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT)));
        }
        else {
            layout.setBackground(new Background(new BackgroundImage(new Image("/Level 1/fail_message.png",
                    1000, 750, false, true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT)));

        }


        String score = String.valueOf(levelOneScore);
        Text outputScore = new Text (score);

        /*
        try
        {
            comicFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("/Fonts/COMICFONT.TTF"));
            //comicFont = Font.loadFont(new FileInputStream(new File("/Fonts/COMICFONT.TTF")));
            outputScore.setFont(comicFont);
        }
        catch (IOException | FontFormatException e)
        {
            e.printStackTrace();
        }

        */
        addExitButtons();

    }


    public void addContinueButton() // adds continue button to answer screens
    {
        continueButton = new MainMenuButton("Continue", 190, 50, 23);
        continueButton.setLayoutX(400);
        continueButton.setLayoutY(650);
        layout.getChildren().add(continueButton);
        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().remove(continueButton);
                if (currentLevel.equals("1"))
                    questionTwo();
                else if (currentLevel.equals("2"))
                {
                    questionThree();
                }
                else
                {
                    endScreen();
                }
            }
        });

    }

    public void addQuestionButtons() // adds options for quiz (i.e: 'A', 'B', 'C')
    {
        optionA = new MainMenuButton("A", 190, 49, 23);
        optionA.setLayoutX(200);
        optionA.setLayoutY(600);
        layout.getChildren().add(optionA);

        optionB = new MainMenuButton("B", 190, 49, 23);
        optionB.setLayoutX(400);
        optionB.setLayoutY(600);
        layout.getChildren().add(optionB);

        optionC = new MainMenuButton("C", 190, 49, 23);
        optionC.setLayoutX(600);
        optionC.setLayoutY(600);
        layout.getChildren().add(optionC);

    }



    public void addExitButtons() // adds main menu + level selector buttons to screen
    {
        menu = new MainMenuButton("Main Menu", 190, 49, 23);
        menu.setLayoutX(300);
        menu.setLayoutY(650);
        layout.getChildren().add(menu);
        // menu.setOnAction(event -> displayMainMenu());

        level = new MainMenuButton ("Choose level", 190, 49, 23); // this will become level 2 when Uroosa adds her code
        level.setLayoutX(510);
        level.setLayoutY(650);
        layout.getChildren().add(level);

    }

    public MainMenuButton getMainMenuButton ()
    {
        return menu;
    }

    public MainMenuButton getLevelSelector ()
    {
        return level;
    }



}
