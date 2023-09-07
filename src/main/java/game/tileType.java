package game;

public class tileType {
    
    int x, y, width, height;

    public tileType (int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw (imgDict dict, double rendx, double rendy, double rendw, double rendh, int tilex, int tiley, double roundNess) {
        dict.drawImg(x, y, width, height, rendx, rendy, rendw, rendh, roundNess);
    }

}
