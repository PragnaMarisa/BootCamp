package com.tw.units;

import com.tw.Exceptions.IllegalValue;

public class Unit {

    private final double val;

    public Unit(double val) {
        this.val = val;
    }

    private static Unit create(double unitVal, double offset) {
        if (unitVal < 0) throw new IllegalValue("Not a valid measurement");
        return new Unit(unitVal * offset);
    }

    public static Unit initFoot(double foot) {
        return Unit.create(foot,12 * 25);
    }

    public static Unit initInch(double inch) {
        return Unit.create(inch, 25);
    }

    public static Unit initCentimeter(double centimeter) {
        return Unit.create(centimeter, 10);
    }

    public static Unit initMillimeter(double millimeter) {
        return Unit.create(millimeter, 1);
    }

    public static Unit initGallon(double gallons) {
        return Unit.create(gallons,3.78 * 1000000);
    }

    public static Unit initLitre(double litre) {
        return Unit.create(litre, 1000000);
    }

    public boolean areEqual(Unit other) {
        return this.val == other.val;
    }

}
