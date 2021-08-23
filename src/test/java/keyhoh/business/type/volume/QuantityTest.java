package keyhoh.business.type.volume;

import keyhoh.business.util.LongSource;
import keyhoh.business.util.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {
    static LongStream positiveLongStream() {
        return LongSource.longStream().filter(l -> l >= 0);
    }

    static LongStream negativeLongStream() {
        return LongSource.longStream().filter(l -> l < 0);
    }

    static Stream<Pair<Long>> longPairs() {
        return LongSource.longPairs().filter(p -> p.x() >= 0 && p.y() >= 0);
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
    @MethodSource("longPairs")
    void add(final Pair<Long> pair) {
        final Quantity x = new Quantity(pair.x());
        final Quantity y = new Quantity(pair.y());
        assertEquals(x.add(y).value(), BigInteger.valueOf(pair.x()).add(BigInteger.valueOf(pair.y())));
    }

    @ParameterizedTest
    @MethodSource("longPairs")
    void scalar_product(final Pair<Long> pair) {
        final Quantity x = new Quantity(pair.x());
        assertEquals(x.multiply(pair.y()).value(), BigInteger.valueOf(pair.x()).multiply(BigInteger.valueOf(pair.y())));
    }
}