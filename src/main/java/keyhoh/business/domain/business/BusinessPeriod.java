package keyhoh.business.domain.business;

import java.time.LocalDate;

/**
 * 事業期
 */
public interface BusinessPeriod {
    LocalDate firstDay();

    LocalDate lastDay();
}
