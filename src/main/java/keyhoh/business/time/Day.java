package keyhoh.business.time;

import java.time.Period;

public record Day(Period value) {
    public Day(final Integer value) {
        this(Period.ofDays(value));
    }

    public Day add(final Day other) {
        return new Day(this.value.plusDays(other.value.getDays()));
    }
}
