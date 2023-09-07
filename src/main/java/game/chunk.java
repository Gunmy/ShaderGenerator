package game;

import java.util.ArrayList;
import java.util.List;

public class chunk {

    //Chunk generation
    tileType tileType= new fluidType();

    List<tile> tiles = new ArrayList<>();
    public chunk (int x, int y) {
        for (int h = 0; h < cnst.tC(); h++) {
            for (int w = 0; w < cnst.tC(); w++) {
                newTile(x*cnst.tC()+w, y*cnst.tC()+h, tileType);
            }
        }
    }

    public void draw (imgDict imgDict, camera cam) {
        for (int i = 0; i < tiles.size(); i++) {
            tiles.get(i).draw(imgDict, cam);
        }
    }

    public void newTile (int x, int y, tileType tileType) {
        tiles.add(new tile(x, y, tileType));
    }
}
