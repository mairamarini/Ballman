package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Rectangle rectangle;
    public static final int COLS = 12;
    public static final int ROWS = 12;
    public static final int PADDING = 10;
    public static final int CELL_SIZE = 64;

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Grid() {
        rectangle = new Rectangle(PADDING,PADDING,COLS * CELL_SIZE,ROWS * CELL_SIZE);
    }

    public void draw() {
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
    }



}
