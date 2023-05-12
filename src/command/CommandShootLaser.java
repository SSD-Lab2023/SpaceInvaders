package command;
import model.Spaceship;
import model.World;


public class CommandShootLaser extends Command{

    private World world;
    public CommandShootLaser(Spaceship spaceship, World world) {
        super(spaceship);
        this.world = world;

    }
    @Override
    public void execute() {
        world.laserBeam(getSpaceship());
        world.getSpaceship().setFired(false);
    }
}
