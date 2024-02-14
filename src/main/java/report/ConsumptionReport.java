package report;

import entity.device.Device;
import entity.device.WashingMachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Represents a report generator for consumption (electricity and water).
 */
public class ConsumptionReport implements Reportable {
    private final List<Device> devices;
    private final int pricePerKw;
    private final int pricePerLitre;
    private final String folderForReports;

    /**
     * Constructs a ConsumptionReport object with the specified parameters.
     * @param devices The list of devices to include in the report.
     * @param pricePerKw The price per kilowatt-hour.
     * @param pricePerLitre The price per litre of water.
     * @param folderForReports The folder path where the report will be saved.
     */
    public ConsumptionReport(List<Device> devices, int pricePerKw, int pricePerLitre, String folderForReports) {
        this.devices = devices;
        this.pricePerKw = pricePerKw;
        this.pricePerLitre = pricePerLitre;
        this.folderForReports = folderForReports;
    }

    /**
     * Generates the consumption report.
     */
    @Override
    public void generateReport() {
        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\reports\\" + folderForReports + "\\consumptionReport.txt");
            FileWriter myWriter = new FileWriter(file);
            myWriter.write("Electricity consumption: \n");
            for (Device device : devices) {
                myWriter.write(device + " : " + device.getElectricityAPI().getSpentKilowatts() +
                        "kW - " + pricePerKw * device.getElectricityAPI().getSpentKilowatts() + "$\n");
            }
            myWriter.write("\nWater consumption: \n");
            for (Device device : devices) {
                if (device instanceof WashingMachine)
                    myWriter.write(device + " : " + ((WashingMachine) device).getWaterAPI().getSpentWaterAmount() +
                            "L - " + pricePerLitre * ((WashingMachine) device).getWaterAPI().getSpentWaterAmount() + "$\n");
            }

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
