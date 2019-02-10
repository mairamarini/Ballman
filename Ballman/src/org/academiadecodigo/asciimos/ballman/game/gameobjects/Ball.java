package org.academiadecodigo.asciimos.ballman.game.gameobjects;


import org.academiadecodigo.asciimos.ballman.game.Grid;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Ball {

    private Position position;
    private boolean used = false;
    private Rectangle rectangle;


    public Ball(Position position) {
        this.position = position;
        rectangle = new Rectangle(position.getX(), position.getY(), Grid.CELL_SIZE, Grid.CELL_SIZE);
    }


    public Position getPosition() {
        return position;
    }


    public void setPosition(Position pos) {
        int dx = pos.getX() - position.getX();
        int dy = pos.getY() - position.getY();

        rectangle.translate(dx, dy);
        position = pos;
    }

    public boolean isUsed() {
        return used;
    }

    public void useBall() {
        used = true;
    }

    public void draw() {
        rectangle.setColor(Color.CYAN);
        rectangle.fill();
    }
}
