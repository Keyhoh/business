package keyhoh.business.domain.work;

import java.time.Duration;

/**
 * *就業時間
 * 就業時間とは人がビジネスに従事している時間です。
 * 単位は秒です。
 */
public record Second(Duration value) {
    public Second(final Long value) {
        this(Duration.ofSeconds(value));
    }

    /**
     * 二つの就業時間の和の就業時間を作成します。
     *
     * @param other もう一つの就業時間
     * @return 和の就業時間
     */
    public Second add(final Second other) {
        return new Second(this.value.plusSeconds(other.value.toSeconds()));
    }
}
