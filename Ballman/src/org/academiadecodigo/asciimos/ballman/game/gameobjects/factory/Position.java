package org.academiadecodigo.asciimos.ballman.game.gameobjects.factory;

import org.academiadecodigo.asciimos.ballman.game.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.security.PublicKey;

public class Position {

    private Rectangle rectangle;


    public Position(int x, int y) {
        rectangle = new Rectangle(10,10, Grid.CELL_SIZE,Grid.CELL_SIZE);
    }

    public void setCoordinates(int x, int y) {
        rectangle.delete();
        rectangle = new Rectangle(rectangle.getX() + x,rectangle.getY() + y,Grid.CELL_SIZE,Grid.CELL_SIZE);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }



}
