package keyhoh.business.currency;

import keyhoh.business.util.IntSource;
import keyhoh.business.util.LongSource;
import keyhoh.business.util.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.DecimalFormat;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CurrencyTest {
    static IntStream intStream() {
        return IntSource.intStream();
    }

    static LongStream longStream() {
        return LongSource.longStream();
    }

    static Stream<Pair<Integer>> intPairs() {
        return IntSource.intPairs();
    }

    static Stream<Pair<Long>> longPairs() {
        return LongSource.longPairs();
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
        assertEquals(new Currency(value), new Currency(value));
    }

    @ParameterizedTest
    @MethodSource("longStream")
    void longConstruct(final long value) {
        assertEquals(new Currency(value), new Currency(value));
    }

    @ParameterizedTest
    @MethodSource("intPairs")
    void addInt(final Pair<Integer> pair) {
        if (isBound(pair.x()) || isBound(pair.y())) {
            assertTrue(true);
            return;
        }
        final Currency x = new Currency(pair.x());
        final Currency y = new Currency(pair.y());
        assertEquals(x.add(y), new Currency(pair.x() + pair.y()));
    }

    @ParameterizedTest
    @MethodSource("longPairs")
    void addLong(final Pair<Long> pair) {
        if (isBound(pair.x()) || isBound(pair.y())) {
            assertTrue(true);
            return;
        }
        final Currency x = new Currency(pair.x());
        final Currency y = new Currency(pair.y());
        assertEquals(x.add(y), new Currency(pair.x() + pair.y()));
    }

    @ParameterizedTest
    @MethodSource("intPairs")
    void subtractInt(final Pair<Integer> pair) {
        if (isBound(pair.x()) || isBound(pair.y())) {
            assertTrue(true);
            return;
        }
        final Currency x = new Currency(pair.x());
        final Currency y = new Currency(pair.y());
        assertEquals(x.subtract(y), new Currency(pair.x() - pair.y()));
    }

    @ParameterizedTest
    @MethodSource("longPairs")
    void subtractLong(final Pair<Long> pair) {
        if (isBound(pair.x()) || isBound(pair.y())) {
            assertTrue(true);
            return;
        }
        final Currency x = new Currency(pair.x());
        final Currency y = new Currency(pair.y());
        assertEquals(x.subtract(y), new Currency(pair.x() - pair.y()));
    }

    @ParameterizedTest
    @MethodSource("intStream")
    void isPositive(final int value) {
        final Currency currency = new Currency(value);
        assertEquals(currency.isPositive(), value >= 0);
    }

    @ParameterizedTest
    @MethodSource("intStream")
    void isNegative(final int value) {
        final Currency currency = new Currency(value);
        assertEquals(currency.isNegative(), value < 0);
    }

    @ParameterizedTest
    @MethodSource("intStream")
    void toFormattedString(final int value) {
        final Currency currency = new Currency(value);
        assertEquals(currency.toFormattedString(), new DecimalFormat("#,####").format(value));
        assertEquals(currency.toFormattedString("#,###"), new DecimalFormat("#,###").format(value));
    }
}