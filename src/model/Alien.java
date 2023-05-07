package model;

import javax.swing.*;
import java.awt.*;

public class Alien extends Spaceship{
    public Alien(int x, int y) {
        super(x, y);
        initImage();
    }

    @Override
    public void initImage() {
        Image imageAlien = new ImageIcon("images/alien.png").getImage();
        setImage(imageAlien);
    }
}
