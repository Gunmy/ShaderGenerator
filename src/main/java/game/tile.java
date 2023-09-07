package game;

public class tile extends drawAble {

    tileType tileType;
    public tile (int x, int y, tileType tileType) {
        super(x, y, 1, 1);
        this.tileType = tileType;
    }

    @Override
    public void drawSpecial(imgDict dict, double rendx, double rendy, double rendw, double rendh, double roundNess) {
        tileType.draw(dict, rendx, rendy, rendw, rendh, (int) x, (int) y, roundNess);
    }

}
