package brickbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    private int x, y, diameter;
    private int xDir, yDir;

    public Ball(int x, int y, int diameter, int xDir, int yDir) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.xDir = xDir;
        this.yDir = yDir;
    }

    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, diameter, diameter);
    }

    public void move() {
        x += xDir;
        y += yDir;
        if (x < 0 || x > 670) xDir = -xDir;
        if (y < 0) yDir = -yDir;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public void invertYDir() {
        yDir = -yDir;
    }

    public void invertXDir() {
        xDir = -xDir;
    }
}
