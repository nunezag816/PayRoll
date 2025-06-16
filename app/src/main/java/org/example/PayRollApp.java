public class PayrollApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Payroll Program!\n");

        PayrollInput input = PayrollInput.collectUserInput();
        PayrollCalculator payroll = new PayrollCalculator(input);
        payroll.calculate();

        PayrollReport report = new PayrollReport(payroll);
        report.printReport();

        System.out.println("\nThank you for using the Payroll Program!");
    }
}
