package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.asciimos.ballman.game.gameobjects.Pokemon;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.RandomCoordinate;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Rectangle rectangle;
    public static final int COLS = 50;
    public static final int ROWS = 30;
    public static final int PADDING = 10;
    public static final int CELL_SIZE = 20;

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Grid() {
        rectangle = new Rectangle(PADDING,PADDING,COLS * CELL_SIZE,ROWS * CELL_SIZE);
    }

    public void drawPlayer(Player player) {
        player.getPosition().getRectangle().fill();
    }

    public void drawGrid() {
        rectangle.draw();
    }

    public void drawPokemon() {

        Rectangle pokemon1 = new Rectangle(RandomCoordinate.getRandomCoordinateX(),RandomCoordinate.getRandomCoordinateY(),Grid.CELL_SIZE,Grid.CELL_SIZE);
        Rectangle pokemon2 = new Rectangle(RandomCoordinate.getRandomCoordinateX(),RandomCoordinate.getRandomCoordinateY(),Grid.CELL_SIZE,Grid.CELL_SIZE);
        Rectangle pokemon3 = new Rectangle(RandomCoordinate.getRandomCoordinateX(),RandomCoordinate.getRandomCoordinateY(),Grid.CELL_SIZE,Grid.CELL_SIZE);
        Rectangle pokemon4 = new Rectangle(RandomCoordinate.getRandomCoordinateX(),RandomCoordinate.getRandomCoordinateY(),Grid.CELL_SIZE,Grid.CELL_SIZE);
        Rectangle pokemon5 = new Rectangle(RandomCoordinate.getRandomCoordinateX(),RandomCoordinate.getRandomCoordinateY(),Grid.CELL_SIZE,Grid.CELL_SIZE);

        Rectangle[] pokemonsArray = new Rectangle[] {pokemon1,pokemon2,pokemon3,pokemon4,pokemon5};

        for(Rectangle poke: pokemonsArray) {
            poke.setColor(Color.MAGENTA);
            poke.draw();
            poke.fill();
        }
    }
}
