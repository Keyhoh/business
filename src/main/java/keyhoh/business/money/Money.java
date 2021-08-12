package keyhoh.business.money;

import java.math.BigInteger;

public record Money(BigInteger value) {
    public Money add(final Money other) {
        return new Money(this.value.add(other.value));
    }

    public boolean isPositive() {
        return BigInteger.ZERO.compareTo(this.value) <= 0;
    }

    public boolean isNegative() {
        return !this.isPositive();
    }
}
