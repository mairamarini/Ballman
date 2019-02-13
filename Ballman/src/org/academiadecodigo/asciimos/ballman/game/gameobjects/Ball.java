package org.academiadecodigo.asciimos.ballman.game.gameobjects;


import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Ball extends GameObjects{


    private boolean used = false;
    private Rectangle rectangle;
    private Picture pic;

    public Ball(Position pos) {
        super(pos);
        //rectangle = new Rectangle(super.getPosition().getX(), super.getPosition().getY(), Grid.CELL_SIZE, Grid.CELL_SIZE);
        pic = new Picture(super.getPosition().getX(), super.getPosition().getY(), "ball1.png");
    }

    public Position getPosition() {
        return super.getPosition();
    }

    public void setPosition(Position pos) {
        int dx = pos.getX() - super.getPosition().getX();
        int dy = pos.getY() - super.getPosition().getY();

        pic.translate(dx, dy);
        //rectangle.translate(dx, dy);
        super.setPosition(pos);
    }

    /*
    public boolean isUsed() {
        return used;
    }

    public void useBall() {
        used = true;
    }
    */

    public void draw() {
        pic.draw();
        //rectangle.setColor(Color.CYAN);
        //rectangle.fill();
    }

    public void deleteBall() {
        pic.delete();
        //rectangle.delete();
    }
}
