package com.tw.units;

public enum Volume implements Unit {
    GALLON(3780000),
    LITRE(1000000);

    private final double conversionFactor;

    Volume(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double toStandard(double value) {
        return value * this.conversionFactor;
    }
}
