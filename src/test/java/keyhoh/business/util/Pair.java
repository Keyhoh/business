package keyhoh.business.util;

import org.junit.jupiter.params.provider.Arguments;

public record Pair<T>(T x, T y) {
    public Arguments toArguments() {
        return Arguments.arguments(x, y);
    }
}
