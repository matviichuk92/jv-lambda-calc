package core.basesyntax;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.0001;
    private Calculator calculator;
    private static double ZERO = 0.0;
    private static double TWO = 2.0;
    private static double IRRACIONAL_FIVE = 5.2367;
    private static double NEGATIVE_TWO = -2.0;
    private static double NEGATIVE_SIX = -6.0;

    @Before
    public void init() {
       calculator = new Calculator();
    }

    @Test
    public void divisionIsValid() {
        double expected = -1.1457;
        Assert.assertEquals(expected, Calculator.calculate(NEGATIVE_SIX, IRRACIONAL_FIVE, '/'), DELTA);
    }

    @Test
    public void multiplicationIsValid() {
        double expected = -4.0;
        Assert.assertEquals(expected, Calculator.calculate(TWO, NEGATIVE_TWO, '*'), DELTA);
    }

    @Test
    public void summationIsValid() {
        double expected = -6.0;
        Assert.assertEquals(expected, Calculator.calculate(NEGATIVE_SIX, ZERO, '+'), DELTA);
    }

    @Test
    public void subtractionIsValid() {
        double expected = -4.0;
        Assert.assertEquals(expected, Calculator.calculate(NEGATIVE_SIX, NEGATIVE_TWO, '-'), DELTA);
    }

    @Test
    public void exaltationInDegreeIsValid() {
        double expected = 0.25;
        Assert.assertEquals(expected, Calculator.calculate(TWO, NEGATIVE_TWO, '^'), DELTA);
    }

    @Test
    public void irracionalNumbersIsValid() {
        double expected = 37.7054;
        Assert.assertEquals(expected, Calculator.calculate(TWO, IRRACIONAL_FIVE, '^'), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void notValidDivisionOnZero() {
        Calculator.calculate(TWO, ZERO, '/');
    }

    @Test(expected = AssertionError.class)
    public void exaltationInDegreeZeroValid() {
        Calculator.calculate(ZERO, NEGATIVE_TWO, '^');
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidSign() {
        Calculator.calculate(TWO, ZERO, '%');
    }

    @Test(expected = NullPointerException.class)
    public void notValidArgument() {
        Calculator.calculate(TWO, null, '*');
    }

    @Test(expected = NullPointerException.class)
    public void notValidNullSign() {
        Calculator.calculate(TWO, ZERO, null);
    }

    @Test(expected = NumberFormatException.class)
    public void notValidComa() {
        Calculator.calculate(TWO, Double.parseDouble("39,6"), '*');
    }

    @After
    public void afterTest(){
        calculator = null;
    }
}
