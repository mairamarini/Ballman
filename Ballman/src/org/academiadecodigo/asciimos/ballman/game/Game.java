package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.asciimos.ballman.game.gameobjects.Pokemon;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Game implements KeyboardHandler {

    private Grid grid;
    private Pokemon[] pokemons;
    private Player player;
    private KeyboardEvent keyboardEvent;
    private static final int SLEEP = 200;
    private int numberPokemons = 5;
    private Picture bg;
    private boolean begin;

    public Game() {
        bg = new Picture(Grid.PADDING, Grid.PADDING, "resources/floor.jpg");
        grid = new Grid();
        player = new Player();
        pokemons = new Pokemon[numberPokemons];
    }

    public void startGame() throws InterruptedException {

        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent[] keyboardEvents = new KeyboardEvent[Directions.getSize()];

        int counter = 0;

        keyboardEvents = createKeyboardEvents(keyboardEvents);

        keyboard = createListenerEvents(keyboard, keyboardEvents);

        new Picture(10, 10, "resources/MENU_FINAL.png").draw();


        while (!begin) {

            Thread.sleep(0);
        }

        drawStartingGame();

        while (true) {

            if (keyboardEvent != null) {
                checkKeyboardEvent();
                keyboardEvent = null;
            }


            grid.draw();
            if (player.isDead()) {
                player.getBall().deleteBall();
                for (KeyboardEvent k : keyboardEvents) {
                    keyboard.removeEventListener(k);
                }
            }
            player.draw();

            for (Pokemon pokemon : pokemons) {
                if (pokemon.catched()) {
                    pokemon.getRectangle().delete();
                    continue;
                }

                pokemon.movePokemon(pokemon.getRectangle());

                if (pokemon.getRectangle().getX() == player.getPosition().getX()
                        && pokemon.getRectangle().getY() == player.getPosition().getY()) {
                    player.getPosition().getPicture().delete();
                    player.dead();
                    new Picture(Grid.PADDING, Grid.PADDING, "resources/floor.jpg").draw();
                    new Picture(10, 10, "resources/lindinha.png").draw();
                    return;
                }

                if (player.getBall() != null && pokemon.getRectangle().getY() == player.getBall().getPosition().getY()
                        && pokemon.getRectangle().getX() == player.getBall().getPosition().getX()) {
                    pokemon.isCatched();
                    for (Pokemon p : pokemons) {
                        if (p.catched()) {
                            counter++;
                        }
                        if (counter == pokemons.length) {
                            new Picture(10, 10, "resources/Winner.png").draw();
                            return;
                        } else {
                            counter = 0;
                        }
                    }

                    player.getBall().deleteBall();
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
                player.move(Grid.CELL_SIZE, 0, keyboardEvent);
                break;

            case KeyboardEvent.KEY_LEFT:
                player.move(-Grid.CELL_SIZE, 0, keyboardEvent);
                break;

            case KeyboardEvent.KEY_DOWN:
                player.move(0, Grid.CELL_SIZE, keyboardEvent);
                break;

            case KeyboardEvent.KEY_UP:
                player.move(0, -Grid.CELL_SIZE, keyboardEvent);
                break;

            case KeyboardEvent.KEY_SPACE:
                if (player.getBall().isUsed()) {
                    player.getBall().deleteBall();
                }

                player.putBall();
                break;
        }
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE && begin == false) {
            begin = true;
            return;
        }

        this.keyboardEvent = keyboardEvent;
    }

    private void drawStartingGame() {
        grid.draw();
        bg.draw();
        player.draw();

        for (int i = 0; i < numberPokemons; i++) {
            pokemons[i] = new Pokemon();
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
