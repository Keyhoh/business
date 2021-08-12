package keyhoh.business.money;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -64, -32, -16, -8, -4, -2, 0, 2, 4, 16, 32, 64, Integer.MAX_VALUE})
    void intConstruct(final int value) {
        assertEquals(new Money(value), new Money(value));
    }

    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, -64L, -32L, -16L, -8L, -4L, -2L, 0L, 2L, 4L, 16L, 32L, 64L, Long.MAX_VALUE})
    void longConstruct(final long value) {
        assertEquals(new Money(value), new Money(value));
    }

    @Test
    void add() {
        final Money x = new Money(1);
        final Money y = new Money(2);
        assertEquals(x.add(y), new Money(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    void isPositive(final int value) {
        final Money money = new Money(value);
        assertEquals(money.isPositive(), value >= 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    void isNegative(final int value) {
        final Money money = new Money(value);
        assertEquals(money.isNegative(), value < 0);
    }
}