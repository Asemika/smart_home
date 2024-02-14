package report;

import entity.creature.Person;
import entity.creature.Pet;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Represents a report generator for activity and device usage.
 */
public class ActivityAndUsageReport implements Reportable {
    private List<Person> people;
    private List<Pet> pets;
    private String folderForReports;

    /**
     * Constructs an ActivityAndUsageReport object with the specified parameters.
     * @param people The list of people to include in the report.
     * @param pets The list of pets to include in the report.
     * @param folderForReports The folder path where the report will be saved.
     */
    public ActivityAndUsageReport(List<Person> people, List<Pet> pets, String folderForReports) {
        this.people = people;
        this.pets = pets;
        this.folderForReports = folderForReports;
    }

    /**
     * Generates the activity and usage report.
     */
    @Override
    public void generateReport() {
        try {
            FileWriter writer = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\reports\\" + folderForReports + "\\" + "activityAndUsageReport.txt");
            writer.write("People:\n");
            for (Person person : people) {
                writer.write(person.getName() + ":\n");
                writer.write("  TV: " + person.getPersonActivityAPI().getTvCounter() + "\n");
                writer.write("  Fridge: " + person.getPersonActivityAPI().getFridgeCounter() + "\n");
                writer.write("  SmartSpeaker: " + person.getPersonActivityAPI().getSmartSpeakerCounter() + "\n");
                writer.write("  Oven: " + person.getPersonActivityAPI().getOvenCounter() + "\n");
                writer.write("  Microwave: " + person.getPersonActivityAPI().getMicrowaveCounter() + "\n");
                writer.write("  WashingMachine: " + person.getPersonActivityAPI().getWashingMachineCounter() + "\n");
                writer.write("  Blinds: " + person.getPersonActivityAPI().getBlindsCounter() + "\n");
                writer.write("  AirCondition: " + person.getPersonActivityAPI().getAirConditionCounter() + "\n");
                writer.write("  Windows: " + person.getPersonActivityAPI().getWindowsCounter() + "\n");
                writer.write("  Car: " + person.getPersonActivityAPI().getCarCounter() + "\n");
                writer.write("  Bicycle: " + person.getPersonActivityAPI().getBicycleCounter() + "\n");
                writer.write("  Skis: " + person.getPersonActivityAPI().getSkiCounter() + "\n");
                writer.write("  LightSystem: " + person.getPersonActivityAPI().getLightSystemCounter() + "\n");
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
