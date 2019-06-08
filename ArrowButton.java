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

public class ArrowButton extends Button {
    private String BTN_PRESSED_STYLE;
    private String BTN_FREE_STYLE;
    private int height;

    public ArrowButton(String s) {
        int h = 150;
        int w = 200;
        height = h;
        setMinWidth(w);
        setMinHeight(h);
        setMaxWidth(w);
        setMaxHeight(h);
        if(s.equals("left"))
        {
            BTN_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/pressed-left-arrow.png');";
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/unpressed-left-button.png');";
        }
        else if(s.equals("right"))
        {
            BTN_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/pressed-right-arrow.png');";
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/unpressed-right-arrow.png');";
        }
        setStyle(BTN_FREE_STYLE);
        listeners();
    }

    private void setPressedStyle() {
        setStyle(BTN_PRESSED_STYLE);
        setPrefHeight(height - 4);
        setLayoutY(getLayoutY() + 4);
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

