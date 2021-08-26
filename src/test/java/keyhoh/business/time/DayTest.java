package keyhoh.business.time;

import keyhoh.business.util.IntSource;
import keyhoh.business.util.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Period;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTest {
    static Stream<Arguments> intStreamClosed() {
        return IntSource.intPairsClosed(Integer.MIN_VALUE / 2, Integer.MAX_VALUE / 2).map(Pair::toArguments);
    }

    @ParameterizedTest
    @MethodSource("intStreamClosed")
    void add(final int one, final int other) {
        assertEquals(Period.ofDays(one).plusDays(other), new Day(one).add(new Day(other)).value());
    }
}