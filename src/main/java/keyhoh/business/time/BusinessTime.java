package keyhoh.business.time;

import java.time.Duration;

public record BusinessTime(Duration value) {
    public BusinessTime(final Long value) {
        this(Duration.ofSeconds(value));
    }

    public BusinessTime add(final BusinessTime other) {
        return new BusinessTime(this.value.plusSeconds(other.value.toSeconds()));
    }

    public BusinessTime subtract(final BusinessTime other) {
        return new BusinessTime(this.value.minusSeconds(other.value.toSeconds()));
    }
}
