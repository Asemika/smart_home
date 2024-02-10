package entity.device.remote;

import entity.device.AirCondition;

interface Command {
    void execute();
}

class TurnOnCommand implements Command {
    private AirCondition airCondition;

    public TurnOnCommand(AirCondition airCondition) {
        this.airCondition = airCondition;
    }

    @Override
    public void execute() {
        airCondition.turnOn();
    }
}

// Concrete command for turning off the air conditioner
class TurnOffCommand implements Command {
    private AirCondition airCondition;

    public TurnOffCommand(AirCondition airCondition) {
        this.airCondition = airCondition;
    }

    @Override
    public void execute() {
        airCondition.turnOff();
    }
}

// Class representing the remote control for the air conditioner using commands
public class AirConditionRemote {
    private Command turnOnCommand;
    private Command turnOffCommand;

    /**
     * Constructor to initialize the remote control with the air conditioner
     * @param airCondition The air conditioner object to control
     */
    public AirConditionRemote(AirCondition airCondition) {
        this.turnOnCommand = new TurnOnCommand(airCondition);
        this.turnOffCommand = new TurnOffCommand(airCondition);
    }

    /**
     * Method to turn on the air conditioner via the remote control
     */
    public void turnOn() {
        turnOnCommand.execute();
        System.out.println("Air conditioner is turned on via remote.");
    }

    /**
     * Method to turn off the air conditioner via the remote control
     */
    public void turnOff() {
        turnOffCommand.execute();
        System.out.println("Air conditioner is turned off via remote.");
    }
}
