import java.text.DecimalFormat;

public class PayrollReport {
    private final PayrollCalculator payroll;
    private final DecimalFormat money = new DecimalFormat("#,##0.00");

    public PayrollReport(PayrollCalculator payroll) {
        this.payroll = payroll;
    }

    public void printReport() {
        System.out.println("\nPayroll Stub:\n");

        System.out.printf("%10s %8.2f%n", "Hours:", payroll.input.hoursWorked);
        System.out.printf("%10s %8.2f $/hr%n", "Rate:", payroll.input.payRate);
        System.out.printf("%10s   $%7s%n%n", "Gross:", money.format(payroll.grossPay));

        System.out.printf("%10s   $%7s%n", "SocSec:", money.format(payroll.socialSecurity));
        System.out.printf("%10s   $%7s%n", "FedTax:", money.format(payroll.federalTax));
        System.out.printf("%10s   $%7s%n", "StTax:", money.format(payroll.stateTax));

        if (!payroll.owesExtra) {
            System.out.printf("%10s   $%7s%n", "Union:", money.format(payroll.getUnionDues()));
            System.out.printf("%10s   $%7s%n", "Ins:", money.format(payroll.insuranceCost));
            System.out.printf("%10s   $%7s%n", "LifeIns:", money.format(payroll.lifeInsuranceCost));
        }

        System.out.printf("\n%10s   $%7s%n", "Net:", money.format(payroll.netPay));

        if (payroll.owesExtra) {
            System.out.println("\nThe employee still owes:");
            System.out.printf("%10s   $%7s%n", "Union:", money.format(payroll.getUnionDues()));
            System.out.printf("%10s   $%7s%n", "Ins:", money.format(payroll.insuranceCost));
            System.out.printf("%10s   $%7s%n", "LifeIns:", money.format(payroll.lifeInsuranceCost));
        }
    }
}
