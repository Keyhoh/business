package keyhoh.business.domain.business;

import java.time.Duration;

/**
 * *営業時間
 * TODO: サービスが稼働している時間、事業所が営業している時間、人が従事している時間を分ける。
 * 営業時間とはビジネスが稼働している時間です。
 * 単位は秒です。
 */
public record BusinessSecond(Duration value) {
    public BusinessSecond(final Long value) {
        this(Duration.ofSeconds(value));
    }

    /**
     * 二つの営業時間の和の営業時間を作成します。
     *
     * @param other もう一つの営業時間
     * @return 和の営業時間
     */
    public BusinessSecond add(final BusinessSecond other) {
        return new BusinessSecond(this.value.plusSeconds(other.value.toSeconds()));
    }

    /**
     * 二つの営業時間の差の営業時間を作成します。
     *
     * @param other もう一つの営業時間
     * @return 差の営業時間
     */
    public BusinessSecond subtract(final BusinessSecond other) {
        return new BusinessSecond(this.value.minusSeconds(other.value.toSeconds()));
    }
}
