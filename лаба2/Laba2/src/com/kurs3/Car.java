package com.kurs3;

public class Car {
    String registrationNumber;
    String model;
    int year;
    String color;
    String FIO;
    String address;

    public Car() {
    }

    public Car(String registrationNumber, String model, int year, String color, String FIO, String address) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.year = year;
        this.color = color;
        this.FIO = FIO;
        this.address = address;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static boolean CheckCorrectName(String str){
        return  str.matches("^\\D*$");
    }

    public static boolean CheckCorrectNumber(String str){
        int deposit;
        try {
            deposit = Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", FIO='" + FIO + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
