import java.text.DecimalFormat;
import java.util.Scanner;

public class MobileBillCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for their subscription package
        System.out.print("Enter your subscription package (Green/Blue/Purple): ");
        String packageName = scanner.next(); 
        
        boolean isValidPackage = false;
        double baseCost = 0.0;
        double additionalCostPerGB = 0.0;

        // Determine the package type and set corresponding values
        switch (packageName) {
            case "green":
                isValidPackage = true;
                baseCost = 49.99;
                additionalCostPerGB = 15.0;

                // Check for a coupon for the Green package
                System.out.print("Do you have a coupon? (true/false): ");
                boolean hasCoupon = scanner.nextBoolean();
                if (hasCoupon && baseCost + additionalCostPerGB > 75) {
                    baseCost -= 20;
                }
                break;
            case "blue":
                isValidPackage = true;
                baseCost = 70.0;
                additionalCostPerGB = 10.0;
                break;
            case "purple":
                isValidPackage = true;
                baseCost = 99.95;
                break;
        }

        // If the package is valid, calculate the total cost
        if (isValidPackage) {
            System.out.print("Enter the amount of data used in GB: ");
            double dataUsed = scanner.nextDouble();

            // Calculate the total cost based on the package and data usage
            double totalCost;
            if (packageName.equals("green") && dataUsed > 2) {
                totalCost = baseCost + additionalCostPerGB * (dataUsed - 2);
            } else {
                totalCost = baseCost;
            }

            // Display the formatted total monthly bill
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println("Your monthly bill is: $" + decimalFormat.format(totalCost));
        } else {
            // Display a message for an invalid package name
            System.out.println("Invalid package name. Please enter Green, Blue, or Purple.");
        }

    }
}
