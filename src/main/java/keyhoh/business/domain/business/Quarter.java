package keyhoh.business.domain.business;

import java.time.LocalDate;
import java.util.stream.IntStream;

/**
 * 四半期
 */
public class Quarter {
    private final BusinessYear businessYear;
    private final Period[] periods;

    public Quarter(final BusinessYear businessYear) {
        this.businessYear = businessYear;
        this.periods = IntStream.range(0, 4).mapToObj(Period::new).toArray(Period[]::new);
    }

    /**
     * @return 第1四半期
     */
    public Period first() {
        return this.periods[0];
    }

    /**
     * @return 第2四半期
     */
    public Period second() {
        return this.periods[1];
    }

    /**
     * @return 第3四半期
     */
    public Period third() {
        return this.periods[2];
    }

    /**
     * @return 第4四半期
     */
    public Period forth() {
        return this.periods[3];
    }

    /**
     * 次年度の四半期を作成します。
     *
     * @return 次年度四半期
     */
    public Quarter next() {
        return new Quarter(this.businessYear.next());
    }

    /**
     * 前年度の四半期を作成します。
     *
     * @return 前年度四半期
     */
    public Quarter previous() {
        return new Quarter(this.businessYear.previous());
    }

    @Override
    public String toString() {
        return "Quarter{" +
                "businessYear=" + businessYear +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Quarter that = (Quarter) o;

        return businessYear.equals(that.businessYear);
    }

    @Override
    public int hashCode() {
        return businessYear.hashCode();
    }

    public class Period implements BusinessPeriod {
        private final int ordinal;

        private Period(final int ordinal) {
            this.ordinal = ordinal;
        }

        /**
         * 次期を返します。
         *
         * @return 次の期
         */
        public Period next() {
            final int nextOrdinal = this.ordinal + 1;
            if (nextOrdinal < 4) return Quarter.this.periods[nextOrdinal];
            return Quarter.this.next().periods[nextOrdinal % 4];
        }

        /**
         * 前期を返します。
         *
         * @return 前の期
         */
        public Period previous() {
            final int nextOrdinal = this.ordinal + 3;
            if (nextOrdinal < 4) return Quarter.this.previous().periods[nextOrdinal];
            return Quarter.this.periods[nextOrdinal % 4];
        }

        @Override
        public LocalDate firstDay() {
            return Quarter.this.businessYear.start().plusMonths(this.ordinal * 3L).atDay(1);
        }

        @Override
        public LocalDate lastDay() {
            return Quarter.this.businessYear.start().plusMonths(this.ordinal * 3L).atEndOfMonth();
        }

        @Override
        public String toString() {
            return "Period{" +
                    "quarter=" + Quarter.this +
                    ", ordinal=" + ordinal +
                    '}';
        }

        private Quarter quarter() {
            return Quarter.this;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Period that = (Period) o;

            return this.quarter().equals(that.quarter()) && ordinal == that.ordinal;
        }

        @Override
        public int hashCode() {
            return ordinal;
        }
    }
}
