package command;
import model.Spaceship;
import model.World;

public class CommadShootBomb extends Command{
    private World world;
    public CommadShootBomb(Spaceship spaceship, World world){
        super(spaceship);
    }


    @Override
    public void execute() {

    }
}
