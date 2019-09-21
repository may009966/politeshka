package ONPU.May;

public class Square extends ONPU.May.Main {


    public double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public static double CheckCorrectSide(String value) {
        double side = -1;
        try {
            side = Double.parseDouble(value) > 0 ? Double.parseDouble(value) : -1;
        } catch (Exception e) {

        }
        return side;
    }

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public double diagonal() {
        return side * Math.sqrt(2);
    }

    public double perimeter() {
        return side * 4;
    }

    public double area() {
        return side * side;
    }

    @Override
    public String toString() {
        return "\n{" +
                " Сторона: " + side +
                " Диагональ: " + diagonal() +
                " Периметр: " + perimeter() +
                " Площадь: " + area() +
                '}';
    }
}
