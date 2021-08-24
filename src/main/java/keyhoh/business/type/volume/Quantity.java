package keyhoh.business.type.volume;

import java.math.BigInteger;

/**
 * 数量
 */
public record Quantity(BigInteger value) implements Comparable<Quantity> {
    public Quantity {
        if (value.compareTo(BigInteger.ZERO) < 0) throw new IllegalArgumentException("負値の数量は存在しません");
    }

    /**
     * Long型から数量を作成します。
     *
     * @param value 大きさ
     */
    public Quantity(final Long value) {
        this(BigInteger.valueOf(value));
    }

    /**
     * 数量同士の和の大きさを持つ数量を作成します。
     *
     * @param other もう一つの数量
     * @return 二つの数量の大きさを持つ数量
     */
    public Quantity add(final Quantity other) {
        return new Quantity(this.value.add(other.value));
    }

    /**
     * 数量のスカラ積の大きさを持つ数量を作成します。
     *
     * @param scalar スカラ
     * @return スカラ倍の大きさを持つ数量
     */
    public Quantity multiply(final long scalar) {
        return new Quantity(BigInteger.valueOf(scalar).multiply(this.value));
    }

    @Override
    public int compareTo(final Quantity other) {
        return this.value.compareTo(other.value);
    }
}
