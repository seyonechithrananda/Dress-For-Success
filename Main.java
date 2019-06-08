package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;

/**
 * The Main (driver) class for Dress for Success
 *
 * @author Seyone Chithrananda
 * @version 1
 * Uroosa is very behind
 */

public class Main extends Application {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 750;
    static Stage mainWindow;
    Scene mainMenu, splashscreen, learnGame, levelSelector, levelOne, levelTwo, levelThree, menuScreen, backToLevelSelector;
    LevelTwo l2;
    LevelThree l3;
    private AnchorPane pane;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainWindow = primaryStage;
        primaryStage.setResizable(false);

        pane = new AnchorPane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.setMinSize(WIDTH, HEIGHT);
        pane.setMaxSize(WIDTH, HEIGHT);

        primaryStage.setTitle("Dress for Success");

        MainMenu main = new MainMenu();
        mainMenu = main.menuWindow();

        Splashscreen splash = new Splashscreen();
        splashscreen = splash.mainWindow();

        Learn learn = new Learn();
        learnGame = learn.mainWindow();

        Levels level = new Levels();
        levelSelector = level.mainWindow();

        LevelOne l1 = new LevelOne();
        levelOne = l1.mainWindow();

        l2 = new LevelTwo();
        levelTwo = l2.mainWindow();

        l3 = new LevelThree();
        levelThree = l3.mainWindow();


        // from level one to level selector
        /*Levels select = new Levels();
        backToLevelSelector = select.mainWindow();

        // from level one to main menu
        MainMenu menu = new MainMenu();
        menuScreen = menu.menuWindow(); */


        main.getPlayButton().setOnAction(e -> mainWindow.setScene(levelSelector));

        //main.getScoresButton().setOnAction(e ->mainWindow.setScene(learnGame));
        main.getExitButton().setOnAction(e ->mainWindow.close());
        learn.getMainMenuButton().setOnAction(e -> mainWindow.setScene(mainMenu));
        level.getLevelOneButton().setOnAction(event -> mainWindow.setScene(levelOne));
        level.getLevelTwoButton().setOnAction(event -> mainWindow.setScene(Level2()));
        level.getLevelThreeButton().setOnAction(event -> mainWindow.setScene(Level3()));
        level.getLearnButton().setOnAction(e ->mainWindow.setScene(learnGame));
        l2.getMainMenuButton().setOnAction(event-> mainWindow.setScene(mainMenu));
        l2.getLevel3Button().setOnAction(event-> mainWindow.setScene(Level3()));
        l3.getMainMenuButton().setOnAction(event-> mainWindow.setScene(mainMenu));
        l3.getLevelButton().setOnAction(event-> mainWindow.setScene(levelSelector));

        //l1.getLevelSelector().setOnAction(event -> mainWindow.setScene(backToLevelSelector));
        //l1.getMainMenuButton().setOnAction(e -> mainWindow.setScene(menuScreen));

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Platform.runLater(() -> mainWindow.setScene(mainMenu));
            }
        };
        //mainWindow.setScene(mainMenu);
        mainWindow.setScene(splashscreen);
        mainWindow.show();

        timer.schedule(task, 3000); // sets delay of 3000 before executing mainMenu scene in run
        mainWindow.show(); // shows mainMenu
    }

    //creates new scene to restart the level
    public Scene Level2()
    {
        l2 = new LevelTwo();
        levelTwo = l2.mainWindow();
        l2.getMainMenuButton().setOnAction(event-> mainWindow.setScene(mainMenu));
        Level3();
        l2.getLevel3Button().setOnAction(event-> mainWindow.setScene(levelThree));
        return levelTwo;
    }

    //creates new scene to restart the level
    public Scene Level3()
    {
        l3 = new LevelThree();
        levelThree = l3.mainWindow();
        l3.getMainMenuButton().setOnAction(event-> mainWindow.setScene(mainMenu));
        l3.getLevelButton().setOnAction(event-> mainWindow.setScene(levelSelector));
        return levelThree;
    }
    public static void main(String[] args) {
        launch(args);
    }
}