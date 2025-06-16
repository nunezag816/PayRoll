public class PayrollCalculator {
    private static final double OVERTIME_RATE = 1.5;
    private static final double BASE_HOURS = 40.0;
    private static final double UNION_DUES = 10.00;
    private static final double SOCIAL_SECURITY_TAX = 0.06;
    private static final double FEDERAL_TAX = 0.14;
    private static final double STATE_TAX = 0.05;

    private final PayrollInput input;

    public double grossPay;
    public double socialSecurity;
    public double federalTax;
    public double stateTax;
    public double insuranceCost;
    public double lifeInsuranceCost;
    public double netPay;
    public boolean owesExtra;

    public PayrollCalculator(PayrollInput input) {
        this.input = input;
    }

    public void calculate() {
        double regularHours = Math.min(BASE_HOURS, input.hoursWorked);
        double overtimeHours = Math.max(0, input.hoursWorked - BASE_HOURS);
        grossPay = (regularHours * input.payRate) + (overtimeHours * input.payRate * OVERTIME_RATE);

        socialSecurity = grossPay * SOCIAL_SECURITY_TAX;
        federalTax = grossPay * FEDERAL_TAX;
        stateTax = grossPay * STATE_TAX;
        insuranceCost = (input.children >= 3) ? 35.00 : 15.00;
        lifeInsuranceCost = getLifeInsuranceCost(input.lifeInsuranceOption);

        double deductions = socialSecurity + federalTax + stateTax;
        double availableAfterTaxes = grossPay - deductions;

        if (availableAfterTaxes >= UNION_DUES + insuranceCost + lifeInsuranceCost) {
            netPay = availableAfterTaxes - UNION_DUES - insuranceCost - lifeInsuranceCost;
            owesExtra = false;
        } else {
            netPay = availableAfterTaxes;
            owesExtra = true;
        }
    }

    private double getLifeInsuranceCost(int option) {
        if (option == 2) return 5.00;
        if (option == 3) return 10.00;
        if (option == 4) return 15.00;
        return 0.00;
    }

    public double getUnionDues() {
        return UNION_DUES;
    }
}
