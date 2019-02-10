package org.academiadecodigo.asciimos.ballman.game.gameobjects;


import org.academiadecodigo.asciimos.ballman.game.Grid;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Ball extends GameObjects {

    private boolean used;
    private Rectangle ball;

    public Ball(int x,int y) {
        ball = new Rectangle(x, y, Grid.CELL_SIZE, Grid.CELL_SIZE);
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
        ball.delete();

    }

    public boolean isUsed() {
       //if player press space, return true.
       return true;
    }

    public void draw(){
        ball.draw();
    }
}
