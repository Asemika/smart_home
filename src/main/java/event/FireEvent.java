package event;

class FireEvent extends Event {
    private boolean isFireExtinguished;

    public FireEvent() {
        super("Fire event: There is a fire in the house!");
        this.isFireExtinguished = false;
    }

    public boolean isFireExtinguished() {
        return isFireExtinguished;
    }

    public void extinguishFire() {
        isFireExtinguished = true;
        System.out.println("The fire has been extinguished.");
    }
}