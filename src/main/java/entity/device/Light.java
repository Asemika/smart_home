//package entity.device;
//
//import event.Event;
//import house.Room;
//import systems.WaterLeakSystem;
//
///**
// * Represents a light system in a smart home.
// */
//public class Light extends Device {
//
//    public Light() {
//    }
//
//
//    public void turnLightOn(Room room) {
//        getElectricityAPI().increaseCounter(getkWPerHour());
//        room.setLightIsOn(true);
//    }
//
//    public void turnLightOff(Room room) {
//        room.setLightIsOn(false);
//    }
//
//}
