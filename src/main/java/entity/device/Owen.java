package entity.device;

public class Owen extends Device{
    private final double timer;
    private final int rezhim;
    private final int degree;

    public Owen(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption, double timer, int rezhim, int degree) {
        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
        this.timer = timer;
        this.rezhim = rezhim;
        this.degree = degree;
    }
    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Owen is now turned on.");
    }

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println("Owen is now turned off.");
    }
    public int getDegree(){
        return degree;
    }
    public double getTimer(){
        return timer;
    }
    public int getRezhim(){
        return rezhim;
    }
}
