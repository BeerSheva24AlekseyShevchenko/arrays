package telran.util.test.comparators;

import java.util.function.Predicate;

public class PredicateOddNumbers implements Predicate<Integer> {

    @Override
    public boolean test(Integer t) {
        return t % 2 != 0;
    }

}
