package report;

import activities.Activity;
import entity.creature.Person;
import entity.creature.Pet;
import entity.device.Device;

import java.util.List;

public class ActivityAndUsageReport {
    private List<Person> people;
    private List<Device> devices;
    private List<Activity> activities;

    public ActivityAndUsageReport(List<Person> people, List<Pet> devices, String activities) {
        this.people = people;
        this.devices = devices;
        this.activities = activities;
    }

    public void generateReport() {
        System.out.println("Activity and Usage Report:");
        System.out.println("----------------------------");
        System.out.println("People:");
        for (Person person : people) {
            System.out.println("- " + person.getName());
        }
        System.out.println("\nDevices:");
        for (Device device : devices) {
            System.out.println("- " + device.getName());
        }
        System.out.println("\nActivities:");
        for (Activity activity : activities) {
            System.out.println("- " + activity.getName());
        }
    }
}