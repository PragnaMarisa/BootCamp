package com.tw.units;

import com.tw.Exceptions.IllegalValue;

import java.util.Objects;

public class Measure<U extends Unit> {

    private final double original;
    private final U originalUnit;

    private Measure(double original, U originalUnit) {
        this.original = original;
        this.originalUnit = originalUnit;
    }

    private double toMM() {
        return this.originalUnit.toStandard(this.original);
    }

    private static Measure create(double originalValue, Unit originalUnit) {
        if (originalValue < 0) throw new IllegalValue("Not a valid measurement");
        return new Measure(originalValue, originalUnit);
    }

    public static Measure initFoot(double foot) {
        return Measure.create(foot, Length.FOOT);
    }

    public static Measure initInch(double inch) {
        return Measure.create(inch, Length.INCH);
    }

    public static Measure initCentimeter(double centimeter) {
        return Measure.create(centimeter, Length.CM);
    }

    public static Measure initMillimeter(double millimeter) {
        return Measure.create(millimeter, Length.MM);
    }

    public static Measure initGallon(double gallons) {
        return Measure.create(gallons, Volume.GALLON);
    }

    public static Measure initLitre(double litre) {
        return Measure.create(litre, Volume.LITRE);
    }

    public boolean areEqual(Measure other) {
        return this.toMM() == other.toMM();
    }

    private double MMtoInch(double mm) {
        return mm / 25;
    }

    private double getSum(Measure measure2) {
        double sum = this.toMM() + measure2.toMM();
        return sum;
    }

    public Measure addLengths(Measure measure2) {
        double sum = getSum(measure2);
        double inchVal = MMtoInch(sum);
        return Measure.initInch(inchVal);
    }
    public Measure addVolumes(Measure measure2) {
        double sum = getSum(measure2);
        double litreVal = MMtoLitres(sum);
        return Measure.initLitre(litreVal);
    }

    private double MMtoLitres(double total) {
        return total / 10;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Measure)) return false;
        Measure measure = (Measure) o;
        return Double.compare(original, measure.original) == 0 && originalUnit == measure.originalUnit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(original, originalUnit);
    }
}
