package keyhoh.business.type.volume;

import keyhoh.business.util.IntSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuantityTest {
    static IntStream positiveIntStream() {
        return IntSource.intStream().filter(i -> i >= 0);
    }

    static IntStream negativeIntStream() {
        return IntSource.intStream().filter(i -> i < 0);
    }

    @ParameterizedTest
    @MethodSource("positiveIntStream")
    void constructor_does_not_throw(final int value) {
        assertDoesNotThrow(() -> new Quantity(value));
    }

    @ParameterizedTest
    @MethodSource("negativeIntStream")
    void constructor_throws_IllegalArgumentException(final int value) {
        assertThrows(IllegalArgumentException.class, () -> new Quantity(value));
    }
}