package org.academiadecodigo.asciimos.ballman.game.gameobjects.factory;

import org.academiadecodigo.asciimos.ballman.game.Grid;

public abstract class RandomCoordinate {

    public static int getRandomCoordinateX() {
        return (int) (Math.random() * Grid.COLS + Grid.PADDING);
    }

    public static int getRandomCoordinateY() {
        return (int) (Math.random() * Grid.ROWS + Grid.PADDING);
    }
}
