package org.academiadecodigo.asciimos.ballman.game.gameobjects.factory;

import org.academiadecodigo.asciimos.ballman.game.Grid;

public abstract class RandomCoordinate {

    public static int getRandomCoordinateX() {
        return (int) (Math.floor(Math.random()*Grid.COLS)*Grid.CELL_SIZE+Grid.PADDING);
    }

    public static int getRandomCoordinateY() {
        return (int) (Math.floor(Math.random()*Grid.ROWS)*Grid.CELL_SIZE+Grid.PADDING);
    }
}
