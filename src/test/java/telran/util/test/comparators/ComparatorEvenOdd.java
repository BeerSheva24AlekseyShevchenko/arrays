package telran.util.test.comparators;

import java.util.Comparator;

public class ComparatorEvenOdd implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        int rmdO1 = o1 % 2;
        int rmdO2 = o2 % 2;
        boolean isEvenO1 = rmdO1 == 0;
        boolean isEvenO2 = rmdO2 == 0;

        int res = rmdO1 - rmdO2;

        if (isEvenO1 == isEvenO2) {
            int cmp = Integer.compare(o1, o2);
            res = isEvenO1 ? cmp : -cmp;
        }

        return res;
    }
}
