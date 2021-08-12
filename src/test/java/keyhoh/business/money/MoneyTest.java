package keyhoh.business.money;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {
    @Test
    void add() {
        final Money x = new Money(BigInteger.ONE);
        final Money y = new Money(BigInteger.TWO);
        assertEquals(x.add(y), new Money(BigInteger.valueOf(3)));
    }

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