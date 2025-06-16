package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private PayrollInput makeInput(double hours, double payRate, int children, int insuranceOption) {
        PayrollInput input = new PayrollInput();
        input.hoursWorked = hours;
        input.payRate = payRate;
        input.children = children;
        input.lifeInsuranceOption = insuranceOption;
        return input;
    }

    @Test
    public void testGrossPay_NoOvertime() {
        PayrollInput input = makeInput(40, 20.0, 0, 1);
        PayrollCalculator calc = new PayrollCalculator(input);
        calc.calculate();
        assertEquals(800.0, calc.grossPay, 0.001);
    }

    @Test
    public void testGrossPay_WithOvertime() {
        PayrollInput input = makeInput(45, 20.0, 0, 1);
        PayrollCalculator calc = new PayrollCalculator(input);
        calc.calculate();
        double expected = (40 * 20.0) + (5 * 20.0 * 1.5);
        assertEquals(expected, calc.grossPay, 0.001);
    }

    @Test
    public void testDeductions_WithFewChildren() {
        PayrollInput input = makeInput(40, 20.0, 1, 2);
        PayrollCalculator calc = new PayrollCalculator(input);
        calc.calculate();

        assertEquals(800 * 0.06, calc.socialSecurity, 0.01);
        assertEquals(800 * 0.14, calc.federalTax, 0.01);
        assertEquals(800 * 0.05, calc.stateTax, 0.01);
        assertEquals(15.00, calc.insuranceCost, 0.01); // 1 child → $15
        assertEquals(5.00, calc.lifeInsuranceCost, 0.01); // single plan
    }

    @Test
    public void testDeductions_WithManyChildren() {
        PayrollInput input = makeInput(40, 20.0, 4, 4);
        PayrollCalculator calc = new PayrollCalculator(input);
        calc.calculate();

        assertEquals(35.00, calc.insuranceCost, 0.01); // 3+ children
        assertEquals(15.00, calc.lifeInsuranceCost, 0.01); // married w/ children plan
    }

    @Test
    public void testNetPay_SufficientFunds() {
        PayrollInput input = makeInput(40, 20.0, 0, 1);
        PayrollCalculator calc = new PayrollCalculator(input);
        calc.calculate();

        assertFalse(calc.owesExtra, "Should not owe extra if gross is sufficient.");
        assertTrue(calc.netPay > 0, "Net pay should be positive.");
    }

    @Test
    public void testNetPay_InsufficientFunds() {
        PayrollInput input = makeInput(1, 10.0, 3, 4); // Very low income
        PayrollCalculator calc = new PayrollCalculator(input);
        calc.calculate();

        assertTrue(calc.owesExtra, "Should owe extra due to insufficient funds.");
        assertTrue(calc.netPay >= 0, "Net pay cannot be negative (should stop at deductions).");
    }

}
  @Test
  void itWorks() {
    assertEquals(true, true);
  }
}
