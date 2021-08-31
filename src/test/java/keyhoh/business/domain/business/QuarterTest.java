package keyhoh.business.domain.business;

import keyhoh.business.util.IntSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Month;
import java.time.Year;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuarterTest {
    static Stream<BusinessYear> businessYearStream(final int start, final int stop) {
        return IntSource.intStream(start, stop).mapToObj(Month::of).map(m -> new BusinessYear(m, Year.of(2020)));
    }

    static Stream<BusinessYear> businessYearStream() {
        return IntSource.intStream(1, 12).mapToObj(Month::of).map(m -> new BusinessYear(m, Year.of(2020)));
    }

    @ParameterizedTest
    @MethodSource("businessYearStream")
    void firstDayOfPeriod(final BusinessYear businessYear) {
        final Quarter quarter = new Quarter(businessYear);
        assertEquals(businessYear.start().atDay(1), quarter.first().firstDay());
        assertEquals(businessYear.start().plusMonths(3).atDay(1), quarter.second().firstDay());
        assertEquals(businessYear.start().plusMonths(6).atDay(1), quarter.third().firstDay());
        assertEquals(businessYear.start().plusMonths(9).atDay(1), quarter.forth().firstDay());
    }

    @ParameterizedTest
    @MethodSource("businessYearStream")
    void lastDayOfPeriod(final BusinessYear businessYear) {
        final Quarter quarter = new Quarter(businessYear);
        assertEquals(businessYear.start().atDay(1), quarter.first().firstDay());
        assertEquals(businessYear.start().plusMonths(3).atEndOfMonth(), quarter.second().lastDay());
        assertEquals(businessYear.start().plusMonths(6).atEndOfMonth(), quarter.third().lastDay());
        assertEquals(businessYear.start().plusMonths(9).atEndOfMonth(), quarter.forth().lastDay());
    }
}