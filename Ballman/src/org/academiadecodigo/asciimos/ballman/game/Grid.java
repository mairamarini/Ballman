package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Rectangle rectangle;
    public static final int COLS = 30;
    public static final int ROWS = 30;
    public static final int PADDING = 10;
    public static final int CELL_SIZE = 20;

    public Rectangle getRectangle() {
        return rectangle;
    }


    public Grid() {
        rectangle = new Rectangle(PADDING,PADDING,COLS * CELL_SIZE,ROWS * CELL_SIZE);
    }

    public void drawGrid() {
        rectangle.draw();
    }


    public void drawPlayer(Player player) {
        player.getPosition().getRectangle().fill();
    }

    


    public void drawBall(Ball ball) {
        ball.draw();
    }

}
