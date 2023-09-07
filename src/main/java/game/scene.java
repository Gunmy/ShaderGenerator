package game;

import java.util.Arrays;
import java.util.List;

public class scene {
    private camera camera;
    private imgDict imgDict;

    public imgDict getDict () {return this.imgDict;}

    private double midx, midy;

    public void mouseClick () {}

    public void mouseDragEnd() {}
    public void mouseDrag () {}
    public void mouseDragStart() {}


    public void wPress () {}
    public void sPress () {}
    public void aPress () {}
    public void dPress () {}

    public void oPress () {}
    public void pPress () {}


    public void wRelease () {}
    public void sRelease () {}
    public void aRelease () {}
    public void dRelease () {}


    double mousex, mousey;
    public void mouseMove (double mousex, double mousey) {this.mousex = mousex; this.mousey = mousey;}
    public double getMouseX() {return mousex;}
    public double getMouseY() {return mousey;}

    public camera getCam () {return this.camera;}


    public scene (imgDict imgDict, double midx, double midy, double width, double height) {
        this.imgDict = imgDict;
        camera = new camera(midx, midy, width, height);
    }
    

    public void update (double deltaTime) {
        sceneUpdate(deltaTime);
    }

    public void sceneUpdate (double deltaTime) {
        
    }

    public void draw () {

    }
}
