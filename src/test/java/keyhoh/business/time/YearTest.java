package keyhoh.business.time;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YearTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12})
    void toYear_by_default_business_year(final int month) {
        final Year businessYear = new Year(java.time.Year.of(2000));
        assertEquals(businessYear.toYear(Month.of(month)), java.time.Year.of(2000));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10, 11, 12})
    void toYear_on_current_year(final int month) {
        System.setProperty("business.time.year.start", "4");
        final Year businessYear = new Year(java.time.Year.of(2000));
        assertEquals(businessYear.toYear(Month.of(month)), java.time.Year.of(2000));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void toYear_on_next_year(final int month) {
        System.setProperty("business.time.year.start", "4");
        final Year businessYear = new Year(java.time.Year.of(2000));
        assertEquals(businessYear.toYear(Month.of(month)), java.time.Year.of(2001));
    }
}