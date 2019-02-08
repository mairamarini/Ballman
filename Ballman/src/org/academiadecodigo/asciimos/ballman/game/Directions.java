package org.academiadecodigo.asciimos.ballman.game;

public enum Directions {

    LEFT (37),
    RIGHT (38),
    UP (39),
    DOWN (40),
    SPACE (32);

    private int value;

    Directions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int getSize() {
        return values().length;
    }
}
