package com.tw.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
    @Test
    void areaOfRectangle() {
        Rectangle rectangle = new Rectangle(2, 2);
        assertEquals(4, rectangle.area());
    }
    @Test
    void areaOfRectangle2() {
        Rectangle rectangle = new Rectangle(5, 2);
        assertEquals(10, rectangle.area());
    }
    @Test
    void perimeterOfRect() {
        Rectangle rectangle = new Rectangle(2, 2);
        assertEquals(8, rectangle.perimeter());
    }
    @Test
    void perimeterOfRect2() {
        Rectangle rectangle = new Rectangle(5, 2);
        assertEquals(14, rectangle.perimeter());
    }
}
