package org.academiadecodigo.asciimos.ballman.game.gameobjects;

public abstract class GameObjects {

    private Position position;

    public GameObjects(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


}
