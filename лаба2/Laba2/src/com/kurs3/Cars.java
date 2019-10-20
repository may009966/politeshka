package com.kurs3;

import java.util.Arrays;

public class Cars {
    private Car[] list;

    public Car[] getList() {
        return list;
    }

    public Cars() {
        this.list = new Car[0];
    }

    public Cars(int length) {
        this.list = new Car[length];
    }

    public void resize(int newLength)
    {
        Car[] tempList = new Car[newLength];
        tempList = Arrays.copyOf(this.list, newLength);

        this.list = tempList;
    }

    public void add(Car car, int position) {
        if (position > list.length - 1) {
            this.resize(list.length + 1);
            list[list.length - 1] = car;
        } else if (position > 0 && position < list.length) {
            this.resize(list.length + 1);
            Car subcar = list[position-1];
            Car subcar2;
            list[position - 1] = car;
            for(int i=position; i<list.length-1; i++) {
                subcar2=list[i];
                list[i] = subcar;
                subcar = list[i+1];
                list[i+1] = subcar2;
            }
        }
    }

    public void add(Car car)
    {
        this.resize(list.length + 1);
        list[list.length - 1] = car;
    }

    public Car remove(int position)
    {
        if (position >=0 && position < list.length)
        {
            Car car = list[position-1];
            for (int i = position-1; i < list.length-1; i++) {
                list[i] = list[i+1];
            }

            resize(list.length-1);

            return car;
        }
        return null;
    }

    public void clear()
    {
        resize(0);
    }

    public Cars getWithModelAndColor(String model, String color) {
        Cars sublist = new Cars();
        for (Car car : this.list) {
            if (car.model.equals(model) && car.color.equals(color))
                sublist.add(car);
        }
        return sublist;
    }

    public Car[] deleteWithRegNum(String registrationNumber) {
        Car[] sublist = new Car[0];
        for (Car car : this.list) {
            if (!car.registrationNumber.equals(registrationNumber)) {
                sublist = Arrays.copyOf(sublist, sublist.length + 1);
                sublist[sublist.length - 1] = car;
            }
        }
        this.list = Arrays.copyOf(sublist, sublist.length);

        return this.list;
    }
}
