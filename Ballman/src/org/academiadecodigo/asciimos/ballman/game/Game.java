package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.asciimos.ballman.game.gameobjects.Ball;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.Pokemon;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    private Grid grid;
    private Pokemon[] pokemons;
    private Ball ball;
    private Player player;
    private KeyboardEvent keyboardEvent;
    private static final int SLEEP = 100;

    public Game() {
        grid = new Grid();
        player = new Player();
    }

    public void startGame() throws InterruptedException {

        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent[] keyboardEvents = new KeyboardEvent[Directions.getSize()];

        keyboardEvents = createKeyboardEvents(keyboardEvents);

        keyboard = createListenerEvents(keyboard,keyboardEvents);

        drawStartingGame();

        while (true) {

            if(keyboardEvent != null) {
                checkKeyboardEvent();
                keyboardEvent = null;
            }

            Thread.sleep(SLEEP);

            // TODO: 07-02-2019 move all pokemons here!!


        }
    }

    private void checkKeyboardEvent() {

        if(player.collide(grid,keyboardEvent)) {
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
                player.move(0,Grid.CELL_SIZE);
                break;

            case KeyboardEvent.KEY_UP:
                player.move(0, -Grid.CELL_SIZE);
                break;

        }

        grid.drawPlayer(player);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

         this.keyboardEvent = keyboardEvent;
    }

    private void drawStartingGame() {
        grid.drawGrid();
        grid.drawPlayer(player);
        grid.drawPokemon();
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
    public void keyReleased(KeyboardEvent keyboardEvent) {}
}
