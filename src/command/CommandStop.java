package command;

import model.Spaceship;

public class CommandStop extends Command{
    public CommandStop(Spaceship spaceship) {
        super(spaceship);
    }

    @Override
    public void execute() {
        getSpaceship().stop();
    }
}
