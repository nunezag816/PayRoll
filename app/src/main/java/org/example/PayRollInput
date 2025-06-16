import java.util.Scanner;

public class PayrollInput {
    public double hoursWorked;
    public int children;
    public double payRate;
    public int lifeInsuranceOption;

    public static PayrollInput collectUserInput() {
        Scanner scanner = new Scanner(System.in);
        PayrollInput input = new PayrollInput();

        input.hoursWorked = promptDouble(scanner, "How many hours did you work this week? ");
        input.children = promptInt(scanner, "How many children do you have? ");
        input.payRate = promptDouble(scanner, "What is your hourly pay rate? ");
        input.lifeInsuranceOption = promptInsurance(scanner, input.children);

        return input;
    }

    private static double promptDouble(Scanner scanner, String message) {
        double value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= 0) return value;
            }
            scanner.nextLine(); // clear invalid input
            System.out.println("Invalid input. Please enter a positive number.");
        }
    }

    private static int promptInt(Scanner scanner, String message) {
        int value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                return Math.max(0, value); // auto-correct negatives to 0
            }
            scanner.nextLine(); // clear buffer
            System.out.println("Invalid input. Please enter a whole number.");
        }
    }

    private static int promptInsurance(Scanner scanner, int children) {
        int option;
        while (true) {
            System.out.println("\nWhich life insurance plan do you want to select?");
            System.out.println("  (1) no plan");
            System.out.println("  (2) single plan");
            System.out.println("  (3) married plan");
            System.out.println("  (4) married with children plan");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option >= 1 && option <= 4) {
                    if (option == 4 && children < 1) {
                        System.out.println("Sorry! You need at least one child to select that plan.");
                    } else {
                        return option;
                    }
                } else {
                    System.out.println("Invalid selection. Choose between 1 and 4.");
                }
            } else {
                scanner.nextLine(); // clear buffer
                System.out.println("Invalid input. Enter a number between 1 and 4.");
            }
        }
    }
}
