package org.academiadecodigo.asciimos.ballman.game.gameobjects.factory;

import org.academiadecodigo.asciimos.ballman.game.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {

    private Rectangle rectangle;
    private int col;
    private int row;



    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }


    public Position() {
        this.col = (int) Math.floor((Math.random() * Grid.COLS) * Grid.CELL_SIZE);
        this.row = (int) Math.floor((Math.random() * Grid.ROWS) * Grid.CELL_SIZE);
    }

    public Position(int x, int y) {

        rectangle = new Rectangle(x,y, Grid.CELL_SIZE,Grid.CELL_SIZE);
    }

    public void setCoordinates(int x, int y) {
        // TODO: 2019-02-11 usar coordenadas ao inves de retangulo.

        rectangle.delete();
        rectangle = new Rectangle(rectangle.getX() + x,rectangle.getY() + y,Grid.CELL_SIZE,Grid.CELL_SIZE);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }



    public int getX() {
        return rectangle.getX();

    }

    public int getY() {
        return rectangle.getY();
    }


}
