package report;

import entity.device.Device;

import java.util.List;

public class ConsumptionReport {
    private List<Device> devices;

    public ConsumptionReport(List<Device> devices, int i, int i1, String folderForReports) {
        this.devices = devices;
    }

    public void generateReport() {
        System.out.println("Consumption Report:");
        System.out.println("-------------------");
        for (Device device : devices) {
            System.out.println(device.getName() + ":");
            System.out.println("  Active Consumption: " + device.getActiveConsumption());
            System.out.println("  Idle Consumption: " + device.getIdleConsumption());
            System.out.println("  Turned Off Consumption: " + device.getTurnedOffConsumption());
        }
    }
}
