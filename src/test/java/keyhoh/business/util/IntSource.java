package keyhoh.business.util;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntSource {
    public static final int[] ints = {1, 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public static IntStream intStream() {
        return Stream.of(IntStream.of(0, Integer.MAX_VALUE, Integer.MIN_VALUE), IntStream.of(ints), IntStream.of(ints).map(i -> -i)).flatMapToInt(i -> i);
    }

    public static Stream<Pair<Integer>> intPairs() {
        return intStream().boxed().flatMap(i -> intStream().mapToObj(j -> new Pair<>(i, j))).filter(p -> p.x() <= p.y());
    }
}
