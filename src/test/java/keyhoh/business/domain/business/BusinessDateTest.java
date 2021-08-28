package keyhoh.business.domain.business;

import keyhoh.business.util.IntSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BusinessDateTest {
    private final Set<DayOfWeek> HOLIDAYS = new HashSet<>(Arrays.asList(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY));

    final BusinessDay businessDay = date -> {
        final DayOfWeek dayOfWeek = date.getDayOfWeek();
        return HOLIDAYS.contains(dayOfWeek) ? BusinessDayType.NON_BUSINESS_DAY : BusinessDayType.BUSINESS_DAY;
    };

    static Stream<LocalDate> localDateStream() {
        return IntSource.intStreamClosed(1, 31).mapToObj(i -> LocalDate.of(2020, 1, i));
    }

    @ParameterizedTest
    @MethodSource("localDateStream")
    void isBusinessDay(final LocalDate localDate) {
        final DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        final BusinessDate businessDate = new BusinessDate(localDate, businessDay);
        assertEquals(!HOLIDAYS.contains(dayOfWeek), businessDate.isBusinessDay());
    }
}