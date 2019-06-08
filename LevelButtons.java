package sample;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.*;

/**
 * The MainMenuButton class.
 *
 * @author Seyone Chithrananda
 * @version 1
 */

public class LevelButtons extends Button {
    private String BTN_FREE_STYLE;
    private String BTN_PRESSED_STYLE;
    private String choice;

    private int height;

    public LevelButtons(String s) {
        choice=s;
        int h =0;
        int w=0;

        if(s.equals("rain"))
        {
            h = 200;
            w = 317;
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/rain-button.png');";
            BTN_PRESSED_STYLE = BTN_FREE_STYLE;
        }
        else if(s.equals("snow"))
        {
            h = 199;
            w = 318;
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/snow-button.png');";
            BTN_PRESSED_STYLE = BTN_FREE_STYLE;
        }
        else if(s.equals("sun"))
        {
            h = 199;
            w = 318;
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/sun-button.png');";
            BTN_PRESSED_STYLE = BTN_FREE_STYLE;
        }
        else if(s.equals("swim"))
        {
            h = 209;
            w = 353;
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/BAckgrounds/beach-button.png');";
            BTN_PRESSED_STYLE = BTN_FREE_STYLE;
        }
        else if(s.equals("hockey"))
        {
            h = 209;
            w = 354;
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/hockey-button.png');";
            BTN_PRESSED_STYLE = BTN_FREE_STYLE;
        }
        else if(s.equals("bike"))
        {
            h = 210;
            w = 353;
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/bike-button.png');";
            BTN_PRESSED_STYLE = BTN_FREE_STYLE;
        }
        else if(s.equals("job"))
        {
            h = 210;
            w = 353;
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/job-button.png');";
            BTN_PRESSED_STYLE = BTN_FREE_STYLE;
        }
        else if(s.equals("play"))
        {
            h = 90;
            w = 207;
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/play-button.png');";
            BTN_PRESSED_STYLE = BTN_FREE_STYLE;
        }
        else if(s.equals("scores"))
        {
            h = 106;
            w = 180;
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/score-button.png');";
            BTN_PRESSED_STYLE = BTN_FREE_STYLE;
        }
        else if(s.equals("instructions"))
        {
            h = 42;
            w = 228;
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/instru-button2.png');";
            BTN_PRESSED_STYLE = BTN_FREE_STYLE;
        }
        else if(s.equals("exit"))
        {
            h = 105;
            w = 205;
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/exit-button.png');";
            BTN_PRESSED_STYLE = BTN_FREE_STYLE;
        }
        height = h;
        setMinWidth(w);
        setMinHeight(h);
        setMaxWidth(w);
        setMaxHeight(h);
        setStyle(BTN_FREE_STYLE);
        listeners();
    }

    private void setPressedStyle() {
        if (!choice.equals("play")&&!choice.equals("scores")&&!choice.equals("exit")&&!choice.equals("instructions")) {
        setStyle(BTN_PRESSED_STYLE);
        setPrefHeight(height - 4);
        setLayoutY(getLayoutY() + 4);}
    }

    /**
     * Sets the style of the free button.
     */
    private void setFreeStyle() {
        if (!choice.equals("play")&&!choice.equals("scores")&&!choice.equals("exit")&&!choice.equals("instructions")) {
        setStyle(BTN_FREE_STYLE);
        setPrefHeight(height);
        setLayoutY(getLayoutY() - 4);}
    }

    /**
     * Adds the listener objects to the button.
     */
    private void listeners() {
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY))
                    setPressedStyle();
            }
        });

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY))
                    setFreeStyle();
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!choice.equals("play")&&!choice.equals("scores")&&!choice.equals("exit")&&!choice.equals("instructions")) {
                    setEffect(new DropShadow());
                }
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(null);
            }
        });
    }
}

