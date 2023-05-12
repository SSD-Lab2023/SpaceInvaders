package model;

import javax.swing.*;
import java.awt.*;

public class LaserBeam extends Bullet{
    public LaserBeam(int x, int y) {
        super(x, y);
        setSpeed(50);
        initImage();
    }

    @Override
    public void initImage() {
        Image imageLaser = new ImageIcon("images/laser.png").getImage();
        setImage(imageLaser);
    }

}
