package keyhoh.business.type.interval;

/**
 * * 区間
 * 区間とは順序を持つ集合のある二つの要素に挟まれた部分集合です
 *
 * @param <T> 順序付けられたクラス
 */
public interface Interval<T extends Comparable<T>> {
    /**
     * 対象はこの区間に含まれます
     *
     * @param target 対象
     * @return この区間に含まれます
     */
    boolean has(final T target);
}
