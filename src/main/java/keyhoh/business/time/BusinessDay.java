package keyhoh.business.time;

import java.time.Period;

public record BusinessDay(Period value) {
    public BusinessDay(final Integer value) {
        this(Period.ofDays(value));
    }

    public BusinessDay add(final BusinessDay other) {
        return new BusinessDay(this.value.plusDays(other.value.getDays()));
    }

    public BusinessDay subtract(final BusinessDay other) {
        return new BusinessDay(this.value.minusDays(other.value.getDays()));
    }
}
