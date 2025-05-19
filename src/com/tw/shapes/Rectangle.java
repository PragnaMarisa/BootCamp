package com.tw.shapes;

public class Rectangle implements Shape{
    private final int width;
    private final int height;

    public Rectangle(int width  , int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int area() {
        return width * height;
    }

    @Override
    public int perimeter() {
        return 2 * (width + height);
    }
}
