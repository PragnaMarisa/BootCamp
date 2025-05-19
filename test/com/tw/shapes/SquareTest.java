package com.tw.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
    @Test
    void areaOfSquareWithSide4() {
        Square sq = new Square(4);
        assertEquals(16, sq.area());
    }

    @Test
    void areaOfSquareWithSide6() {
        Square sq = new Square(6);
        assertEquals(36, sq.area());
    }

}
