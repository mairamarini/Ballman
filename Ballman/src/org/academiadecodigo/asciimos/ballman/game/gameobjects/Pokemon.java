package org.academiadecodigo.asciimos.ballman.game.gameobjects;

import org.academiadecodigo.asciimos.ballman.game.Collidable;
import org.academiadecodigo.asciimos.ballman.game.Grid;
import org.academiadecodigo.asciimos.ballman.game.Movable;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.RandomCoordinate;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import java.awt.*;

public class Pokemon extends GameObjects implements Movable, Collidable {

    private boolean catched = false;
    private Position position;
    public static Rectangle pokemon;

    public static Rectangle getNewPokemon() {

        pokemon = new Rectangle(RandomCoordinate.getRandomCoordinateX(), RandomCoordinate.getRandomCoordinateY(), Grid.CELL_SIZE, Grid.CELL_SIZE);

        pokemon.setColor(Color.MAGENTA);
        pokemon.draw();
        pokemon.fill();
        //System.out.println("x: " + pokemon.getX() + " y: " + pokemon.getY());

        return pokemon;

    }

    @Override
    public void move(int dx, int dy) {
    }

    //@Override
    public static void movePokemon() {
        //System.out.println("x: " + pokemon.getX() + " y: " + pokemon.getY());

        switch ((int) Math.floor((Math.random() * 4))) {

            case 0: // MOVE RIGHT
                if (pokemon.getX() >= Grid.COLS * Grid.CELL_SIZE - Grid.CELL_SIZE) {
                    pokemon.translate(-Grid.CELL_SIZE, 0);
                }
                pokemon.translate(Grid.CELL_SIZE, 0);
            break;

            case 1: // MOVE DOWN
                if (pokemon.getY() >= Grid.ROWS * Grid.CELL_SIZE - Grid.CELL_SIZE) {
                    pokemon.translate(0,-Grid.CELL_SIZE);
                }
                pokemon.translate(0, Grid.CELL_SIZE);
                break;


            case 2: // MOVE LEFT
                if (pokemon.getX() >= Grid.CELL_SIZE) {
                    pokemon.translate(-Grid.CELL_SIZE, 0);
                }
                //pokemon.translate(Grid.CELL_SIZE, 0);
                break;


            case 3: // MOVE UP
                if (pokemon.getY() >= Grid.CELL_SIZE) {
                    pokemon.translate(0,-Grid.CELL_SIZE);
                }
                //pokemon.translate(0,-Grid.CELL_SIZE);
                break;

            }
        }


            @Override
            public boolean collide (Grid grid, KeyboardEvent keyboardEvent){
                return false;
            }
        }


