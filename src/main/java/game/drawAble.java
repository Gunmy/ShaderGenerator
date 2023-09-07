package game;

public class drawAble {
    protected double x, y, w, h;

    public drawAble(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public double calcDist (camera cam) {
        return Math.sqrt(Math.pow(x-cam.x(), 2)+Math.pow(y-cam.y(), 2));
    }

    public double calcRoundness (camera cam) {
        double dist = calcDist(cam);

        if (getRendX(cam) < cam.mx()-cam.width()/2 || getRendX(cam) > cam.mx()+cam.width()/2 || getRendY(cam) < cam.my()-cam.height()/2 || getRendY(cam) > cam.my()+cam.height()/2) return 2;

        if (dist < cam.rd()) {return 0;}
        if (dist >= cam.rd()) {return (dist-cam.rd()/2)/cam.rd();}

        return 0;
    }

    public void draw(imgDict dict, camera cam) {
        drawSpecial(dict, getRendX(cam), getRendY(cam), w*cam.tW(), h*cam.tH(), calcRoundness(cam));
    }

    public double getRendX(camera cam) {return (x-cam.x())*cam.tW()+cam.mx();} 
    public double getRendY(camera cam) {return (y-cam.y())*cam.tH()+cam.my();} 


    public void drawSpecial(imgDict dict, double rendx, double rendy, double rendw, double rendh, double roundNess) {
        //dict.drawImg(px, py, pw, ph, rendx, rendy, rendw, rendh, 0);

    }



}
