package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.asciimos.ballman.game.gameobjects.Ball;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.Pokemon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Game implements KeyboardHandler {

    private Grid grid;
    private Pokemon[] pokemons;
    private Player player;
    private KeyboardEvent keyboardEvent;
    private static final int SLEEP = 100;
    private int numberPokemons = 4;
    Picture gridbackground;

    public Game() {
        grid = new Grid();
        player = new Player();
        pokemons = new Pokemon[numberPokemons];
    }

    public void startGame() throws InterruptedException {

        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent[] keyboardEvents = new KeyboardEvent[Directions.getSize()];

        keyboardEvents = createKeyboardEvents(keyboardEvents);

        keyboard = createListenerEvents(keyboard, keyboardEvents);

        drawStartingGame();

        while (true) {

            // UPDATE GAME OBJECTS
            if (keyboardEvent != null) {
                checkKeyboardEvent();
                keyboardEvent = null;
            }


            // TODO: 07-02-2019 move all pokemons here!!


            // DRAW GAME OBJECTS
            grid.draw();
            if(player.isDead()) {
                for (KeyboardEvent k: keyboardEvents) {
                    keyboard.removeEventListener(k);
                }
            }
            player.draw();

            for (Pokemon r : pokemons) {
                if(r.catched()) {
                    r.getRectangle().delete();
                    continue;
                }
                r.movePokemon(r.getRectangle(), pokemons);
                if(r.getRectangle().getX() == player.getPosition().getX() && r.getRectangle().getY() == player.getPosition().getY()) {
                    player.getPosition().getRectangle().delete();
                    player.dead();

                }

                if(r.getRectangle().getY() == player.getBall().getPosition().getY() && r.getRectangle().getX() == player.getBall().getPosition().getX()) {
                    r.isCatched();
                    System.out.println("Catched one Pokemon");
                }
            }

            // END OF GAME LOOP
            Thread.sleep(SLEEP);

        }
    }

    private void checkKeyboardEvent() {

        if (player.collide(grid, keyboardEvent)) {
            return;
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                player.move(Grid.CELL_SIZE, 0);
                break;

            case KeyboardEvent.KEY_LEFT:
                player.move(-Grid.CELL_SIZE, 0);
                break;

            case KeyboardEvent.KEY_DOWN:
                player.move(0, Grid.CELL_SIZE);
                break;

            case KeyboardEvent.KEY_UP:
                player.move(0, -Grid.CELL_SIZE);
                break;

            case KeyboardEvent.KEY_SPACE:
                player.drawBall();
                player.putBall();
                break;

        }
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

         this.keyboardEvent = keyboardEvent;
    }

    private void drawStartingGame() {
        gridbackground = new Picture(10 , 10, "floor.png");
        gridbackground.draw();
        player.draw();
        player.initBall();

        for (int i= 0; i < numberPokemons; i++) {
            pokemons[i] = new Pokemon().getNewPokemon();
        }

    }

    private KeyboardEvent[] createKeyboardEvents(KeyboardEvent[] keyboardEvents) {

        Directions[] directions = Directions.values();

        for (int i = 0; i < keyboardEvents.length; i++) {
            keyboardEvents[i] = new KeyboardEvent();
            keyboardEvents[i].setKey(directions[i].getValue());
            keyboardEvents[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        }

        return keyboardEvents;
    }

    private Keyboard createListenerEvents(Keyboard keyboard, KeyboardEvent[] keyboardEvents) {

        for (KeyboardEvent event : keyboardEvents) {
            keyboard.addEventListener(event);
        }

        return keyboard;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
