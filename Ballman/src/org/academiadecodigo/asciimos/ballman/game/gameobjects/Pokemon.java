package org.academiadecodigo.asciimos.ballman.game.gameobjects;

import org.academiadecodigo.asciimos.ballman.game.Collidable;
import org.academiadecodigo.asciimos.ballman.game.Grid;
import org.academiadecodigo.asciimos.ballman.game.Movable;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.RandomCoordinate;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Pokemon implements Movable, Collidable {

    private boolean catched = false;
    public Rectangle rectangle;

    public Pokemon getNewPokemon() {

        rectangle = new Rectangle(RandomCoordinate.getRandomCoordinateX(), RandomCoordinate.getRandomCoordinateY(), Grid.CELL_SIZE, Grid.CELL_SIZE);

        rectangle.setColor(Color.MAGENTA);
        rectangle.draw();
        rectangle.fill();


        return this;

    }

    public void isCatched() {
        catched = true;

    }

    public boolean catched() {

        return catched;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void move(int dx, int dy) {
    }

    public void movePokemon(Rectangle rectangle, Pokemon[] pokemons) {

        int direction = (int) (Math.random() * 4);

        if (this.collide(pokemons, direction) == false) {
            return;
        }

        switch (direction) {


            case 0: // MOVE RIGHT
                if (rectangle.getX() >= Grid.COLS * Grid.CELL_SIZE - Grid.CELL_SIZE) {
                    rectangle.translate(-Grid.CELL_SIZE, 0);
                }

                rectangle.translate(Grid.CELL_SIZE, 0);
                break;

            case 1: // MOVE DOWN
                if (rectangle.getY() >= Grid.ROWS * Grid.CELL_SIZE - Grid.CELL_SIZE) {
                    rectangle.translate(0, -Grid.CELL_SIZE);
                }
                rectangle.translate(0, Grid.CELL_SIZE);
                break;


            case 2: // MOVE LEFT
                if (rectangle.getX() >= Grid.CELL_SIZE) {
                    rectangle.translate(-Grid.CELL_SIZE, 0);
                }
                rectangle.translate(Grid.CELL_SIZE,0);
                break;


            case 3: // MOVE UP
                if (rectangle.getY() >= Grid.CELL_SIZE) {
                    rectangle.translate(0, -Grid.CELL_SIZE);
                }
                //rectangle.translate(0, -Grid.CELL_SIZE);

                break;

        }
    }


    @Override
    public boolean collide(Grid grid, KeyboardEvent keyboardEvent) {
        return false;
    }

    private boolean collide(Pokemon[] pokemons, int direction) {

        switch (direction) {

            case 0:     //move right
                for (Pokemon p : pokemons) {
                    if (this.rectangle.getX() + Grid.CELL_SIZE == p.rectangle.getX()) {
                        return false;
                    }
                }
                break;
            case 1:     // move down
                for (Pokemon p : pokemons) {
                    if (this.rectangle.getY() + Grid.CELL_SIZE == p.rectangle.getY()) {
                        return false;
                    }
                }
                break;
            case 2:    //move left
                for (Pokemon p : pokemons) {
                    if (this.rectangle.getX() - Grid.CELL_SIZE == p.rectangle.getX()) {
                        return false;
                    }
                }
                break;
            case 3:      //move up
                for (Pokemon p : pokemons) {
                    if (this.rectangle.getY() - Grid.CELL_SIZE == p.rectangle.getY()) {
                        return false;
                    }
                }
                break;
        }

        return true;
    }


}
