package keyhoh.business.time;

import java.util.Optional;

/**
 * *年度
 * 年度とはビジネスにおける1年の単位です。
 */
public class Year {
    private final java.time.Month start;
    private final java.time.Year value;

    /**
     * 年度を作成します。
     *
     * @param start 年度開始月
     * @param value 年
     */
    public Year(final java.time.Month start, final java.time.Year value) {
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
    public Year(final java.time.Year value) {
        this(java.time.Month.of(Integer.parseInt(Optional.ofNullable(System.getProperty("business.time.year.start")).orElse("1"))), value);
    }

    /**
     * 年を返します。
     *
     * @param on 月
     * @return 年
     */
    public java.time.Year toYear(final java.time.Month on) {
        return this.start.compareTo(on) > 0 ? this.value.plusYears(1) : this.value;
    }
}
