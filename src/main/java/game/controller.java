package game;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.PixelFormat;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import javafx.scene.input.MouseEvent;


public class controller {
    @FXML private AnchorPane Pane;

    RCanvas gameContainer = new RCanvas(1000, 1000);

    GraphicsContext gc = gameContainer.getGraphicsContext2D();
    imgDict dict = new imgDict(gc);


    @FXML private void mouseClick (MouseEvent e) {

        if (dragging) {
            dragging = false;
                for (scene sc : getCurrentScene()) {sc.mouseDragEnd();}
        } else {
            for (scene sc : getCurrentScene()) {sc.mouseClick();}
        }
    }

    @FXML private void mouseMove (MouseEvent e) {
        mousex = e.getSceneX();
        mousey = e.getSceneY();
        for (scene sc : getCurrentScene()) {sc.mouseMove(mousex, mousey);}
    }


    boolean dragging = false;
    @FXML private void mouseDrag (MouseEvent e) {
        for (scene sc : getCurrentScene()) {sc.mouseMove(e.getSceneX(), e.getSceneY());}

        if (dragging == false) {
            dragging = true;
            for (scene sc : getCurrentScene()) {sc.mouseDragStart();}
        } else {
            for (scene sc : getCurrentScene()) {sc.mouseDrag();}
        }
    }


    deltaTime deltaT = new deltaTime();  



    @FXML private void keyPressed (KeyEvent e) {
             if (e.getCode() == KeyCode.W) {} 
        else if (e.getCode() == KeyCode.S) {} 
        else if (e.getCode() == KeyCode.A) {} 
        else if (e.getCode() == KeyCode.D) {}
        else if (e.getCode() == KeyCode.O) {for (scene sc : getCurrentScene()) {sc.oPress();}}
        else if (e.getCode() == KeyCode.P) {for (scene sc : getCurrentScene()) {sc.pPress();}}
        else if (e.getCode() == KeyCode.SPACE) {}
    }
    

    @FXML private void keyReleased (KeyEvent e) {
             if (e.getCode() == KeyCode.W) {} 
        else if (e.getCode() == KeyCode.S) {}
        else if (e.getCode() == KeyCode.A) {}
        else if (e.getCode() == KeyCode.D) {}
    }

    double mousex;
    double mousey;

    scene scene1 = new gameScene(dict, 400,400, 400, 400);
    scene scene2 = new gameScene(dict, 600, 100, 300, 300);

    public List<scene> getCurrentScene () {
        List<scene> scenes = new ArrayList<scene>();
        //Add scenes you want shown, could be expanded to show different
        //at different states
        scenes.add(this.scene1);
        scenes.add(this.scene2);

        //scenes.add(this.scene2);
        return scenes;
    }

    @FXML protected void initialize () {
        //Makes the game-container able to recieve inputs
        gameContainer.setVisible(true);
        gameContainer.setFocusTraversable(true);
        Pane.getChildren().add(gameContainer);
        gameContainer.setViewOrder(1);
        gameContainer.resize(Pane.getWidth(), Pane.getHeight());

        //Loop
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(40), e -> {
            gameContainer.resize(Pane.getWidth(), Pane.getHeight());
            gc.clearRect(0, 0, Pane.getWidth(), Pane.getHeight());

            deltaT.next();

            for (scene drawScene : getCurrentScene()) {
                drawScene.update(deltaT.getSeconds());
                drawScene.draw();
            }

        }));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();   

    }
}
