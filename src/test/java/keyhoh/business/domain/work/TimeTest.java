package keyhoh.business.domain.work;

import keyhoh.business.util.LongSource;
import keyhoh.business.util.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeTest {
    static Stream<Arguments> longStreamClosed() {
        return LongSource.longPairsClosed(Long.MIN_VALUE / 2, Long.MAX_VALUE / 2).map(Pair::toArguments);
    }

    @ParameterizedTest
    @MethodSource("longStreamClosed")
    void add(final long one, final long other) {
        assertEquals(Duration.ofSeconds(one).plusSeconds(other), new Time(one).add(new Time(other)).value());
    }
}