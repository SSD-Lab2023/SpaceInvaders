package model;
import java.util.List;

import model.Spaceship;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class World extends Observable {


    private Thread thread;
    private Spaceship spaceship;
    private Boolean isOver;

    private long delayed = 250;

    private boolean alive;
    private Alien [] aliens;

    private List<Bullet> bullets;
    public BulletPool bulletpool = new BulletPool();


    public World(){
        spaceship = new Spaceship(300-32,450);
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }
    public void burstBullets(int x, int y) {
    }

    public void startGame(){
        isOver = false;
        thread = new Thread() {
                @Override
                public void run() {
                    while (!isOver) {
                        spaceship.move();
                        spaceship.checkOutField();
                        setChanged();
                        notifyObservers();
                        waitFor(delayed);
                    }
                }
            };
            thread.start();
    }

    private void waitFor(long delayed) {
        try {
            Thread.sleep(delayed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
