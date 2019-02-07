package org.academiadecodigo.asciimos.ballman.game.gameobjects.factory;

public abstract class Objectfactory {

    public static Position getPosition() {
        return new Position(RandomCoordinate.getRandomCoordinateX(),RandomCoordinate.getRandomCoordinateY());
    }
}
