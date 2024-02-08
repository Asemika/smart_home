package event;

class SmokeSignalEvent extends Event {
    private boolean isSignalDetected;

    public SmokeSignalEvent() {
        super("Smoke signal event: Smoke signals detected!");
        this.isSignalDetected = false;
    }

    public boolean isSignalDetected() {
        return isSignalDetected;
    }

    public void acknowledgeSignal() {
        isSignalDetected = true;
        System.out.println("Smoke signals acknowledged.");
    }
}