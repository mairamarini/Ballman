package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Objectfactory;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;

public class Player implements Movable, Collidable {

    private Position position;

    public Player() {
        position = Objectfactory.getPosition();
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void updatePosition(int dx, int dy) {
        position.setCoordinates(dx,dy);
    }
}
