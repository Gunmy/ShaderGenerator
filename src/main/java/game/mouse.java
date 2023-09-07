package game;

public class mouse extends drawAble {

    public mouse() {
        super(0, 0, 1, 1);   
    }

    private double mousex, mousey;

    public void update (double mousex, double mousey) {
        this.mousex = mousex;
        this.mousey = mousey;
    }

    public double getMouseX () {return mousex;}
    public double getMouseY () {return mousey;}

    public void updateLocToCam(camera cam) {
        this.x = Math.floor(cam.x() + (getMouseX()-cam.mx())/cam.tW());
        this.y = Math.floor(cam.y() + (getMouseY()-cam.my())/cam.tH());
    }
    
    @Override
    public void drawSpecial(imgDict dict, double rendx, double rendy, double rendw, double rendh, double roundNess) {
        dict.drawImg(0, 0, 18, 18, rendx, rendy, rendw, rendh, roundNess);
    }

}   
