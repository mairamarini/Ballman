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
    private static final int SLEEP = 500;

    public Game() {
        grid = new Grid();
        player = new Player();
    }

    public void starGame() throws InterruptedException {

        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent[] keyboardEvents = new KeyboardEvent[Directions.getSize()];

        keyboardEvents = createKeyboardEvents(keyboardEvents);

        keyboard = createListenerEvents(keyboard,keyboardEvents);

        draw();

        while (true) {

            Thread.sleep(SLEEP);
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

    private void draw() {
        grid.drawGrid();
        grid.drawPlayer(player);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                player.updatePosition(Grid.CELL_SIZE, 0);
                break;

            case KeyboardEvent.KEY_LEFT:
                player.updatePosition(-Grid.CELL_SIZE, 0);
                break;

            case KeyboardEvent.KEY_DOWN:
                player.updatePosition(0,Grid.CELL_SIZE);
                break;

            case KeyboardEvent.KEY_UP:
                player.updatePosition(0, -Grid.CELL_SIZE);
                break;

            case KeyboardEvent.KEY_SPACE:
                break;
        }

        grid.drawPlayer(player);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}
}
