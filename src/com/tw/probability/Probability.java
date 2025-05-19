package com.tw.probability;

import com.tw.Exceptions.IllegalValue;

import java.util.Objects;

public class Probability {
    private final double probability;
    private static final double IMPOSSIBILITY = 0;
    private static final double CERTAINTY = 1;

    private Probability(double prob) {
        this.probability = prob;
    }

    public static Probability create(double value) {
        if (value < IMPOSSIBILITY || value > CERTAINTY)
            throw new IllegalValue("You can't give value above one or below zero");

        return new Probability(value);
    }

    public Probability complement() {
        double complementValue = CERTAINTY - this.probability;
        return Probability.create(complementValue);
    }

    public Probability and(Probability coin2) {
        double result = this.probability * coin2.probability;
        return Probability.create(result);
    }

    public Probability or(Probability p2) {
        double notOccurringProb = complement().probability * p2.complement().probability;
        Probability result = Probability.create(notOccurringProb).complement();

        return result;
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

}
