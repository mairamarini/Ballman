package org.academiadecodigo.asciimos.ballman.game.gameobjects;

import org.academiadecodigo.asciimos.ballman.game.Collidable;
import org.academiadecodigo.asciimos.ballman.game.Grid;
import org.academiadecodigo.asciimos.ballman.game.Movable;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.RandomCoordinate;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import java.awt.*;

public class Pokemon extends GameObjects implements Movable, Collidable {

    private boolean catched;
    //private Position position;

    public static Rectangle getNewPokemon(Grid grid) {

        Rectangle pokemon;

        pokemon = new Rectangle(RandomCoordinate.getRandomCoordinateX(), RandomCoordinate.getRandomCoordinateY(), Grid.CELL_SIZE, Grid.CELL_SIZE);

        pokemon.setColor(Color.MAGENTA);
        pokemon.draw();
        pokemon.fill();
        return pokemon;
    }

    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public boolean collide(Grid grid, KeyboardEvent keyboardEvent) {
        return false;
    }
}
