package com.tw.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProbabilityTest {
    @Test
    void probabilityOfTailOnSingleCoin() {
        Probability coin = Probability.create(1);
        Probability result = Probability.create(1);
        assert (coin.equals(result));
    }

    @Test
    void complementOccurrenceOfTailOnSingleCoin() {
        Probability coin = Probability.create(0.5);
        Probability result = Probability.create(0.5);
        assert (coin.complement().equals(result));
    }

    @Test
    void complementOccurrenceOfTailOnSingleCoinWhenUnEqualValues() {
        Probability coin = Probability.create(0.5);
        Probability result = Probability.create(0.7);
        assertFalse(coin.complement().equals(result));
    }

    @Test
    void probabilityOfTailOnTwoCoins() {
        Probability coin1 = Probability.create(0.5);
        Probability coin2 = Probability.create(0.5);
        Probability result = Probability.create(0.25);
        assert (coin1.and(coin2).equals(result));
    }

    @Test
    void probabilityOfTailOnTwoCoinsWithUnEqualValues() {
        Probability coin1 = Probability.create(0.5);
        Probability coin2 = Probability.create(0.5);
        Probability result = Probability.create(0.5);
        assertFalse(coin1.and(coin2).equals(result));
    }

    @Test
    void complementOccurrenceOfTailOnTwoCoins() {
        Probability coin1 = Probability.create(0.5);
        Probability coin2 = Probability.create(0.5);
        Probability result = Probability.create(0.75);
        assert (coin1.and(coin2).complement().equals(result));
    }

    @Test
    void complementOccurrenceOfTailOnTwoCoinsWithUnEqualValues() {
        Probability coin1 = Probability.create(0.5);
        Probability coin2 = Probability.create(0.5);
        Probability result = Probability.create(0.5);
        assertFalse(coin1.and(coin2).complement().equals(result));
    }

    @Test
    void validatingProbabilityOnWrongValue() {
        assertThrows(RuntimeException.class, () -> Probability.create(4));
    }

    @Test
    void validatingProbabilityOnValidValue() {
        assertDoesNotThrow(() -> Probability.create(0.99));
    }
}