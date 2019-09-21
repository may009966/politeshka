package ONPU.May;

public class Pyramid extends ONPU.May.Square {


    public double apothem;

    public double getApothem() {
        return apothem;
    }

    public void setApothem(double apothem) {
        this.apothem = apothem;
    }

    public static double CheckCorrectApothem(String value) {
        double apothem = -1;
        try {
            apothem = Double.parseDouble(value) > 0 ? Double.parseDouble(value) : -1;
        } catch (Exception e) {

        }
        return apothem;
    }

    public Pyramid() {
    }

    public Pyramid(double side, double apothem) {
        super(side);
        this.apothem = apothem;
    }

    public double Height() {
        return Math.sqrt((Math.pow(apothem, 2) - Math.pow((side / 2), 2)));
    }

    @Override
    public double area() {
        return side * side + 2 * apothem * side;
    }

    public double Voluem() {
        return area() * Height() / 3;
    }

    @Override
    public String toString() {
        return  "\n" + "{ Сторона = " + side +
                " Апофема=" + apothem +
                " Высота: " + Height() +
                " Полная площадь: " + area() +
                " Обьем: " + Voluem() +
                '}';
    }
}
