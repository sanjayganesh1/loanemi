package com.example.loanemi;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        // Input values
        System.out.print("Enter loan amount (principal): ");
        double principal = sc.nextDouble();

        System.out.print("Enter annual interest rate (in %): ");
        double annualRate = sc.nextDouble();

        System.out.print("Enter loan tenure (in years): ");
        int tenureYears = sc.nextInt();

        // Convert to months and calculate monthly rate
        int tenureMonths = tenureYears * 12;
        double monthlyRate = annualRate / 12 / 100;

        // EMI calculation
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, tenureMonths)) /
                     (Math.pow(1 + monthlyRate, tenureMonths) - 1);

        // Output
        System.out.printf("Monthly EMI: ₹%.2f\n", emi);

        double totalPayment = emi * tenureMonths;
        double totalInterest = totalPayment - principal;

        System.out.printf("Total Payment (Principal + Interest): ₹%.2f\n", totalPayment);
        System.out.printf("Total Interest Payable: ₹%.2f\n", totalInterest);

        sc.close();
    }
}
