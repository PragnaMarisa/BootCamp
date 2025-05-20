package com.tw.units;

import com.tw.Exceptions.IllegalValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    @Test
    void validatingUnits() {
        assertThrows(IllegalValue.class, () -> Unit.initCentimeter(-9));
        assertThrows(IllegalValue.class, () -> Unit.initInch(-3));
        assertDoesNotThrow(() -> Unit.initInch(0));
    }

    @Test
    void footToInchesCompare() {
        Unit inch = Unit.initInch(12);
        Unit foot = Unit.initFoot(1);
        assert (inch.areEqual(foot));
    }

    @Test
    void footToInchesCompareGivenInvalidMeasures() {
        Unit inch = Unit.initInch(15);
        Unit foot = Unit.initFoot(1);
        assertFalse(inch.areEqual(foot));
    }

    @Test
    void inchesToCMCompare() {
        Unit inch = Unit.initInch(2);
        Unit centi = Unit.initCentimeter(5);
        assert (inch.areEqual(centi));
    }

    @Test
    void inchesToCMCompareGivenInvalidMeasures() {
        Unit inch = Unit.initInch(2);
        Unit centi = Unit.initCentimeter(7);
        assertFalse (inch.areEqual(centi));
    }

    @Test
    void CMToMMCompare() {
        Unit centi = Unit.initCentimeter(1);
        Unit milli = Unit.initMillimeter(10);
        assert (centi.areEqual(milli));
    }

    @Test
    void CMToMMCompareGivenInvalidMeasures() {
        Unit centi = Unit.initCentimeter(7);
        Unit milli = Unit.initMillimeter(10);
        assertFalse (centi.areEqual(milli));
    }

    @Test
    void gallonToLtCompare() {
        Unit gallon = Unit.initGallon(1);
        Unit litre= Unit.initLitre(3.78);
        assert (gallon.areEqual(litre));
    }

    @Test
    void gallonToLtCompareGivenInvalidMeasures() {
        Unit gallon = Unit.initGallon(1);
        Unit litre= Unit.initLitre(10);
        assertFalse(gallon.areEqual(litre));
    }
}
