import model.Spaceship;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class World extends Observable {

    private int size;
    private Spaceship spaceship;


    public World(){

    }

    private void initPlayer(){
        spaceship = new Spaceship(300,300);

    }

}
