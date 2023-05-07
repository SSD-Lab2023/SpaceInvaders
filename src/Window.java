import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Window extends JFrame implements Observer {

    private final int SIZE = 600;
    private World world;
    private GridUI gridUI = new GridUI();
    private Renderer renderer = new Renderer();
    public Window(){
        super();
        setTitle("Space Invaders");
        setLayout(new BorderLayout());

        add(renderer, BorderLayout.CENTER);
        add(gridUI, BorderLayout.SOUTH);

        world.addObserver(this);
        setResizable(false);
        setSize(SIZE,SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void start(){
        setVisible(true);
    }
    @Override
    public void update(Observable o, Object arg) {

    }

    class GridUI extends JPanel {
        private JButton startButton;
        public GridUI(){
            startButton = new JButton("Start");
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startButton.setEnabled(false);
                    Window.this.requestFocus();
                    world = new World();
                    start();
                }
            });
            add(startButton);
        }

    }

    class Renderer extends JPanel{

        public Renderer(){

        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            setBackground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        Window window = new Window();
        window.start();
    }
}
