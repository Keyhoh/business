package keyhoh.business.money;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    void isPositive(final int value) {
        final Money money = new Money(BigInteger.valueOf(value));
        assertEquals(money.isPositive(), value >= 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    void isNegative(final int value) {
        final Money money = new Money(BigInteger.valueOf(value));
        assertEquals(money.isNegative(), value < 0);
    }
}