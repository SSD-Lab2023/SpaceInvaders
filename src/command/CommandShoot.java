package command;
import model.Spaceship;
import model.World;


public class CommandShoot extends Command{

    private World world;
    public CommandShoot(Spaceship spaceship, World world) {
        super(spaceship);

    }
    @Override
    public void execute() {
    }
}