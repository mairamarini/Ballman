package org.academiadecodigo.asciimos.ballman.game.gameobjects;


import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Ball extends GameObjects{


    private boolean used = false;
    private Picture pic;

    public Ball(Position pos) {
        super(pos);
        pic = new Picture(super.getPosition().getX() + 17, super.getPosition().getY() + 22, "ball.png");
    }

    public Position getPosition() {
        return super.getPosition();
    }

    public void setPosition(Position pos) {
        int dx = pos.getX() - super.getPosition().getX();
        int dy = pos.getY() - super.getPosition().getY();

        pic.translate(dx, dy);
        super.setPosition(pos);
    }


    public boolean isUsed() {
        return used;
    }

    public void useBall() {
        used = true;
    }

    public void draw() {
        pic.draw();
    }

    public void deleteBall() {
        pic.delete();
        used = false;
    }
}
