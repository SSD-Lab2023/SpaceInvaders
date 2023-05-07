package command;
import model.Spaceship;
import model.World;


public class CommandShootLaser extends Command{

    private World world;
    public CommandShootLaser(Spaceship spaceship, World world) {
        super(spaceship);

    }
    @Override
    public void execute() {
    }
}
