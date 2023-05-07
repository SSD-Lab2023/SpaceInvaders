package model;
import java.util.ArrayList;
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
    private List<Alien> aliens;

    private List<Bullet> bullets;
    public BulletPool bulletpool = new BulletPool();


    public World(){
        spaceship = new Spaceship(300-32,450);
        initAlien();
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void initAlien(){
        aliens = new ArrayList<>();
        for (int row = 0; row < 5; row++){
            for(int col = 0; col < 8; col++){
                if (row == 0){
                    AlienLevel2 alien = new AlienLevel2(100 + 50 * col, 100 + 30 * row);
                    aliens.add(alien);
                }
                Alien alien = new Alien(100 + 50  * col, 100 + 30 * row);
                aliens.add(alien);
            }
        }
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
                        for(Alien alien: aliens){
                            alien.move();
                        }
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
