package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Objectfactory;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class Player implements Movable, Collidable {

    private Position position;

    public Player() {
        position = Objectfactory.getPosition();
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void move(int dx, int dy) {
        position.setCoordinates(dx,dy);
    }

    @Override
    public boolean collide(Grid grid, KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                return position.getRectangle().getX() > grid.getRectangle().getWidth() - Grid.CELL_SIZE;

            case KeyboardEvent.KEY_LEFT:
                return position.getRectangle().getX() <= Grid.PADDING;

            case KeyboardEvent.KEY_DOWN:
                return position.getRectangle().getY() > grid.getRectangle().getHeight() - Grid.CELL_SIZE;

            case KeyboardEvent.KEY_UP:
                return position.getRectangle().getY() <= Grid.PADDING;
        }
        return false;
    }
}
