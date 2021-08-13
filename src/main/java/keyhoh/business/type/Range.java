package keyhoh.business.type;

public record Range<T extends Comparable<T>>(T start, T end) {
    public boolean has(final T target) {
        return !(this.start.compareTo(target) > 0 || this.end.compareTo(target) <= 0);
    }
}
