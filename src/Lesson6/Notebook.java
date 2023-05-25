package Lesson6;

public class Notebook {
    private int ram;
    private int storage;
    private String operatingSystem;
    private String color;
    private String brand;
    private double screenSize;
    private String hardDriveType;

    public Notebook(int ram, int storage, String operatingSystem, String color, String brand, double screenSize, String hardDriveType) {
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.brand = brand;
        this.screenSize = screenSize;
        this.hardDriveType = hardDriveType;
    }

    // Геттеры и сеттеры для полей класса

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getHardDriveType() {
        return hardDriveType;
    }

    public void setHardDriveType(String hardDriveType) {
        this.hardDriveType = hardDriveType;
    }

    @Override
    public String toString() {
        return brand + " " + screenSize + "\", " + color + ", ОЗУ (RAM) = " + ram + "ГБ, " + hardDriveType + " = " + storage + "ГБ, Операционная система: " + operatingSystem;
    }
}


