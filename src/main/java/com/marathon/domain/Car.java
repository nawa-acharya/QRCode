package com.marathon.domain;

public class Car {
    private Long id;
    private String make;
    private String model;
    private String year;
    private String color;
    private String licenseNumber;
    private QRModel qrModel;
    private Resident resident;

    //constructor
    public Car() {
    }

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public QRModel getQrModel() {
        return qrModel;
    }

    public void setQrModel(QRModel qrModel) {
        this.qrModel = qrModel;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }
}
