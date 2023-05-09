import Constant.Constant;
import command.*;
import model.Alien;
import model.Bullet;
import model.Spaceship;
import model.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class Window extends JFrame implements Observer {
    private World world;
    private GridUI gridUI = new GridUI();
    private Renderer renderer;

    public Window(){
        super();
        setTitle("Space Invaders");
        setLayout(new BorderLayout());
        addKeyListener(new Controller());
        world = new World();
        world.addObserver(this);
        renderer = new Renderer();
        add(renderer, BorderLayout.CENTER);
        add(gridUI, BorderLayout.SOUTH);
        setResizable(false);
        setSize(Constant.SIZE,Constant.SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void start(){
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        renderer.repaint();
    }

    class GridUI extends JPanel {
        private JButton startButton;
        public GridUI(){
            startButton = new JButton("Start");
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startButton.setEnabled(false);
                    world.startGame();
                    Window.this.requestFocus();
                }
            });
            add(startButton);
        }

    }

    class Renderer extends JPanel{

        public Renderer(){
            setDoubleBuffered(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            setBackground(Color.white);
            drawSpaceship(g);
            drawAlien(g);
            drawBullet(g);
        }

        private void drawSpaceship(Graphics g){
            if(world.getSpaceship().isAlive()){
                g.drawImage(world.getSpaceship().getImage(), world.getSpaceship().getX(),world.getSpaceship().getY(),null,null);
            }
        }

        private void drawAlien(Graphics g){
            for (Alien alien : world.getAliens()){
                if (alien.isAlive()){
                    g.drawImage(alien.getImage(),alien.getX(),alien.getY(),null,null);
                }
            }
        }

        private void drawBullet(Graphics g){
            if (world.getSpaceship().isAlive()){
                Bullet bullet = world.bulletPool.getBullet(world.getSpaceship().getX()+20, world.getSpaceship().getY()-20,1,1);
                g.drawImage(bullet.getImage(), world.getSpaceship().getX()+11, world.getSpaceship().getY()-20,null,null);
                System.out.println("Fire");
            }
        }
    }

    class Controller extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            Spaceship spaceship = world.getSpaceship();
            if(e.getKeyCode() == KeyEvent.VK_A) {
                Command c = new CommandTurnWest(spaceship);
                c.execute();
                System.out.println("left" + world.getSpaceship().getX());

            } else if(e.getKeyCode() == KeyEvent.VK_D){
                Command c = new CommandTurnEast(spaceship);
                c.execute();
                System.out.println("right" + world.getSpaceship().getX());
            }

            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                Command c = new CommandShoot(spaceship, world);
                c.execute();
                System.out.println("Shoot");

            } else if (e.getKeyCode() == KeyEvent.VK_L) {
                // Laser gun
                System.out.println("Laser");

            } else if (e.getKeyCode() == KeyEvent.VK_B) {
                // Bomb
                System.out.println("Bomb");
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

            Spaceship spaceship = world.getSpaceship();
            if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
                Command c = new CommandStop(spaceship);
                c.execute();
            }
        }
    }

    public static void main(String[] args) {
        Window window = new Window();
        window.start();
    }
}
