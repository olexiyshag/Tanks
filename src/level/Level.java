package level;

import game.Game;
import graphics.TextureAtlas;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Level {

    private double x;
    private double y;

    public static final int SPRITE_SCALE = 16;
    private float scale;

    public static final int TILE_SCALE = 8;
    public static final int TILE_IN_GAME_SCALE = 2;
    public static final int SCALED_TILE_SIZE = TILE_SCALE * TILE_IN_GAME_SCALE;
    public static final int TILES_IN_WIDTH = Game.WIDTH / SCALED_TILE_SIZE;
    public static final int TILES_IN_HEIGHT = Game.HEIGHT / SCALED_TILE_SIZE;

    private Integer[][] tileMap;
    private Map<TileType, Tile> tiles;
    private List<Point> grassCords;
    private List<Point> brickCords;



    public Level(TextureAtlas atlas) {

        double bX = x;
        double bY = y;



        tileMap = new Integer[TILES_IN_WIDTH][TILES_IN_HEIGHT];
        tiles = new HashMap<TileType, Tile>();


        tiles.put(TileType.BRICK, new Tile(atlas.cut(32 * TILE_SCALE, 0 * TILE_SCALE, TILE_SCALE, TILE_SCALE),
                TILE_IN_GAME_SCALE, TileType.BRICK));


        tiles.put(TileType.METAL, new Tile(atlas.cut(32 * TILE_SCALE, 2 * TILE_SCALE, TILE_SCALE, TILE_SCALE),
                TILE_IN_GAME_SCALE, TileType.METAL));


        tiles.put(TileType.WATER, new Tile(atlas.cut(32 * TILE_SCALE, 4 * TILE_SCALE, TILE_SCALE, TILE_SCALE),
                TILE_IN_GAME_SCALE, TileType.WATER));


        tiles.put(TileType.GRASS, new Tile(atlas.cut(34 * TILE_SCALE, 4 * TILE_SCALE, TILE_SCALE, TILE_SCALE),
                TILE_IN_GAME_SCALE, TileType.GRASS));


        tiles.put(TileType.ICE, new Tile(atlas.cut(36 * TILE_SCALE, 4 * TILE_SCALE, TILE_SCALE, TILE_SCALE),
                TILE_IN_GAME_SCALE, TileType.ICE));


        tiles.put(TileType.EMPTY, new Tile(atlas.cut(36 * TILE_SCALE, 6 * TILE_SCALE, TILE_SCALE, TILE_SCALE),
                TILE_IN_GAME_SCALE, TileType.EMPTY));

        tileMap = Utils.levelParser("res/level.lvl");
        brickCords = new ArrayList<Point>();
        for (int a = 0; a < tileMap.length; a++) {
            for (int b = 0; b < tileMap.length; b++) {
                Tile tile = tiles.get(TileType.fromNumeric(tileMap[a][b]));
                if (tile.type() != TileType.BRICK)
                    brickCords.add(new Point(a * SCALED_TILE_SIZE, b * SCALED_TILE_SIZE));

                x = bX;
                y = bY;
            }
        }


                    tileMap = Utils.levelParser("res/level.lvl");
                grassCords = new ArrayList<Point>();
                for (int i = 0; i < tileMap.length; i++) {
                    for (int j = 0; j < tileMap.length; j++) {
                        Tile tile = tiles.get(TileType.fromNumeric(tileMap[i][j]));
                        if (tile.type() == TileType.GRASS)
                            grassCords.add(new Point(j * SCALED_TILE_SIZE, i * SCALED_TILE_SIZE));

                        x = bX;
                        y = bY;


                    }

                }
            }
    public double getY(){
        return y;
    }

    public double getX(){
        return x;
    }


    public void update() {

    }


    public void render(Graphics2D g) {
        for (int i = 0; i < tileMap.length; i++) {
            for (int j = 0; j < tileMap[i].length; j++) {
                Tile tile = tiles.get(TileType.fromNumeric(tileMap[i][j]));
                if (tile.type() != TileType.GRASS)
                    tile.render(g, j * SCALED_TILE_SIZE, i * SCALED_TILE_SIZE);


                }
            }
        }


    public void renderGrass(Graphics2D g) {
        for (Point p : grassCords) {
            tiles.get(TileType.GRASS).render(g, p.x, p.y);
        }

    }
}

