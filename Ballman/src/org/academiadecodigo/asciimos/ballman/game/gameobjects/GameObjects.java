package org.academiadecodigo.asciimos.ballman.game.gameobjects;

import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;

public abstract class GameObjects {

    private Position position;




    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


}
