package keyhoh.business.type;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RangeTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void has(final int x) {
        final Range<Integer> range = new Range<>(0, 3);
        assertTrue(range.has(x));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 4})
    void not_has(final int x) {
        final Range<Integer> range = new Range<>(0, 3);
        assertFalse(range.has(x));
    }
}