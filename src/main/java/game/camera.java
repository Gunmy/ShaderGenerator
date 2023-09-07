package game;

public class camera {
    double x=0, y=0, midx, midy, width, height;
    int tW=30, tH=30;

    scene scene;
    
    public camera (double midx, double midy, double width, double height) {
        this.midx = midx;
        this.midy = midy;
        this.width = width;
        this.height = height;
    }

    public double x() {return x;}
    public double y() {return y;}
    public double tW() {return tW;}
    public double tH() {return tH;}
    public double mx() {return midx;}
    public double my() {return midy;}
    public double rd() {return 5;} //renderdistance
    public void setx (double x) {this.x = x;}
    public void sety (double y) {this.y = y;}
    public double width () {return this.width;}
    public double height () {return this.height;}




    public void changeX (double change) {
        this.x += change;
    }

    public void changeY (double change) {
        this.y += change;
    }

    public void zoom (int zoom) {
        if (zoom == -1) {
            tW -= 1;
            tH -= 1;
            if (tW < 2) tW = 2;
            if (tH < 2) tH = 2;
        } else if (zoom == 1) {
            tW += 1;
            tH += 1;
        }


    }


    public void draw (imgDict dict) {
    }

}
