package command;
import model.Bullet;
import model.Spaceship;
import model.World;


public class CommandShoot extends Command{

    private World world;
    public CommandShoot(Spaceship spaceship, World world) {
        super(spaceship);
        this.world = world;

    }
    @Override
    public void execute() {
        world.shootBullets(getSpaceship());
        world.getSpaceship().setFired(false);

    }
}
