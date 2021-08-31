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
}
