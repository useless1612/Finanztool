package ase.finanzplaner.core;

import java.math.BigDecimal;

public final class ResultForDiff {
    private final BigDecimal possum;
    private final BigDecimal negsum;

    public ResultForDiff(BigDecimal possum, BigDecimal negsum) {
        this.possum = possum;
        this.negsum = negsum;
    }

    public BigDecimal getFirst() {
        return possum;
    }

    public BigDecimal getSecond() {
        return negsum;
    }
}
