package keyhoh.business.domain.business;

import java.time.LocalDate;

/**
 * *営業日付
 * 営業日付とは事業所が稼働した日付です。
 */
public record BusinessDate(LocalDate value, BusinessDay businessDay) {
    /**
     * 営業日です。
     *
     * @return 営業日です。
     */
    public boolean isBusinessDay() {
        return this.businessDay.test(this.value) == BusinessDayType.BUSINESS_DAY;
    }
}
