package ONPU.May;

import java.util.ArrayList;
import java.util.Arrays;

public class Squares {

    public Square[] getSquares() {
        return squares;
    }

    public void setSquareAt(int index, Square square) {
        squares[index] = square;
    }

    private Square[] squares;

    public Squares() {
        squares = new Square[0];
    }

    public Squares(int length) {
        this.squares = new Square[length];
    }

    public int minSquare() {
        int minIndex = 0;
        for (int i = 0; i < squares.length; i++) {
            if (squares[minIndex].area() > squares[i].area())
                minIndex = i;
        }
        return minIndex;
    }

    @Override
    public String toString() {
        return "Squares{" +
                "squares=" + Arrays.toString(squares) +
                '}';
    }
}

