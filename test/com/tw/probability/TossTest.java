package com.tw.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TossTest {
    @Test
    void probilityOfTail() {
        FlipCoin tossCoin = new FlipCoin();
        float chances = tossCoin.probability();
        assertEquals(0.5, chances);
    }
}