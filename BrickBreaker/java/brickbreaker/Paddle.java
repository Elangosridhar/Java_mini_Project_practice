package brickbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {
    private int x, y, width, height;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);
    }

    public void move(int dx) {
        x += dx;
        if (x < 0) x = 0;
        if (x > 600) x = 600;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }
}
