package org.academiadecodigo.asciimos.ballman.game;

import org.academiadecodigo.asciimos.ballman.game.gameobjects.Ball;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.ObjectFactory;
import org.academiadecodigo.asciimos.ballman.game.gameobjects.factory.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class Player implements Movable, Collidable {

    private Position position;
    private Ball ball;
    private boolean dead;


    public Player() {
        position = new Position(10,10);
        ball = new Ball(position);
        ball.isUsed();
    }

    public Position getPosition() {
        return position;
    }

    public boolean isDead() {
        return dead;
    }

    public void dead() {
        dead = true;
    }


    @Override
    public void move(int dx, int dy) {
        position.setCoordinates(dx, dy);
    }

    @Override
    public boolean collide(Grid grid, KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                return position.getRectangle().getX() > grid.getRectangle().getWidth() - Grid.CELL_SIZE;

            case KeyboardEvent.KEY_LEFT:
                return position.getRectangle().getX() <= Grid.PADDING;

            case KeyboardEvent.KEY_DOWN:
                return position.getRectangle().getY() > grid.getRectangle().getHeight() - Grid.CELL_SIZE;

            case KeyboardEvent.KEY_UP:
                return position.getRectangle().getY() <= Grid.PADDING;
        }
        return false;
    }

    public void draw() {

        //getPosition().getRectangle().setColor(Color.BLACK);
        getPosition().getRectangle().draw();
    }

    public Ball getBall() {
        return ball;
    }

    public void drawBall() {
        ball.draw();
    }

    public void putBall() {
        ball = new Ball(new Position(position.getX(), position.getY()));
        ball.draw();
        ball.useBall();
    }

    public void initBall() {
        putBall();
    }
}
