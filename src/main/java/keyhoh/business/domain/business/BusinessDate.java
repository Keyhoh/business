package keyhoh.business.domain.business;

import java.time.LocalDate;

/**
 * *営業日付
 * 営業日付とは事業所が稼働した日付です。
 */
public record BusinessDate(LocalDate value, BusinessCalendar businessCalendar) {
    /**
     * 営業日です。
     *
     * @return 営業日です。
     */
    public boolean isBusinessDay() {
        return this.businessCalendar.test(this.value) == BusinessDayType.BUSINESS_DAY;
    }
}
