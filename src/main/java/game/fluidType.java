package game;

public class fluidType extends tileType {

    public fluidType () {
        super(0, 0, 0, 0);
    }

    @Override
    public void draw (imgDict dict, double rendx, double rendy, double rendw, double rendh, int tilex, int tiley, double roundNess) {
        //dict.drawImg(x, y, width, height, rendx, rendy, rendw, rendh, 0);
        dict.drawShader(tilex, tiley, rendx, rendy, rendw, rendh, roundNess, 0.33, 0.75, 1, 8, 6);
    }
}
