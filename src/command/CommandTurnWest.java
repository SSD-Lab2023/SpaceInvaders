package command;

import model.Spaceship;

public class CommandTurnWest extends Command{

    public CommandTurnWest(Spaceship spaceship) {
        super(spaceship);
    }

    @Override
    public void execute() {
        getSpaceship().turnWest();
    }
}

