package keyhoh.business.currency;

import keyhoh.business.util.IntSource;
import keyhoh.business.util.LongSource;
import keyhoh.business.util.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyTest {
    static IntStream intStream() {
        return IntSource.intStreamClosed();
    }

    static LongStream longStream() {
        return LongSource.longStreamClosed();
    }

    static Stream<Arguments> intPairsClosed() {
        return IntSource.intPairsClosed().map(Pair::toArguments);
    }

    static Stream<Arguments> longPairsClosed() {
        return LongSource.longPairs().map(Pair::toArguments);
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
    @MethodSource("intPairsClosed")
    void addInt(final int a, final int b) {
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.add(y), new Currency(BigInteger.valueOf(a).add(BigInteger.valueOf(b))));
    }

    @ParameterizedTest
    @MethodSource("longPairsClosed")
    void addLong(final long a, final long b) {
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.add(y), new Currency(BigInteger.valueOf(a).add(BigInteger.valueOf(b))));
    }

    @ParameterizedTest
    @MethodSource("intPairsClosed")
    void subtractInt(final int a, final int b) {
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.subtract(y), new Currency(BigInteger.valueOf(a).subtract(BigInteger.valueOf(b))));
    }

    @ParameterizedTest
    @MethodSource("longPairsClosed")
    void subtractLong(final long a, final long b) {
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.subtract(y), new Currency(BigInteger.valueOf(a).subtract(BigInteger.valueOf(b))));
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