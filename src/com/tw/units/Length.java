package com.tw.units;

public enum Length implements Unit {
    MM(1),
    CM(10),
    INCH(25),
    FOOT(300);

    private final double conversionFactor;

    Length(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double toStandard(double value) {
        return value * this.conversionFactor;
    }
}

