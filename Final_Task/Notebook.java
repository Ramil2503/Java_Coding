package Final_Task;

public class Notebook {
    private String brand;
    private int ram;
    private int storageCapacity;
    private String operatingSystem;
    private String color;

    public Notebook(String brand, int ram, int storageCapacity, String operatingSystem, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storageCapacity = storageCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRAM() {
        return ram;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
}
