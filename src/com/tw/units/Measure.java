package com.tw.units;

import com.tw.Exceptions.IllegalValue;

import java.util.Objects;

public class Measure {

    private final double val;
    private final double original;
    private final Unit originalUnit;
    public static final int CONVERSION_FACTOR_CM = 10;
    public static final int CONVERSION_FACTOR_MM = 1;
    public static final double CONVERSION_FACTOR_GALLON = 3.78 * 1000000;
    public static final int CONVERSION_FACTOR_LITRE = 1000000;
    private static final int CONVERSION_FACTOR_FOOT = 12 * 25;
    private static final int CONVERSION_FACTOR_INCH = 25;

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
        return Measure.create(foot, CONVERSION_FACTOR_FOOT, Unit.FOOT);
    }

    public static Measure initInch(double inch) {
        return Measure.create(inch, CONVERSION_FACTOR_INCH, Unit.INCH);
    }

    public static Measure initCentimeter(double centimeter) {
        return Measure.create(centimeter, CONVERSION_FACTOR_CM, Unit.CM);
    }

    public static Measure initMillimeter(double millimeter) {
        return Measure.create(millimeter, CONVERSION_FACTOR_MM, Unit.MM);
    }

    public static Measure initGallon(double gallons) {
        return Measure.create(gallons, CONVERSION_FACTOR_GALLON, Unit.GALLON);
    }

    public static Measure initLitre(double litre) {
        return Measure.create(litre, CONVERSION_FACTOR_LITRE, Unit.LITRE);
    }

    public boolean areEqual(Measure other) {
        return this.val == other.val;
    }

    public Measure addInch(Measure measure2) throws Exception {
        validateUnits(measure2);
        return Measure.initInch(this.original + measure2.original);
    }

    private boolean validateUnits(Measure measure2) throws Exception {
        if (this.originalUnit != measure2.originalUnit)throw new Exception("hi");
        return true;
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
