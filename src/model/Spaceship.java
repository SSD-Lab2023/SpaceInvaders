package model;

public class Spaceship extends WObject{

    private int dx;
    private int dy;

    public Spaceship(int x, int y) {
        super(x, y);
    }

    public void turnWest() {
        dx = -1;
        dy = 0;
    }

    public void turnEast() {
        dx = 1;
        dy = 0;
    }
}
