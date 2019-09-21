package ONPU.May;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        Square square = new Square();
        Squares squares;
        Pyramid pyramid = new Pyramid();
        Pyramids pyramids;

        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество квадратов: ");
        int numSquares = in.nextInt();

        squares = new Squares(numSquares);
        int side;
        for (int i = 0; i < numSquares; i++) {
            side = -1;
            while (square.CheckCorrectSide("" + (side = (int) (Math.random() * 11 - 5))) < 0) {
            }
            square = new Square(side);
            squares.setSquareAt(i,square);
        }

        System.out.println("Введите количество пирамид: ");
        int numPyramid = in.nextInt();
        pyramids = new Pyramids(numPyramid);

        int apothem;
        for (int i = 0; i < numPyramid; i++) {
            side = -1;
            apothem = -1;
            while (pyramid.CheckCorrectSide("" + (side = (int) (Math.random() * 11 - 5))) < 0 ||
                    pyramid.CheckCorrectApothem("" + (apothem = (int) (Math.random() * 11 + 5))) < 0) {
            }
            pyramid = new Pyramid(side, apothem);
            pyramids.setPyramidAt(i, pyramid);
        }

        System.out.printf(squares.toString() + "\n" + pyramids.toString());
        System.out.println("\nКвадрат с минимальной площадью: " + squares.getSquares()[squares.minSquare()]);

        apothem =(int) (Math.random() * 11 + 2);
        System.out.println("Количество пирамид, апофемы которых больше " + apothem + " : " + pyramids.kolvoPyramid(apothem));

    }
}

