package keyhoh.business.util;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class LongSource {
    public static final long[] longs = {1, 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public static LongStream longStream() {
        return Stream.of(LongStream.of(0L, Long.MAX_VALUE, Long.MIN_VALUE), LongStream.of(longs), LongStream.of(longs).map(l -> -l)).flatMapToLong(l -> l);
    }

    public static Stream<Pair<Long>> longPairs() {
        return longStream().boxed().flatMap(i -> longStream().mapToObj(j -> new Pair<>(i, j))).filter(p -> p.x() <= p.y());
    }
}
