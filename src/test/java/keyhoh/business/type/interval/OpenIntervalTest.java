package keyhoh.business.type.interval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OpenIntervalTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void has(final int x) {
        final OpenInterval<Integer> half = new OpenInterval<>(0, 3);
        assertTrue(half.has(x));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 3, 4})
    void not_has(final int x) {
        final OpenInterval<Integer> half = new OpenInterval<>(0, 3);
        assertFalse(half.has(x));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3, 4})
    void empty(final int x) {
        final OpenInterval<Integer> half = new OpenInterval<>(3, 0);
        assertFalse(half.has(x));
    }

}