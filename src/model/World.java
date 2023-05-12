package model;
import Constant.Constant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Observable;
import javax.swing.*;

public class World extends Observable {


    private Thread thread;
    private Spaceship spaceship;
    private Boolean isOver;

    private long delayed = 50;

    private boolean alive;
    private List<Alien> aliens;

    private List<Bullet> bullets = new ArrayList<Bullet>();
    public BulletPool bulletPool = new BulletPool();
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
        for (int row = 0; row < 4; row++){
            for(int col = 0; col < 8; col++){
                if (row == 0){
                    AlienLevel2 alien = new AlienLevel2(100 + 50 * col, 50 + 30 * row);
                    aliens.add(alien);
                }
                Alien alien = new Alien(100 + 50  * col, 50 + 30 * row);
                aliens.add(alien);
            }
        }
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void moveBullet() {
        for (Bullet bullet: bullets) {
            bullet.moveForward();
            bullet.move();
        }
    }
    public void shootBullets(Spaceship spaceship) {
        if (!spaceship.isFired()){
            Bullet bullet = bulletPool.getBullet(spaceship.getX()+16, spaceship.getY()-10, spaceship.getDx(),-spaceship.getDy());
            moveBullet();
            bullets.add(bullet);
            spaceship.setFired(true);
        }
    }

    public void startGame(){
        isOver = false;
        thread = new Thread() {
                @Override
                public void run() {
                    while (!isOver) {
                        checkplayer();
                        spaceship.move();
                        spaceship.checkOutField();
                        chooseDirectionOfAlien();
                        moveAlien();
                        moveBullet();
                        checkHit();
                        setChanged();
                        notifyObservers();
                        waitFor(delayed);
                        }
                    }
                };
        thread.start();
            };

    private void waitFor(long delayed) {
        try {
            Thread.sleep(delayed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void chooseDirectionOfAlien(){
        for(Alien alien: aliens){

            if (alien.getDx() == 0){
                alien.turnEast();
            }
            int x = alien.getX();
            if (x >= Constant.SIZE - 60 && alien.getDx() != -1) {

                for (Alien a : aliens) {
                    a.turnWest();
                    a.setY(a.getY() + 5);
                }
            }
            if (x <= 10 && alien.getDx() != 1) {
                for (Alien a : aliens) {
                    a.turnEast();
                    a.setY(a.getY() + 5);
                }
            }

        }
    }
    private void moveAlien(){
        for (Alien alien: aliens){
            alien.move();
        }
    }

    private void checkplayer(){
        for(Alien alien: aliens) {
            if(Math.abs(alien.getY() - spaceship.getY()) <= 32){
                isOver = true;
                JOptionPane.showMessageDialog(null, "Game Over!");
            }
        }
    }


    private void checkHit() {
        List<Bullet> toRemoveBullet = new ArrayList<Bullet>();
        List<Alien> toRemoveAlians = new ArrayList<Alien>();
        for(Bullet bullet : bullets) {
            for (Alien alien : aliens) {
                System.out.println(alien.getX());
                System.out.println(bullet.getX());
                System.out.println("this is abb"+Math.abs(bullet.getX() - alien.getX()));


                if(Math.abs(bullet.getX() - alien.getX()) <= 20 && Math.abs(alien.getY() - bullet.getY()) <= 10) {

                    toRemoveBullet.add(bullet);
                    toRemoveAlians.add(alien);

                    System.out.println("yee shoot drone");
                    }
                }
            }
        for(Bullet bullet : toRemoveBullet) {
            bullets.remove(bullet);
            bulletPool.releaseBullet(bullet);
        }
        for(Alien alien : toRemoveAlians) {
            aliens.remove(alien);
        }
        }
}
