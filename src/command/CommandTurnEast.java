package command;

import model.Spaceship;

public class CommandTurnEast extends Command{
    public CommandTurnEast(Spaceship spaceship) {
        super(spaceship);
    }

    @Override
    public void execute() {
        getSpaceship().turnEast();
    }
}
