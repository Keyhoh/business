package keyhoh.business.domain.business;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Optional;

/**
 * *年度
 * 年度とはビジネスにおける1年の単位です。
 */
public class BusinessYear {
    private final Month start;
    private final Year value;

    /**
     * 年度を作成します。
     *
     * @param start 年度開始月
     * @param value 年
     */
    public BusinessYear(final Month start, final Year value) {
        this.start = start;
        this.value = value;
    }

    /**
     * 年度を作成します。
     * 年度開始月はシステムプロパティ値 `business.year.start` を使用します。
     * システムプロパティ値が設定されていなければ年度開始月は1月です。
     *
     * @param value 年
     */
    public BusinessYear(final Year value) {
        this(Month.of(Integer.parseInt(Optional.ofNullable(System.getProperty("business.time.year.start")).orElse("1"))), value);
    }

    /**
     * 次年度を作成します。
     *
     * @return 次年度
     */
    public BusinessYear next() {
        return new BusinessYear(this.start, this.value.plusYears(1));
    }

    /**
     * 前年度を作成します。
     *
     * @return 前年度
     */
    public BusinessYear previous() {
        return new BusinessYear(this.start, this.value.minusYears(1));
    }

    /**
     * 年を返します。
     *
     * @param on 月
     * @return 年
     */
    public Year toYear(final Month on) {
        return this.start.compareTo(on) > 0 ? this.value.plusYears(1) : this.value;
    }

    /**
     * 開始年月を返します。
     *
     * @return 年月
     */
    public YearMonth start() {
        return this.value.atMonth(start);
    }

    /**
     * 年度の値を返します。
     *
     * @return 値
     */
    public int getValue() {
        return this.value.getValue();
    }

    @Override
    public String toString() {
        return "BusinessYear{" +
                "start=" + start +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final BusinessYear that = (BusinessYear) o;

        if (start != that.start) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
