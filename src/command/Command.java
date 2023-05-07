package command;
import model.Spaceship;

public abstract class Command {
    private Spaceship spaceship;

    public Command(Spaceship spaceship) {
        this.spaceship = spaceship;
    }
    public Spaceship getSpaceship() {
        return spaceship;
    }
    public abstract void execute();
}

