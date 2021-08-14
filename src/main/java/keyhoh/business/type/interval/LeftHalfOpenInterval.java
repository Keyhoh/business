package keyhoh.business.type.interval;

/**
 * 左半開区間
 *
 * @param <T> 順序付けられたクラス
 */
public record LeftHalfOpenInterval<T extends Comparable<T>>(T start, T end) implements Interval<T> {
    @Override
    public boolean has(final T target) {
        return !(this.start.compareTo(target) >= 0 || this.end.compareTo(target) < 0);
    }
}
