package com.tw.units;

import com.tw.Exceptions.IllegalValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeasureTest {

    @Test
    void validatingUnits() {
        assertThrows(IllegalValue.class, () -> Measure.initCentimeter(-9));
        assertThrows(IllegalValue.class, () -> Measure.initInch(-3));
        assertDoesNotThrow(() -> Measure.initInch(0));
    }

    @Test
    void footToInchesCompare() {
        Measure inch = Measure.initInch(12);
        Measure foot = Measure.initFoot(1);
        assert (inch.areEqual(foot));
    }

    @Test
    void footToInchesCompare2() {
        Measure inch = Measure.initInch(24);
        Measure foot = Measure.initFoot(2);
        assert (inch.areEqual(foot));
    }

    @Test
    void footToInchesCompareGivenInvalidMeasures() {
        Measure inch = Measure.initInch(15);
        Measure foot = Measure.initFoot(1);
        assertFalse(inch.areEqual(foot));
    }

    @Test
    void inchesToCMCompare() {
        Measure inch = Measure.initInch(2);
        Measure centi = Measure.initCentimeter(5);
        assert (inch.areEqual(centi));
    }

    @Test
    void inchesToCMCompareGivenInvalidMeasures() {
        Measure inch = Measure.initInch(2);
        Measure centi = Measure.initCentimeter(7);
        assertFalse(inch.areEqual(centi));
    }

    @Test
    void CMToMMCompare() {
        Measure centi = Measure.initCentimeter(1);
        Measure milli = Measure.initMillimeter(10);
        assert (centi.areEqual(milli));
    }

    @Test
    void CMToMMCompareGivenInvalidMeasures() {
        Measure centi = Measure.initCentimeter(7);
        Measure milli = Measure.initMillimeter(10);
        assertFalse(centi.areEqual(milli));
    }

    @Test
    void gallonToLtCompare() {
        Measure gallon = Measure.initGallon(1);
        Measure litre = Measure.initLitre(3.78);
        assert (gallon.areEqual(litre));
    }

    @Test
    void gallonToLtCompareGivenInvalidMeasures() {
        Measure gallon = Measure.initGallon(1);
        Measure litre = Measure.initLitre(10);
        assertFalse(gallon.areEqual(litre));
    }

    @Test
    void addingTwoInches() {
        Measure measure1 = Measure.initInch(2);
        Measure measure2 = Measure.initInch(2);
        Measure result = Measure.initInch(4);
        assert (measure1.addLengths(measure2).equals(result));
    }

    @Test
    void addingTwoInches2() throws Exception {
        Measure measure1 = Measure.initInch(2);
        Measure measure2 = Measure.initInch(5);
        Measure result = Measure.initInch(7);
        assert (measure1.addLengths(measure2).equals(result));
    }

    @Test
    void addingTwoInchesWithWrongResult() {
        Measure measure1 = Measure.initInch(2);
        Measure measure2 = Measure.initInch(2);
        Measure result = Measure.initInch(6);
        assertFalse(measure1.addLengths(measure2).equals(result));
    }

    @Test
    void addTwoLengths() {
        Measure measure1 = Measure.initInch(2);
        Measure measure2 = Measure.initCentimeter(2.5);
        Measure result = Measure.initInch(3);
        assert(measure1.addLengths(measure2).equals(result));
    }
}
