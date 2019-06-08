package sample;

import java.io.*;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.*;
import javafx.scene.text.Font;

/**
 * The MainMenuButton class.
 *
 * @author Seyone Chithrananda
 * @version 1
 */

public class MainMenuButton extends Button {
    private final String BTN_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/pressedbutton.png');";
    private final String BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/button.png');";
    private int height;
    private String buttonText;

    public MainMenuButton(String text, int w, int h, int f) {
        height = h;
        buttonText = text;
        setText(buttonText);
        setFont(Font.font("verdana", f));
        setMinWidth(w);
        setMinHeight(h);
        setMaxWidth(w);
        setMaxHeight(h);
        setStyle(BTN_FREE_STYLE);
        listeners();
    }

    private void setPressedStyle() {
        setStyle(BTN_PRESSED_STYLE);
        setPrefHeight(height - 4);
        setLayoutY(getLayoutY() + 4);
    }

    public String getButtonText()
    {
        return buttonText;
    }

    /**
     * Sets the style of the free button.
     */
    private void setFreeStyle() {
        setStyle(BTN_FREE_STYLE);
        setPrefHeight(height);
        setLayoutY(getLayoutY() - 4);
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
                setEffect(new DropShadow());
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

