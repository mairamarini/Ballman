package org.academiadecodigo.asciimos.ballman.game.gameobjects.factory;

import org.academiadecodigo.asciimos.ballman.game.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    Rectangle rectangle;

    public Position(int x, int y) {
        rectangle = new Rectangle(10,10, Grid.CELL_SIZE,Grid.CELL_SIZE);
    }

    public void setCoordinates(int x, int y) {
        rectangle.translate(x,y);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

}
