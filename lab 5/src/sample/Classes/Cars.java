package sample.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;

public class Cars extends ArrayList<Car> {
ArrayList<Car> list2;

    public Cars() {
        this.list2 = new ArrayList<>();
    }

    public Cars(int length) {
        this.list2 = new ArrayList<>(length);
    }

    public ArrayList<Car> getList() {
        return list2;
    }

    public void addToList(Car car)
    {
        list2.add(car);
    }

    public Cars getWithModelAndColor(String model, String color) {
        Cars sublist = new Cars();
        for (Car car : this.list2) {
            if (car.model.equals(model) && car.color.equals(color))
                sublist.addToList(car);
        }
        return sublist;
    }

    public ArrayList<Car> deleteWithRegNum(String registrationNumber) {
        this.list2.remove(registrationNumber);
        return this.list2;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "list2=" + list2 +
                '}';
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return null;
    }
}
