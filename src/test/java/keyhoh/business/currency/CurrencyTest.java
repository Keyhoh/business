package keyhoh.business.currency;

import keyhoh.business.util.IntSource;
import keyhoh.business.util.LongSource;
import keyhoh.business.util.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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

    static IntStream intStreamWithoutBounds() {
        return IntSource.intStream().filter(i -> !isBound(i));
    }

    static LongStream longStream() {
        return LongSource.longStream();
    }

    static Stream<Arguments> intPairs() {
        return IntSource.intPairs().map(Pair::toArguments);
    }

    static Stream<Arguments> longPairs() {
        return LongSource.longPairs().map(Pair::toArguments);
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
    void addInt(final int a, final int b) {
        if (isBound(a) || isBound(b)) {
            assertTrue(true);
            return;
        }
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.add(y), new Currency(a + b));
    }

    @ParameterizedTest
    @MethodSource("longPairs")
    void addLong(final long a, final long b) {
        if (isBound(a) || isBound(b)) {
            assertTrue(true);
            return;
        }
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.add(y), new Currency(a + b));
    }

    @ParameterizedTest
    @MethodSource("intPairs")
    void subtractInt(final int a, final int b) {
        if (isBound(a) || isBound(b)) {
            assertTrue(true);
            return;
        }
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.subtract(y), new Currency(a - b));
    }

    @ParameterizedTest
    @MethodSource("longPairs")
    void subtractLong(final long a, final long b) {
        if (isBound(a) || isBound(b)) {
            assertTrue(true);
            return;
        }
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.subtract(y), new Currency(a - b));
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