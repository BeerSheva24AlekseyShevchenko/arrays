package telran.util.test.comparators;

import java.util.Comparator;

public class ComparatorEvenOdd implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        int res;
        boolean isEvenO1 = o1 % 2 == 0;
        boolean isEvenO2 = o2 % 2 == 0;

        if (isEvenO1 == isEvenO2) {
            int cmp = Integer.compare(o1, o2);
            res = isEvenO1 ? cmp : -cmp;
        } else {
            res = isEvenO1 ? -1 : 1;
        }

        return res;
    }
}
