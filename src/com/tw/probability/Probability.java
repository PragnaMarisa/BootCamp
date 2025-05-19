package com.tw.probability;

import java.util.Objects;

public class Probability {
    private final double probability;

    private Probability(double prob) {
        this.probability = prob;
    }

    public static Probability create(double value) {
        if (value >= 0 && value <= 1) return new Probability(value);
        throw  new RuntimeException();
    }

    public Probability complement() {
        double complementValue = 1 - this.probability;
        return new Probability(complementValue);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Probability)) return false;
        Probability that = (Probability) o;
        return Double.compare(probability, that.probability) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(probability);
    }

    public Probability and(Probability coin2) {
        double result = this.probability * coin2.probability;
        return new Probability(result);
    }
}
