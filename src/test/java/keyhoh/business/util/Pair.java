package keyhoh.business.util;

import org.junit.jupiter.params.provider.Arguments;

public record Pair<T1, T2>(T1 x, T2 y) {
    public Arguments toArguments() {
        return Arguments.arguments(x, y);
    }
}
