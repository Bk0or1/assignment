
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Constants
        final double DRINK_PRICE = 15.50;
        final double STUDENT_DISCOUNT = 0.10;
        final double SENIOR_DISCOUNT = 0.05;
        final double TIP_RATE = 0.10;

        // Customer information
        System.out.print("Enter customer name: ");
        String name = input.nextLine();

        System.out.print("Enter customer age: ");
        int age = input.nextInt();

        System.out.print("Enter meal price: ");
        double mealPrice = input.nextDouble();

        System.out.println("Enter number of drinks: ");
        int drinks = input.nextInt();

        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = input.nextBoolean();

        System.out.print("Enter service rating (1-5): ");
        int rating = input.nextInt();

        // Validate rating
        if (rating < 1 || rating > 5) {
            System.out.println("Error: Rating must be between 1 and 5.");
        } 
        else {

            // Calculate drinks cost
            double drinksCost = drinks * DRINK_PRICE;

            // Calculate subtotal
            double subtotal = mealPrice + drinksCost;

            // Calculate discount
            double discountRate = 0;

            if (isStudent && age >= 60) {
                discountRate = STUDENT_DISCOUNT;
            }
            else if (isStudent) {
                discountRate = STUDENT_DISCOUNT;
            }
            else if (age >= 60) {
                discountRate = SENIOR_DISCOUNT;
            }
            else {
                discountRate = 0;
            }

            double discountAmount = subtotal * discountRate;

            // Calculate tip
            double tipAmount = 0;

            if (rating >= 4) {
                tipAmount = (subtotal - discountAmount) * TIP_RATE;
            }
            else {
                tipAmount = 0;
            }

            // Calculate final bill
            double finalBill = subtotal - discountAmount + tipAmount;

            // Type casting
            int wholeAmount = (int) finalBill;

            // Print receipt
            System.out.println("\n==============================");
            System.out.println("       SMART RESTAURANT");
            System.out.println("==============================");

            System.out.println("Customer: " + name);
            System.out.printf("Meal: $%.2f%n", mealPrice);
            System.out.printf("Drinks: $%.2f%n", drinksCost);
            System.out.printf("Discount: $%.2f%n", discountAmount);
            System.out.printf("Tip: $%.2f%n", tipAmount);
            System.out.printf("Final bill: $%.2f%n", finalBill);
            System.out.println("Whole amount: $" + wholeAmount);

            System.out.println("==============================");
        }

        input.close();
    }
}
