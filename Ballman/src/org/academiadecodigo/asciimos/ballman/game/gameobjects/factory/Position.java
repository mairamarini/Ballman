package org.academiadecodigo.asciimos.ballman.game.gameobjects.factory;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {

    private Picture picture;

    public Position(int x, int y) {
        picture = new Picture(x, y, "player_down.png");
    }

    public void setCoordinates(int x, int y, KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                picture.delete();
                picture = new Picture(picture.getX() + x, picture.getY() + y, "player_down.png");

                break;
            case KeyboardEvent.KEY_LEFT:
                picture.delete();
                picture = new Picture(picture.getX() + x, picture.getY() + y, "player_left.png");

                break;
            case KeyboardEvent.KEY_RIGHT:
                picture.delete();
                picture = new Picture(picture.getX() + x, picture.getY() + y, "player_right.png");

                break;
            case KeyboardEvent.KEY_UP:
                picture.delete();
                picture = new Picture(picture.getX() + x, picture.getY() + y, "player_up.png");

                break;
        }

    }

    public Picture getPicture() {
        return picture;
    }


    public int getX() {
        return picture.getX();

    }

    public int getY() {
        return picture.getY();
    }


}
