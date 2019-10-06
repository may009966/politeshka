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
        if (position > list.length-1) {
            this.resize(position);
            list[position-1] = car;
        }
        else if (position > 0 && position < list.length)
            list[position-1] = car;
    }

    public void add(Car car)
    {
        int i = list.length-1;
        for (; i >= 0 && list[i] != null; i--);

        if (i == -1) {
            resize(list.length + 1);
            list[list.length-1] = car;
        }
        else
            list[i] = car;
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
}
