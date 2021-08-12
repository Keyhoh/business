package keyhoh.business.money;

import java.math.BigInteger;

public record Money(BigInteger value) {
    public boolean isPositive() {
        return BigInteger.ZERO.compareTo(this.value) <= 0;
    }

    public boolean isNegative() {
        return !this.isPositive();
    }
}
