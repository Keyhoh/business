package keyhoh.business.type.volume;

/**
 * 数量
 */
public record Quantity(Integer value) implements Comparable<Quantity> {
    public Quantity {
        if (value < 0) throw new IllegalArgumentException("負値の数量は存在しません");
    }

    public Quantity add(final Quantity other) {
        return new Quantity(this.value + other.value);
    }

    @Override
    public int compareTo(final Quantity other) {
        return this.value.compareTo(other.value);
    }
}
