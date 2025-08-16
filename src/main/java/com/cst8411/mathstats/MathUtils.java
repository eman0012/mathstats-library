package com.cst8411.mathstats;

/**
 * Mathematical utility class providing advanced mathematical operations.
 * 
 * @author Corneile Emanuel
 * @version 1.0.0
 */
public class MathUtils {
    
    /**
     * Calculates the factorial of a non-negative integer.
     * 
     * @param n non-negative integer
     * @return n! (n factorial)
     * @throws IllegalArgumentException if n is negative or greater than 20
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Factorial for n > 20 exceeds long capacity");
        }
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Calculates the number of combinations (n choose r).
     * 
     * @param n total number of items
     * @param r number of items to choose
     * @return nCr (combinations)
     * @throws IllegalArgumentException if n &lt; 0, r &lt; 0, or r &gt; n
     */
    public static long combinations(int n, int r) {
        if (n < 0 || r < 0) {
            throw new IllegalArgumentException("n and r must be non-negative");
        }
        if (r > n) {
            throw new IllegalArgumentException("r cannot be greater than n");
        }
        
        // Optimize by using the property nCr = nC(n-r)
        if (r > n - r) {
            r = n - r;
        }
        
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }
    
    /**
     * Calculates the number of permutations (n permute r).
     * 
     * @param n total number of items
     * @param r number of items to arrange
     * @return nPr (permutations)
     * @throws IllegalArgumentException if n &lt; 0, r &lt; 0, or r &gt; n
     */
    public static long permutations(int n, int r) {
        if (n < 0 || r < 0) {
            throw new IllegalArgumentException("n and r must be non-negative");
        }
        if (r > n) {
            throw new IllegalArgumentException("r cannot be greater than n");
        }
        
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
        }
        return result;
    }
    
    /**
     * Checks if a number is prime.
     * 
     * @param n number to check
     * @return true if n is prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        
        // Check divisibility up to sqrt(n)
        int limit = (int) Math.sqrt(n);
        for (int i = 5; i <= limit; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Calculates the Greatest Common Divisor (GCD) of two numbers.
     * Uses Euclidean algorithm.
     * 
     * @param a first number
     * @param b second number
     * @return GCD of a and b
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    /**
     * Calculates the Least Common Multiple (LCM) of two numbers.
     * 
     * @param a first number
     * @param b second number
     * @return LCM of a and b
     * @throws IllegalArgumentException if both numbers are zero
     */
    public static int lcm(int a, int b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("LCM is undefined when both numbers are zero");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        
        return (a * b) / gcd(a, b);
    }
    
    /**
     * Generates the nth Fibonacci number.
     * 
     * @param n position in Fibonacci sequence (0-indexed)
     * @return nth Fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci is not defined for negative indices");
        }
        if (n <= 1) {
            return n;
        }
        
        long prev = 0;
        long current = 1;
        
        for (int i = 2; i <= n; i++) {
            long next = prev + current;
            prev = current;
            current = next;
        }
        
        return current;
    }
    
    /**
     * Calculates the power of a number with integer exponent.
     * More efficient than Math.pow for integer exponents.
     * 
     * @param base the base number
     * @param exponent the integer exponent
     * @return base raised to the power of exponent
     */
    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        
        double result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= base;
            }
            base *= base;
            exponent /= 2;
        }
        
        return result;
    }
}