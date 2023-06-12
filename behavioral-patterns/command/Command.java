class Command {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light();
        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.pressButton();
        remoteControl.setCommand(new LightOffCommand(light));
        remoteControl.pressButton();

        Airconditioner airconditioner = new Airconditioner();
        remoteControl.setCommand(new AirconditionerOnCommand(airconditioner));
        remoteControl.pressButton();
        remoteControl.setCommand(new AirconditionerOffCommand(airconditioner));
        remoteControl.pressButton();
    }
}

// Invoker
class RemoteControl {
    private CommandI command;

    public void setCommand(CommandI command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Command Interface
interface CommandI {
    public void execute();
}

// Concrete Commands/Receivers
class LightOnCommand implements CommandI {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

class LightOffCommand implements CommandI {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}

class Light {
    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }
}

class AirconditionerOnCommand implements CommandI {
    private Airconditioner airconditioner;

    public AirconditionerOnCommand(Airconditioner airconditioner) {
        this.airconditioner = airconditioner;
    }

    public void execute() {
        airconditioner.on();
    }
}

class AirconditionerOffCommand implements CommandI {
    private Airconditioner airconditioner;

    public AirconditionerOffCommand(Airconditioner airconditioner) {
        this.airconditioner = airconditioner;
    }

    public void execute() {
        airconditioner.off();
    }
}

class Airconditioner {
    public void on() {
        System.out.println("Airconditioner is on");
    }

    public void off() {
        System.out.println("Airconditioner is off");
    }
}