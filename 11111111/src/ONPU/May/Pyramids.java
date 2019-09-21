package ONPU.May;

import java.util.ArrayList;
import java.util.Arrays;

public class Pyramids {

    public Pyramid[] getPyramids() {
        return pyramids;
    }

    public void setPyramidAt(int index, Pyramid pyramid) {
        pyramids[index] = pyramid;
    }

    private Pyramid[] pyramids;

    public Pyramids() {
        pyramids = new Pyramid[0];
    }

    public Pyramids(int length) {
        this.pyramids = new Pyramid[length];
    }

    public int kolvoPyramid(int a) {
        int num = 0;
        for (int i = 0; i < pyramids.length; i++) {
            if (pyramids[i].apothem > a)
                num++;
        }
        return num;
    }

    @Override
    public String toString() {
        return "Pyramids{" +
                "pyramids=" + Arrays.toString(pyramids) +
                '}';
    }
}
