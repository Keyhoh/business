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

    public class Period implements BusinessPeriod {
        private final int ordinal;

        private Period(final int ordinal) {
            this.ordinal = ordinal;
        }

        /**
         * 次の期を返します。
         *
         * @return 次の期
         */
        public Period next() {
            return Quarter.this.periods[(this.ordinal + 1) % 4];
        }

        /**
         * 前の期を返します。
         *
         * @return 前の期
         */
        public Period previous() {
            return Quarter.this.periods[(this.ordinal - 1) % 4];
        }

        @Override
        public LocalDate firstDay() {
            return Quarter.this.businessYear.start().plusMonths(this.ordinal * 3L).atDay(1);
        }

        @Override
        public LocalDate lastDay() {
            return Quarter.this.businessYear.start().plusMonths(this.ordinal * 3L).atEndOfMonth();
        }
    }
}
