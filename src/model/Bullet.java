package model;

import javax.swing.*;
import java.awt.*;

public class Bullet extends WObject{

    public Bullet(int x, int y) {
        super(x, y);
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
}






