package keyhoh.business.domain.business;

import java.time.LocalDate;

/**
 * *営業日
 * 営業日とは事業所が稼働する日です。
 */
public interface BusinessDay {
    /**
     * 営業日・非営業日を判定します。
     *
     * @param date 日付
     * @return 営業日・非営業日
     */
    BusinessDayType test(final LocalDate date);
}
