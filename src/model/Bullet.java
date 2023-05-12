package model;

import Constant.Constant;

import javax.swing.*;
import java.awt.*;

public class Bullet extends WObject{

    private long lastFire;
    public Bullet(int x, int y) {
        super(x, y);
        setSpeed(50);
        initImage();
    }
    public void reset(int x, int y, int dx, int dy) {
        setX(x);
        setY(y);
        setDx(dx);
        setDy(dy);
    }

    @Override
    public void initImage() {
        Image imageBullet = new ImageIcon("images/bullet.png").getImage();
        setImage(imageBullet);
    }

    @Override
    public void checkOutField() {
        // ออกนอก window
        if (getY() <= Constant.SIZE){
            this.setAlive(false);
        }
    }
}






