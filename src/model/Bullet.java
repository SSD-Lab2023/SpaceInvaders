package model;

public class Bullet extends WObject{

    public Bullet(int x, int y) {
        super(x, y);
    }
    public void reset(int x, int y, int dx, int dy) {
        setX(x);
        setY(y);
        setDx(dx);
        setDy(dy);
    }

}






