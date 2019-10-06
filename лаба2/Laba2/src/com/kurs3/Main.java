package com.kurs3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String registrationNumber;
        String model;
        String year;
        String color;
        String FIO;
        String address;

        Cars cars = new Cars(1);

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of Cars: ");
        int num = in.nextInt();

        cars.resize(num);

        for (int i = 0; i < cars.getList().length; i++) {
            System.out.print("Input Registration Number: ");
            registrationNumber = in.nextLine();
            System.out.print("Input model: ");
            while (!Car.CheckCorrectName(model = in.nextLine())) {
            }
            System.out.print("Input year: ");
            while (!Car.CheckCorrectNumber(year = in.nextLine())) {
            }
            System.out.print("Input color: ");
            while (!Car.CheckCorrectName(color = in.nextLine())) {
            }
            System.out.print("Input FIO: ");
            while (!Car.CheckCorrectName(FIO = in.nextLine())) {
            }
            System.out.print("Input address: ");
            address = in.nextLine();
            cars.add(new Car(registrationNumber, model, Integer.parseInt(year), color, FIO, address));
        }

        System.out.printf(Arrays.toString(cars.getList()) + "\n");

        System.out.print("Input Registration Number: ");
        registrationNumber = in.nextLine();
        System.out.print("Input model: ");
        while (!Car.CheckCorrectName(model = in.nextLine())) {
        }
        System.out.print("Input year: ");
        while (!Car.CheckCorrectNumber(year = in.nextLine())) {
        }
        System.out.print("Input color: ");
        while (!Car.CheckCorrectName(color = in.nextLine())) {
        }
        System.out.print("Input FIO: ");
        while (!Car.CheckCorrectName(FIO = in.nextLine())) {
        }
        System.out.print("Input address: ");
        address = in.nextLine();
        cars.add(new Car(registrationNumber, model, Integer.parseInt(year), color, FIO, address));
        System.out.printf(Arrays.toString(cars.getList()));

        cars.clear();
        System.out.printf("\n" + Arrays.toString(cars.getList()));
    }
}
