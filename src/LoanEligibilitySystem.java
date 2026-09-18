import java.util.Scanner;

public class LoanEligibilitySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Header and Inputs matching your reference image
        System.out.println("=== LOAN ELIGIBILITY SYSTEM ===");

        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Monthly Income: ");
        double monthlyIncome = scanner.nextDouble();

        System.out.print("Enter Requested Loan: ");
        double requestedLoan = scanner.nextDouble();

        System.out.print("Enter Credit Score: ");
        int creditScore = scanner.nextInt();

        // Required Calculations
        double maxAllowedLoan = monthlyIncome * 6;
        double processingFee = requestedLoan * 0.02;

        // Conditional Logic (Approval Rules)
        boolean creditScorePassed = creditScore >= 650;
        boolean loanAmountPassed = requestedLoan <= maxAllowedLoan;
        boolean isApproved = creditScorePassed && loanAmountPassed;

        // Evaluation Result Output matching reference format
        System.out.println("\n--- EVALUATION RESULT ---");
        System.out.println("Applicant Name: " + name);
        System.out.printf("Max Allowed Loan: PHP %.2f%n", maxAllowedLoan);

        System.out.print("Credit Score: " + creditScore);
        if (creditScorePassed) {
            System.out.println(" (PASSED)");
        } else {
            System.out.println(" (FAILED)");
        }

        System.out.println(); // Blank line spacing

        if (isApproved) {
            System.out.println("STATUS: LOAN APPROVED");
            System.out.printf("Processing Fee: PHP %.2f%n", processingFee);
        } else {
            System.out.println("STATUS: LOAN DENIED");
            if (!creditScorePassed) {
                System.out.println("Reason: Credit score is below 650.");
            }
            if (!loanAmountPassed) {
                System.out.println("Reason: Requested loan exceeds maximum allowed limit.");
            }
        }

        scanner.close();
    }
}