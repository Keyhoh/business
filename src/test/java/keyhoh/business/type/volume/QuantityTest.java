package keyhoh.business.type.volume;

import keyhoh.business.util.LongSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuantityTest {
    static LongStream positiveLongStream() {
        return LongSource.longStream().filter(l -> l >= 0);
    }

    static LongStream negativeLongStream() {
        return LongSource.longStream().filter(l -> l < 0);
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
}