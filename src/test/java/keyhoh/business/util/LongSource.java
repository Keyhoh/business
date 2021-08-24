package keyhoh.business.util;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class LongSource {
    public static LongStream longStreamClosed(final long start, final long stop) {
        final BigDecimal s = BigDecimal.valueOf(start);
        final BigDecimal l = BigDecimal.valueOf(stop).subtract(s).add(BigDecimal.ONE);
        final Set<Long> set = new HashSet<>();
        while (set.size() < 4096) {
            set.add(BigDecimal.valueOf(Math.random()).multiply(l).add(s).longValue());
        }
        return set.parallelStream().mapToLong(i -> i);
    }

    public static LongStream longStreamClosed() {
        return longStreamClosed(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static LongStream longStream(final long start, final long end) {
        return longStreamClosed(start, end - 1);
    }

    public static LongStream longStream() {
        return longStream(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static Stream<Pair<Long, Long>> longPairsClosed() {
        final List<Long> x = longStreamClosed().boxed().toList();
        final List<Long> y = longStreamClosed().boxed().toList();
        final Set<Pair<Long, Long>> pairs = new HashSet<>();
        for (int i = 0; i < x.size(); i++) {
            pairs.add(new Pair<>(x.get(i), y.get(i)));
        }
        return pairs.stream();
    }
}
