package keyhoh.business.time;

import java.util.Optional;

/**
 * *年度
 * 年度とはビジネスにおける1年の単位です
 */
public record Year(java.time.Year value) {
    private static java.time.Month start;

    static {
        final Optional<String> start = Optional.ofNullable(System.getProperty("business.time.year.start"));
        Year.start = java.time.Month.of(Integer.parseInt(start.orElse("1")));
    }

    public java.time.Year toYear(final java.time.Month month) {
        return Year.start.compareTo(month) > 0 ? this.value.plusYears(1) : this.value;
    }
}
