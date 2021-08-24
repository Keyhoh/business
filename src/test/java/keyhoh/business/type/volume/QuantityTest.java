package keyhoh.business.type.volume;

import keyhoh.business.util.LongSource;
import keyhoh.business.util.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {
    static LongStream positiveLongStream() {
        return LongSource.longStreamClosed().filter(l -> l >= 0);
    }

    static LongStream negativeLongStream() {
        return LongSource.longStreamClosed().filter(l -> l < 0);
    }

    static Stream<Arguments> longPairsClosed() {
        return LongSource.longPairsClosed().filter(p -> p.x() >= 0 && p.y() >= 0).map(Pair::toArguments);
    }

    @ParameterizedTest
    @MethodSource("positiveLongStream")
    void constructor_does_not_throw(final long value) {
        assertDoesNotThrow(() -> new Quantity(value));
    }

    @ParameterizedTest
    @MethodSource("negativeLongStream")
    void constructor_throws_IllegalArgumentException(final long value) {
        assertThrows(IllegalArgumentException.class, () -> new Quantity(value));
    }

    @ParameterizedTest
    @MethodSource("longPairsClosed")
    void add(final long a, final long b) {
        final Quantity x = new Quantity(a);
        final Quantity y = new Quantity(b);
        assertEquals(x.add(y).value(), BigInteger.valueOf(a).add(BigInteger.valueOf(b)));
    }

    @ParameterizedTest
    @MethodSource("longPairsClosed")
    void scalar_product(final long value, final long scalar) {
        final Quantity x = new Quantity(value);
        assertEquals(x.multiply(scalar).value(), BigInteger.valueOf(value).multiply(BigInteger.valueOf(scalar)));
    }
}