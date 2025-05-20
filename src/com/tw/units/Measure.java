package com.tw.units;

import com.tw.Exceptions.IllegalValue;

import java.util.Objects;

public class Measure {

    private final double val;
    private final double original;
    private final Unit originalUnit;

    public Measure(double val, double original, Unit originalUnit) {
        this.val = val;
        this.original = original;
        this.originalUnit = originalUnit;
    }

    private static Measure create(double unitVal, double conversionFactor, Unit originalUnit) {
        if (unitVal < 0) throw new IllegalValue("Not a valid measurement");
        return new Measure(unitVal * conversionFactor, unitVal, originalUnit);
    }

    public static Measure initFoot(double foot) {
        return Measure.create(foot, 12 * 25, Unit.FOOT);
    }

    public static Measure initInch(double inch) {
        return Measure.create(inch, 25, Unit.INCH);
    }

    public static Measure initCentimeter(double centimeter) {
        return Measure.create(centimeter, 10, Unit.CM);
    }

    public static Measure initMillimeter(double millimeter) {
        return Measure.create(millimeter, 1, Unit.MM);
    }

    public static Measure initGallon(double gallons) {
        return Measure.create(gallons, 3.78 * 1000000, Unit.GALLON);
    }

    public static Measure initLitre(double litre) {
        return Measure.create(litre, 1000000, Unit.LITRE);
    }

    public boolean areEqual(Measure other) {
        return this.val == other.val;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Measure)) return false;
        Measure measure = (Measure) o;
        return Double.compare(val, measure.val) == 0 && Double.compare(original, measure.original) == 0 && originalUnit == measure.originalUnit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, original, originalUnit);
    }
}
