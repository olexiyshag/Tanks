package game;

import java.awt.*;

public class Bullet {
    //Fields
    private double x;
    private double y;
    private int r;

    private int speed;

    private Color color;

    //Constructor
    public Bullet(){
        x = Game.player.getX();
        y = Game.player.getY();
        r = 2;

        speed = 10;

        color = Color.WHITE;
    }

    //Functions
    public void update() {
        y -= speed;
    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int) x, (int) y, r, 2 * r);
    }
}
