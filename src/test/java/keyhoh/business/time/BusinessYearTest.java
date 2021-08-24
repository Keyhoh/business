package keyhoh.business.time;

import keyhoh.business.util.IntSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Month;
import java.time.Year;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BusinessYearTest {
    static Stream<Year> yearStream() {
        return IntSource.intStreamClosed(Year.MIN_VALUE, Year.MAX_VALUE).mapToObj(Year::of);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12})
    void toYear_by_default_business_year(final int month) {
        final BusinessYear businessYear = new BusinessYear(Year.of(2000));
        assertEquals(businessYear.toYear(Month.of(month)), Year.of(2000));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10, 11, 12})
    void toYear_on_current_year(final int month) {
        System.setProperty("business.time.year.start", "4");
        final BusinessYear businessYear = new BusinessYear(Year.of(2000));
        assertEquals(businessYear.toYear(Month.of(month)), Year.of(2000));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void toYear_on_next_year(final int month) {
        System.setProperty("business.time.year.start", "4");
        final BusinessYear businessYear = new BusinessYear(Year.of(2000));
        assertEquals(businessYear.toYear(Month.of(month)), Year.of(2001));
    }

    @ParameterizedTest
    @MethodSource("yearStream")
    void getValue(final Year year) {
        assertEquals(new BusinessYear(year).getValue(), year.getValue());
    }
}