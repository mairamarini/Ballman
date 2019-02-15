package org.academiadecodigo.asciimos.ballman.game.gameobjects;

import org.academiadecodigo.asciimos.ballman.game.*;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Pokemon implements Collidable {

    private boolean catched = false;

    private Picture rectangle;
    private int direction;
    private String name;

    public Pokemon() {
        rectangle = new Picture(RandomCoordinate.getRandomCoordinateX(), RandomCoordinate.getRandomCoordinateY(), name = Images.getRandom());
        rectangle.draw();

    }

    public void isCatched() {
        catched = true;

    }

    public boolean catched() {
        return catched;
    }

    public Picture getRectangle() {
        return rectangle;
    }

    public void movePokemon(Picture rectangle) {

        int random = (int) (Math.random() * 100);
        int newDirection;

        if (random >= 75) {
            newDirection = (int) (Math.random() * 4);
        } else {
            newDirection = direction;
        }

        switch (newDirection) {

            case 0: // MOVE RIGHT
                if (rectangle.getX() >= Grid.COLS * Grid.CELL_SIZE - Grid.CELL_SIZE) {
                    rectangle.translate(-Grid.CELL_SIZE, 0);
                    break;
                }
                rectangle.translate(Grid.CELL_SIZE, 0);
                break;

            case 1: // MOVE DOWN
                if (rectangle.getY() >= Grid.ROWS * Grid.CELL_SIZE - Grid.CELL_SIZE) {
                    rectangle.translate(0, -Grid.CELL_SIZE);
                    break;
                }
                rectangle.translate(0, Grid.CELL_SIZE);
                break;


            case 2: // MOVE LEFT
                if (rectangle.getX() >= Grid.CELL_SIZE) {
                    rectangle.translate(-Grid.CELL_SIZE, 0);
                    break;
                }
                rectangle.translate(Grid.CELL_SIZE, 0);
                break;


            case 3: // MOVE UP
                if (rectangle.getY() >= Grid.CELL_SIZE) {
                    rectangle.translate(0, -Grid.CELL_SIZE);
                    break;
                }
                rectangle.translate(0, Grid.CELL_SIZE);
                break;

        }

        this.direction = newDirection;

    }


    @Override
    public boolean collide(Grid grid, KeyboardEvent keyboardEvent) {
        return false;
    }


}
