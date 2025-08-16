package com.cst8411.mathstats;

import java.util.Scanner;

/**
 * Demonstration class for the MathStats Library.
 * Provides an interactive menu to showcase all library features.
 * 
 * @author Corneile Emanuel
 * @version 1.0.0
 */
public class Demo {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * Main entry point for the demonstration program.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  Welcome to MathStats Library Demo v1.0.0");
        System.out.println("==============================================");
        System.out.println();
        
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = getIntInput("Enter your choice: ");
            System.out.println();
            
            switch (choice) {
                case 1:
                    demonstrateStatistics();
                    break;
                case 2:
                    demonstrateMathUtils();
                    break;
                case 3:
                    demonstrateConverters();
                    break;
                case 4:
                    runQuickDemo();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using MathStats Library!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            if (running && choice >= 1 && choice <= 4) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Prints the main menu options.
     */
    private static void printMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Statistics Operations");
        System.out.println("2. Mathematical Utilities");
        System.out.println("3. Unit Converters");
        System.out.println("4. Quick Demo (All Features)");
        System.out.println("5. Exit");
    }
    
    /**
     * Demonstrates statistics operations.
     */
    private static void demonstrateStatistics() {
        System.out.println("=== Statistics Operations Demo ===\n");
        
        // Sample data
        double[] data = {12.5, 18.3, 15.7, 20.1, 14.9, 18.3, 16.2, 19.5, 18.3, 17.8};
        
        System.out.println("Sample Data: ");
        printArray(data);
        System.out.println();
        
        System.out.printf("Mean: %.2f\n", Statistics.mean(data));
        System.out.printf("Median: %.2f\n", Statistics.median(data));
        System.out.printf("Mode: %.2f\n", Statistics.mode(data));
        System.out.printf("Range: %.2f\n", Statistics.range(data));
        System.out.printf("Variance (Population): %.2f\n", Statistics.variance(data));
        System.out.printf("Standard Deviation (Population): %.2f\n", Statistics.standardDeviation(data));
        System.out.printf("Variance (Sample): %.2f\n", Statistics.sampleVariance(data));
        System.out.printf("Standard Deviation (Sample): %.2f\n", Statistics.sampleStandardDeviation(data));
    }
    
    /**
     * Demonstrates mathematical utility operations.
     */
    private static void demonstrateMathUtils() {
        System.out.println("=== Mathematical Utilities Demo ===\n");
        
        // Factorial
        System.out.println("Factorial Operations:");
        System.out.println("5! = " + MathUtils.factorial(5));
        System.out.println("10! = " + MathUtils.factorial(10));
        System.out.println();
        
        // Combinations and Permutations
        System.out.println("Combinatorics:");
        System.out.println("C(10,3) = " + MathUtils.combinations(10, 3));
        System.out.println("P(10,3) = " + MathUtils.permutations(10, 3));
        System.out.println();
        
        // Prime numbers
        System.out.println("Prime Number Check:");
        int[] primeTests = {7, 12, 23, 100, 97};
        for (int n : primeTests) {
            System.out.println(n + " is prime: " + MathUtils.isPrime(n));
        }
        System.out.println();
        
        // GCD and LCM
        System.out.println("GCD and LCM:");
        System.out.println("GCD(48, 18) = " + MathUtils.gcd(48, 18));
        System.out.println("LCM(12, 18) = " + MathUtils.lcm(12, 18));
        System.out.println();
        
        // Fibonacci
        System.out.println("Fibonacci Sequence (first 10 numbers):");
        for (int i = 0; i < 10; i++) {
            System.out.print(MathUtils.fibonacci(i) + " ");
        }
        System.out.println();
        System.out.println();
        
        // Power
        System.out.println("Power Operations:");
        System.out.println("2^10 = " + MathUtils.power(2, 10));
        System.out.println("3^-2 = " + MathUtils.power(3, -2));
    }
    
    /**
     * Demonstrates unit converter operations.
     */
    private static void demonstrateConverters() {
        System.out.println("=== Unit Converters Demo ===\n");
        
        // Temperature conversions
        System.out.println("Temperature Conversions:");
        double celsius = 25.0;
        System.out.printf("%.1f°C = %.1f°F\n", celsius, Converter.Temperature.celsiusToFahrenheit(celsius));
        System.out.printf("%.1f°C = %.1f K\n", celsius, Converter.Temperature.celsiusToKelvin(celsius));
        
        double fahrenheit = 98.6;
        System.out.printf("%.1f°F = %.1f°C\n", fahrenheit, Converter.Temperature.fahrenheitToCelsius(fahrenheit));
        System.out.printf("%.1f°F = %.1f K\n", fahrenheit, Converter.Temperature.fahrenheitToKelvin(fahrenheit));
        System.out.println();
        
        // Length conversions
        System.out.println("Length Conversions:");
        System.out.printf("5 meters = %.2f feet\n", Converter.Length.metersToFeet(5));
        System.out.printf("100 km = %.2f miles\n", Converter.Length.kilometersToMiles(100));
        System.out.printf("12 inches = %.2f cm\n", Converter.Length.inchesToCentimeters(12));
        System.out.printf("50 cm = %.2f inches\n", Converter.Length.centimetersToInches(50));
        System.out.println();
        
        // Weight conversions
        System.out.println("Weight Conversions:");
        System.out.printf("75 kg = %.2f pounds\n", Converter.Weight.kilogramsToPounds(75));
        System.out.printf("150 pounds = %.2f kg\n", Converter.Weight.poundsToKilograms(150));
        System.out.printf("100 grams = %.2f ounces\n", Converter.Weight.gramsToOunces(100));
        System.out.printf("8 ounces = %.2f grams\n", Converter.Weight.ouncesToGrams(8));
    }
    
    /**
     * Runs a quick demonstration of all features.
     */
    private static void runQuickDemo() {
        System.out.println("=== Quick Demo - All Features ===\n");
        
        // Statistics
        System.out.println("1. STATISTICS");
        double[] quickData = {10, 20, 30, 20, 15};
        System.out.print("   Data: ");
        printArray(quickData);
        System.out.printf("   Mean: %.1f, Median: %.1f, Mode: %.1f\n", 
            Statistics.mean(quickData), 
            Statistics.median(quickData), 
            Statistics.mode(quickData));
        System.out.println();
        
        // Math Utils
        System.out.println("2. MATHEMATICS");
        System.out.println("   7! = " + MathUtils.factorial(7));
        System.out.println("   First 5 primes: 2, 3, 5, 7, 11");
        System.out.println("   Fibonacci(8) = " + MathUtils.fibonacci(8));
        System.out.println();
        
        // Converters
        System.out.println("3. CONVERTERS");
        System.out.printf("   100°F = %.1f°C\n", Converter.Temperature.fahrenheitToCelsius(100));
        System.out.printf("   1 mile = %.2f km\n", Converter.Length.milesToKilometers(1));
        System.out.printf("   1 kg = %.2f lbs\n", Converter.Weight.kilogramsToPounds(1));
    }
    
    /**
     * Helper method to print an array of doubles.
     * 
     * @param array the array to print
     */
    private static void printArray(double[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    
    /**
     * Helper method to get integer input from user.
     * 
     * @param prompt the prompt to display
     * @return the integer entered by the user
     */
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please enter a valid number: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return value;
    }
}