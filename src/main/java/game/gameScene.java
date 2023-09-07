package game;

public class gameScene extends scene {

    public gameScene(game.imgDict imgDict, double midx, double midy, double width, double height) {
        super(imgDict, midx, midy, width, height);
    }
    

    public void wPress () {}
    public void sPress () {}
    public void aPress () {}
    public void dPress () {}

    public void wRelease () {}
    public void sRelease () {}
    public void aRelease () {}
    public void dRelease () {}

    double dragx, dragy;
    double dragmousex, dragmousey;
    public void mouseDragEnd() {
        System.out.println((dragmousex-dragmousex)/getCam().tW());
    }
    public void mouseDrag () {
        getCam().setx(dragx + (dragmousex-getMouseX())/getCam().tW());
        getCam().sety(dragy + (dragmousey-getMouseY())/getCam().tH());
    }
    public void mouseDragStart() {
        dragx = getCam().x(); 
        dragy = getCam().y(); 
        dragmousex = getMouseX(); 
        dragmousey = getMouseY();
    }


    public void oPress () {getCam().zoom(-1);}
    public void pPress () {getCam().zoom(1);}

    chunk test1 = new chunk(0, 0);
    chunk test2 = new chunk(0, 1);
    chunk test3 = new chunk(1, 0);
    chunk test4 = new chunk(1, 1);

    mouse mouse = new mouse();

    @Override
    public void sceneUpdate(double deltaT) {
        /* 
        double dx = (getMouseX()-getCam().mx())/getCam().tW();
        double dy = (getMouseY()-getCam().my())/getCam().tH();

        getCam().changeX(dx*0.03);
        getCam().changeY(dy*0.03);
        */

        mouse.update(getMouseX(), getMouseY());
        mouse.updateLocToCam(getCam());


    }

    @Override
    public void draw() {
        test1.draw(getDict(), getCam());
        test2.draw(getDict(), getCam());
        test3.draw(getDict(), getCam());
        test4.draw(getDict(), getCam());

        mouse.draw(getDict(), getCam());


        getCam().draw(getDict());
    }
}
