package keyhoh.business.type.volume;

import java.math.BigInteger;

/**
 * 数量
 */
public record Quantity(BigInteger value) implements Comparable<Quantity> {
    public Quantity {
        if (value.compareTo(BigInteger.ZERO) < 0) throw new IllegalArgumentException("負値の数量は存在しません");
    }

    public Quantity(final Long value) {
        this(BigInteger.valueOf(value));
    }

    public Quantity add(final Quantity other) {
        return new Quantity(this.value.add(other.value));
    }

    @Override
    public int compareTo(final Quantity other) {
        return this.value.compareTo(other.value);
    }
}
