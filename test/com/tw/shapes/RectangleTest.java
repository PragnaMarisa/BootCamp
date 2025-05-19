package com.tw.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
    @Test
    void areaOfRectWithSameDimensions() {
        Rectangle rectangle = new Rectangle(2, 2);
        assertEquals(4, rectangle.area());
    }

    @Test
    void areaOfRectWithDiffDimensions() {
        Rectangle rectangle = new Rectangle(5, 2);
        assertEquals(10, rectangle.area());
    }

    @Test
    void perimeterOfRectWithSameDimensions() {
        Rectangle rectangle = new Rectangle(2, 2);
        assertEquals(8, rectangle.perimeter());
    }

    @Test
    void perimeterOfRectWithDiffDimensions() {
        Rectangle rectangle = new Rectangle(5, 2);
        assertEquals(14, rectangle.perimeter());
    }
}
