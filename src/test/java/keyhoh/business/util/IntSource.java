package keyhoh.business.util;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntSource {
    public static IntStream intStreamClosed(final int start, final int stop) {
        final BigDecimal s = BigDecimal.valueOf(start);
        final BigDecimal l = BigDecimal.valueOf(stop).subtract(s).add(BigDecimal.ONE);
        final Set<Integer> set = new HashSet<>();
        while (set.size() < 4096) {
            set.add(BigDecimal.valueOf(Math.random()).multiply(l).add(s).intValue());
        }
        return set.parallelStream().mapToInt(i -> i);
    }

    public static IntStream intStreamClosed() {
        return intStreamClosed(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static IntStream intStream(final int start, final int end) {
        return intStreamClosed(start, end - 1);
    }

    public static IntStream intStream() {
        return intStream(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static Stream<Pair<Integer, Integer>> intPairsClosed() {
        final List<Integer> x = intStreamClosed().boxed().toList();
        final List<Integer> y = intStreamClosed().boxed().toList();
        final Set<Pair<Integer, Integer>> pairs = new HashSet<>();
        for (int i = 0; i < x.size(); i++) {
            pairs.add(new Pair<>(x.get(i), y.get(i)));
        }
        return pairs.stream();
    }
}
