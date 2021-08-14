package keyhoh.business.money;

import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * * 貨幣
 * 貨幣とは価値の単位です
 */
public record Money(BigInteger value) {
    /**
     * int型から貨幣を作成します
     *
     * @param value 価値
     */
    public Money(final int value) {
        this(BigInteger.valueOf(value));
    }

    /**
     * long型から貨幣を作成します
     *
     * @param value 価値
     */
    public Money(final long value) {
        this(BigInteger.valueOf(value));
    }

    /**
     * 二つの貨幣の和の価値を持つ貨幣を作成します
     *
     * @param other もう一つの貨幣
     * @return 和の価値を持つ貨幣
     */
    public Money add(final Money other) {
        return new Money(this.value.add(other.value));
    }

    /**
     * 二つの貨幣の差の価値を持つ貨幣を作成します
     *
     * @param other もう一つの貨幣
     * @return 差の価値を持つ貨幣
     */
    public Money subtract(final Money other) {
        return new Money(this.value.subtract(other.value));
    }

    /**
     * 価値が正であることを示します
     * 0は正です
     *
     * @return 価値は正です
     */
    public boolean isPositive() {
        return BigInteger.ZERO.compareTo(this.value) <= 0;
    }

    /**
     * 価値が負であることを示します
     * 0は負ではありません
     *
     * @return 価値は負です
     */
    public boolean isNegative() {
        return !this.isPositive();
    }

    /**
     * 整形済み文字列を返します
     *
     * @return 整形済み文字列
     */
    public String toFormattedString(final String format) {
        return new DecimalFormat(format).format(this.value);
    }

    /**
     * 整形済み文字列を返します
     *
     * @return 整形済み文字列
     */
    public String toFormattedString() {
        return this.toFormattedString("#,####");
    }
}
