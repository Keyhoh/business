package keyhoh.business.domain.currency;

import keyhoh.business.util.LongSource;
import keyhoh.business.util.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyTest {
    static LongStream longStreamClosed() {
        return LongSource.longStreamClosed();
    }

    static Stream<Arguments> longPairsClosed() {
        return LongSource.longPairsClosed().map(Pair::toArguments);
    }

    static Stream<Arguments> longPairsBoundary() {
        return Stream.of(
                new Pair<>(Long.MIN_VALUE, Long.MIN_VALUE),
                new Pair<>(Long.MIN_VALUE, Long.MAX_VALUE),
                new Pair<>(Long.MAX_VALUE, Long.MIN_VALUE),
                new Pair<>(Long.MAX_VALUE, Long.MAX_VALUE)
        ).map(Pair::toArguments);
    }

    @ParameterizedTest
    @MethodSource("longStreamClosed")
    void longConstruct(final long value) {
        assertEquals(new Currency(value), new Currency(value));
    }

    @ParameterizedTest
    @MethodSource("longPairsClosed")
    void addLong(final long a, final long b) {
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.add(y), new Currency(BigInteger.valueOf(a).add(BigInteger.valueOf(b))));
    }

    @ParameterizedTest
    @MethodSource("longPairsBoundary")
    void addLong_on_boundary(final long a, final long b) {
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.add(y), new Currency(BigInteger.valueOf(a).add(BigInteger.valueOf(b))));
    }

    @ParameterizedTest
    @MethodSource("longPairsClosed")
    void subtractLong(final long a, final long b) {
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.subtract(y), new Currency(BigInteger.valueOf(a).subtract(BigInteger.valueOf(b))));
    }

    @ParameterizedTest
    @MethodSource("longPairsBoundary")
    void subtractLong_on_boundary(final long a, final long b) {
        final Currency x = new Currency(a);
        final Currency y = new Currency(b);
        assertEquals(x.subtract(y), new Currency(BigInteger.valueOf(a).subtract(BigInteger.valueOf(b))));
    }
}