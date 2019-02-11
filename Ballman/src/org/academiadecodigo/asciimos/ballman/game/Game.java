package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.asciimos.ballman.game.gameobjects.Ball;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.Pokemon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;

public class Game implements KeyboardHandler {

    private Grid grid;
    private Pokemon[] pokemons;
    private Player player;
    private KeyboardEvent keyboardEvent;
    private static final int SLEEP = 100;
    private int numberPokemons = 5;

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
            player.draw();

            for (Pokemon r : pokemons) {
                r.movePokemon(r.getRectangle());
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
        grid.draw();
        player.draw();
        player.initBall();

        //Pokemon[] pokemons = new Pokemon[numberPokemons];
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
