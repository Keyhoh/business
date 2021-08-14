package keyhoh.business.type.interval;

/**
 * 右半開区間
 *
 * @param <T> 順序付けられたクラス
 */
public record RightHalfOpenInterval<T extends Comparable<T>>(T start, T end) implements Interval<T> {
    @Override
    public boolean has(final T target) {
        return !(this.start.compareTo(target) > 0 || this.end.compareTo(target) <= 0);
    }
}
