package model;

import Constant.Constant;

import javax.swing.*;
import java.awt.*;

public class Spaceship extends WObject{
    public Spaceship(int x, int y) {
        super(x, y);
        setSpeed(25);
        initSpaceship();
    }
    private void initSpaceship() {
        Image imagesSpaceship = new ImageIcon("images/spaceship.png").getImage();
        setImage(imagesSpaceship);
    }

    @Override
    public void checkOutField() {
        if(getX() >= Constant.SIZE - 48){
            setX(Constant.SIZE - 48);
        }
        if(getX() <= 2){
            setX(2);
        }

    }
}
