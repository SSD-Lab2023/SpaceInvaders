package model;

import javax.swing.*;
import java.awt.*;

public class AlienLevel2 extends Alien{
    public AlienLevel2(int x, int y) {
        super(x, y);
        initImage();
    }

    @Override
    public void initImage() {
        Image imagesAlienLevel2 = new ImageIcon("images/alienLevel2.png").getImage();
        setImage(imagesAlienLevel2);
    }
}
