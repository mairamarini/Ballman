package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public interface Collidable {

    boolean collide(Grid grid, KeyboardEvent keyboardEvent);
}
