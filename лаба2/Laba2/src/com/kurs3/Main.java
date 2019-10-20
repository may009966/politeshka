package com.kurs3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner in;

    public static void main(String[] args) {
       Cars cars = new Cars(1);

        in = new Scanner(System.in);
        int num = -1;
        boolean check = false;
        do {
            try {
                System.out.print("Input a number of cars: ");
                String number = in.nextLine();
                num = Integer.parseInt(number);
                if (num > 0)
                    check = true;
            } catch (InputMismatchException exc) {
                System.out.println(exc.getLocalizedMessage());
            } catch (Exception exc) {
                System.out.println(exc.getLocalizedMessage());
            }
        } while (!check);

        for (int i = 0; i < num; i++) {
            cars.add(getNewCar());
        }

        System.out.println(cars);

        cars.add(getNewCar(), 2);
        System.out.println(cars);

        System.out.println("Enter model and color: ");
        System.out.println("Cars with model and color car: " + cars.getWithModelAndColor(in.nextLine(), in.nextLine()));

        System.out.println("Enter registration Number for delete: ");
        System.out.println("Cars without registration Number : " + Arrays.toString(cars.deleteWithRegNum(in.nextLine())));

        cars.clear();
        System.out.printf("\n" + Arrays.toString(cars.getList()));
    }

    private static Car getNewCar() {
        String registrationNumber;
        String model;
        String year;
        String color;
        String FIO;
        String address;

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
        return new Car(registrationNumber, model, Integer.parseInt(year), color, FIO, address);
    }
}
