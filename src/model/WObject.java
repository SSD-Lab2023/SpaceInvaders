package model;

import Constant.Constant;

import java.awt.*;

public abstract class WObject {

    private int x;
    private int y;

    private Image image;

    private int dx;
    private int dy;

    private int speed;

    private boolean isAlive = true;
    private boolean isFired = false;

    public WObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public boolean isFired(){
        return isFired;
    }

    public int getX() {
        return x;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public int getY() {
        return y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public void move() {
        this.x += dx * speed;
        this.y += dy * speed;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public boolean hit(WObject wObj) {
        return x == wObj.x && y == wObj.y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }

    public void turnWest() {
        this.dx = -1;
        this.dy = 0;
    }

    public void turnEast() {
        this.dx = 1;
        this.dy = 0;
    }

    public void stop(){
        this.dx = 0;
        this.dy = 0;
    }

    public void checkOutField(){

    }

    public void initImage(){

    }

    public void moveForward() {
        this.dx = 0;
        this.dy = -1;
    }

}
