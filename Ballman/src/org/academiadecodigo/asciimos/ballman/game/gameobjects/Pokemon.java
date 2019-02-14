package org.academiadecodigo.asciimos.ballman.game.gameobjects;

import org.academiadecodigo.asciimos.ballman.game.*;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.RandomCoordinate;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.print.DocFlavor;


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

    public void movePokemon(Picture rectangle, Pokemon[] pokemons) {

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
                    rectangle.translate(0,-Grid.CELL_SIZE);
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
                    rectangle.translate(0,-Grid.CELL_SIZE);
                    break;
                }
                rectangle.translate(0,Grid.CELL_SIZE);
                break;

            }

         this.direction = newDirection;

        }


    @Override
    public boolean collide(Grid grid, KeyboardEvent keyboardEvent)  {
        return false;
    }

    private boolean collide(Pokemon[] pokemons, int direction) {

        switch (direction) {

            case 0:     //move right
                for (Pokemon p : pokemons) {
                       if(this.rectangle.getX() + Grid.CELL_SIZE == p.rectangle.getX()) {
                       return true;
                   }
                }
                break;
            case 1:     // move down
                for (Pokemon p:pokemons) {
                    if(this.rectangle.getY() + Grid.CELL_SIZE == p.rectangle.getY()) {
                        return true;
                    }
                }
                break;
            case 2:    //move left
                for (Pokemon p:pokemons ) {
                  if(this.rectangle.getX() - Grid.CELL_SIZE == p.rectangle.getX()) {
                      return true;
                  }
                }
                break;
            case 3:      //move up
                for (Pokemon p:pokemons ) {
                        if(this.rectangle.getY() - Grid.CELL_SIZE == p.rectangle.getY()) {
                            return true;
                        }
                }
                break;
        }

        return false;
    }


}
