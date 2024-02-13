
package entity.device;

import event.Event;
import systems.WaterLeakSystem;

public class Microwave extends Device {
    @Override
    public void notifySystem() {

    }

    @Override
    public void attach(WaterLeakSystem waterLeakSystem) {

    }

    @Override
    public void increaseTemp(int temp) {

    }

    @Override
    public void decreaseTemp(int temp) {

    }

    @Override
    public void update(Event event, Fridge fridge) {

    }
    // nenuzhny class tut pusto

//    public void heatFood(Food food) {
//        food.heatFood();
//        getElectricityAPI().increaseCounter(getkWPerHour());
//    }
}

//package entity.device;
//
//public class Microwave extends Device{
//    private MicrowaveMode mode;
//    private double power; // Мощность микроволновки в Ваттах
//    private int timeInSeconds; // Время работы микроволновки в секундах
//
//    public Microwave(String name, DeviceType type, double activeConsumption, double idleConsumption, double turnedOffConsumption) {
//        super(name, type, activeConsumption, idleConsumption, turnedOffConsumption);
//    }
//
//    public void setMode(MicrowaveMode mode) {
//        this.mode = mode;
//    }
//
//    public void executeMode() {
//        if (mode != null) {
//            mode.execute();
//        } else {
//            System.out.println("No mode set for microwave.");
//        }
//    }
//
//    public double getPower() {
//        return power;
//    }
//
//    public void setPower(double power) {
//        this.power = power;
//    }
//
//    public int getTimeInSeconds() {
//        return timeInSeconds;
//    }
//
//    public void setTimeInSeconds(int timeInSeconds) {
//        this.timeInSeconds = timeInSeconds;
//    }
//
//    @Override
//    public void turnOn() {
//        super.turnOn();
//        System.out.println("Microwave is now turned on.");
//    }
//
//    @Override
//    public void turnOff() {
//        super.turnOff();
//        System.out.println("Microwave is now turned off.");
//    }
//
//    @Override
//    public Object getElectricityAPI() {
//        return null;
//    }
//}
