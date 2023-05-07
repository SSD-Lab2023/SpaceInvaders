package model;

public abstract class WObject {


    private int x;
    private int y;

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

    public int getY() {
        return y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move() {
        this.x += dx * speed;
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
}
