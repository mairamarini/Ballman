package org.academiadecodigo.asciimos.ballman.game.gameobjects;


import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;

public class Ball extends GameObjects {

    private boolean used;

    @Override
    public Position getPosition() {
        return super.getPosition();
    }


    public boolean isUsed() {
       //if player press space, return true.
       return true;
    }
}
