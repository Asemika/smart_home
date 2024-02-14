//package event;
//
//public class SmokeSignalEvent extends Event {
//    private boolean isSignalDetected;
//    private String description;
//
//    public SmokeSignalEvent() {
//        super("Smoke signal event: Smoke signals detected!");
//        this.isSignalDetected = false;
//    }
//
//    public boolean isSignalDetected() {
//        return isSignalDetected;
//    }
//
//    public void acknowledgeSignal() {
//        isSignalDetected = true;
//        System.out.println("Smoke signals acknowledged.");
//    }
//
//    public String getDescription() {
//        return description;
//    }
//}