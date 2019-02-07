package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Rectangle rectangle;
    public static final int COLS = 50;
    public static final int ROWS = 30;
    public static final int PADDING = 10;
    public static final int CELL_SIZE = 20;

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Grid() {
        rectangle = new Rectangle(PADDING,PADDING,COLS * CELL_SIZE,ROWS * CELL_SIZE);
    }

    public void drawPlayer(Player player) {

        System.out.println(player.getPosition().getRectangle().getX());
        System.out.println(rectangle.getWidth());

        if(player.getPosition().getRectangle().getY() >= rectangle.getHeight() + PADDING ||
           player.getPosition().getRectangle().getX() >= rectangle.getWidth() + PADDING) {

            //player.getPosition().getRectangle().delete();

            return;
        }

        player.getPosition().getRectangle().fill();
    }

    public void drawGrid() {
        rectangle.draw();
    }

}
