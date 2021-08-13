package keyhoh.business.money;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.DecimalFormat;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoneyTest {
    static record Pair<T>(T x, T y) {
    }

    static final int[] ints = {1, 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    static final long[] longs = {1, 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    static IntStream intStream() {
        return Stream.of(IntStream.of(0, Integer.MAX_VALUE, Integer.MIN_VALUE), IntStream.of(ints), IntStream.of(ints).map(i -> -i)).flatMapToInt(i -> i);
    }

    static LongStream longStream() {
        return Stream.of(LongStream.of(0L, Long.MAX_VALUE, Long.MIN_VALUE), LongStream.of(longs), LongStream.of(longs).map(l -> -l)).flatMapToLong(l -> l);
    }

    static Stream<Pair<Integer>> intPairs() {
        return intStream().boxed().flatMap(i -> intStream().mapToObj(j -> new Pair<>(i, j))).filter(p -> p.x() <= p.y());
    }

    static Stream<Pair<Long>> longPairs() {
        return longStream().boxed().flatMap(i -> longStream().mapToObj(j -> new Pair<>(i, j))).filter(p -> p.x() <= p.y());
    }

    static boolean isBound(final Integer i) {
        return i == Integer.MAX_VALUE || i == Integer.MIN_VALUE;
    }

    static boolean isBound(final Long l) {
        return l == Long.MAX_VALUE || l == Long.MIN_VALUE;
    }

    @ParameterizedTest
    @MethodSource("intStream")
    void intConstruct(final int value) {
        assertEquals(new Money(value), new Money(value));
    }

    @ParameterizedTest
    @MethodSource("longStream")
    void longConstruct(final long value) {
        assertEquals(new Money(value), new Money(value));
    }

    @ParameterizedTest
    @MethodSource("intPairs")
    void addInt(final Pair<Integer> pair) {
        if (isBound(pair.x()) || isBound(pair.y())) {
            assertTrue(true);
            return;
        }
        final Money x = new Money(pair.x());
        final Money y = new Money(pair.y());
        assertEquals(x.add(y), new Money(pair.x() + pair.y()));
    }

    @ParameterizedTest
    @MethodSource("longPairs")
    void addLong(final Pair<Long> pair) {
        if (isBound(pair.x()) || isBound(pair.y())) {
            assertTrue(true);
            return;
        }
        final Money x = new Money(pair.x());
        final Money y = new Money(pair.y());
        assertEquals(x.add(y), new Money(pair.x() + pair.y()));
    }

    @ParameterizedTest
    @MethodSource("intPairs")
    void subtractInt(final Pair<Integer> pair) {
        if (isBound(pair.x()) || isBound(pair.y())) {
            assertTrue(true);
            return;
        }
        final Money x = new Money(pair.x());
        final Money y = new Money(pair.y());
        assertEquals(x.subtract(y), new Money(pair.x() - pair.y()));
    }

    @ParameterizedTest
    @MethodSource("longPairs")
    void subtractLong(final Pair<Long> pair) {
        if (isBound(pair.x()) || isBound(pair.y())) {
            assertTrue(true);
            return;
        }
        final Money x = new Money(pair.x());
        final Money y = new Money(pair.y());
        assertEquals(x.subtract(y), new Money(pair.x() - pair.y()));
    }

    @ParameterizedTest
    @MethodSource("intStream")
    void isPositive(final int value) {
        final Money money = new Money(value);
        assertEquals(money.isPositive(), value >= 0);
    }

    @ParameterizedTest
    @MethodSource("intStream")
    void isNegative(final int value) {
        final Money money = new Money(value);
        assertEquals(money.isNegative(), value < 0);
    }

    @ParameterizedTest
    @MethodSource("intStream")
    void toFormattedString(final int value) {
        final Money money = new Money(value);
        assertEquals(money.toFormattedString(), new DecimalFormat("#,####").format(value));
        assertEquals(money.toFormattedString("#,###"), new DecimalFormat("#,###").format(value));
    }
}