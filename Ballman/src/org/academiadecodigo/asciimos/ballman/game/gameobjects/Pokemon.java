package org.academiadecodigo.asciimos.ballman.game.gameobjects;

import org.academiadecodigo.asciimos.ballman.game.Collidable;
import org.academiadecodigo.asciimos.ballman.game.Grid;
import org.academiadecodigo.asciimos.ballman.game.Movable;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.RandomCoordinate;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;


public class Pokemon implements Movable, Collidable {

    private boolean catched = false;
    private Position position;
    public Rectangle rectangle;



    public Pokemon getNewPokemon() {

        rectangle = new Rectangle(RandomCoordinate.getRandomCoordinateX(), RandomCoordinate.getRandomCoordinateY(), Grid.CELL_SIZE, Grid.CELL_SIZE);

        rectangle.setColor(Color.MAGENTA);
        rectangle.draw();
        rectangle.fill();
        //System.out.println("x: " + rectangle.getX() + " y: " + rectangle.getY());

        return this;

    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void move(int dx, int dy) {
    }

    //@Override
    public void movePokemon(Rectangle rectangle) {
        //System.out.println("x: " + rectangle.getX() + " y: " + rectangle.getY());

        switch ((int) Math.floor((Math.random() * 4))) {

            case 0: // MOVE RIGHT
                if (rectangle.getX() >= Grid.COLS * Grid.CELL_SIZE - Grid.CELL_SIZE) {
                    rectangle.translate(-Grid.CELL_SIZE, 0);
                }
                rectangle.translate(Grid.CELL_SIZE, 0);
            break;

            case 1: // MOVE DOWN
                if (rectangle.getY() >= Grid.ROWS * Grid.CELL_SIZE - Grid.CELL_SIZE) {
                    rectangle.translate(0,-Grid.CELL_SIZE);
                }
                rectangle.translate(0, Grid.CELL_SIZE);
                break;


            case 2: // MOVE LEFT
                if (rectangle.getX() >= Grid.CELL_SIZE) {
                    rectangle.translate(-Grid.CELL_SIZE, 0);
                }
                //rectangle.translate(Grid.CELL_SIZE, 0);
                break;


            case 3: // MOVE UP
                if (rectangle.getY() >= Grid.CELL_SIZE) {
                    rectangle.translate(0,-Grid.CELL_SIZE);
                }
                //rectangle.translate(0,-Grid.CELL_SIZE);
                break;

            }
        }


    @Override
    public boolean collide(Grid grid, KeyboardEvent keyboardEvent) {
        return false;
    }


}
