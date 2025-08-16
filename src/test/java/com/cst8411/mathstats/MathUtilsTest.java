package com.cst8411.mathstats;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the MathUtils class.
 * 
 * @author Corneile Emanuel
 * @version 1.0.0
 */
public class MathUtilsTest {
    
    private static final double DELTA = 0.0001;
    
    @Test
    @DisplayName("Test factorial calculation")
    public void testFactorial() {
        // Test basic factorials
        assertEquals(1, MathUtils.factorial(0));
        assertEquals(1, MathUtils.factorial(1));
        assertEquals(2, MathUtils.factorial(2));
        assertEquals(6, MathUtils.factorial(3));
        assertEquals(24, MathUtils.factorial(4));
        assertEquals(120, MathUtils.factorial(5));
        assertEquals(3628800, MathUtils.factorial(10));
        
        // Test large factorial
        assertEquals(2432902008176640000L, MathUtils.factorial(20));
    }
    
    @Test
    @DisplayName("Test factorial with invalid input")
    public void testFactorialInvalid() {
        // Test negative input
        assertThrows(IllegalArgumentException.class, () -> MathUtils.factorial(-1));
        
        // Test overflow
        assertThrows(IllegalArgumentException.class, () -> MathUtils.factorial(21));
    }
    
    @Test
    @DisplayName("Test combinations calculation")
    public void testCombinations() {
        // Test basic combinations
        assertEquals(1, MathUtils.combinations(5, 0));
        assertEquals(5, MathUtils.combinations(5, 1));
        assertEquals(10, MathUtils.combinations(5, 2));
        assertEquals(10, MathUtils.combinations(5, 3));
        assertEquals(5, MathUtils.combinations(5, 4));
        assertEquals(1, MathUtils.combinations(5, 5));
        
        // Test larger combinations
        assertEquals(120, MathUtils.combinations(10, 3));
        assertEquals(252, MathUtils.combinations(10, 5));
    }
    
    @Test
    @DisplayName("Test combinations with invalid input")
    public void testCombinationsInvalid() {
        // Test negative n
        assertThrows(IllegalArgumentException.class, () -> MathUtils.combinations(-1, 2));
        
        // Test negative r
        assertThrows(IllegalArgumentException.class, () -> MathUtils.combinations(5, -1));
        
        // Test r > n
        assertThrows(IllegalArgumentException.class, () -> MathUtils.combinations(5, 6));
    }
    
    @Test
    @DisplayName("Test permutations calculation")
    public void testPermutations() {
        // Test basic permutations
        assertEquals(1, MathUtils.permutations(5, 0));
        assertEquals(5, MathUtils.permutations(5, 1));
        assertEquals(20, MathUtils.permutations(5, 2));
        assertEquals(60, MathUtils.permutations(5, 3));
        assertEquals(120, MathUtils.permutations(5, 4));
        assertEquals(120, MathUtils.permutations(5, 5));
        
        // Test larger permutations
        assertEquals(720, MathUtils.permutations(10, 3));
    }
    
    @Test
    @DisplayName("Test permutations with invalid input")
    public void testPermutationsInvalid() {
        // Test negative n
        assertThrows(IllegalArgumentException.class, () -> MathUtils.permutations(-1, 2));
        
        // Test negative r
        assertThrows(IllegalArgumentException.class, () -> MathUtils.permutations(5, -1));
        
        // Test r > n
        assertThrows(IllegalArgumentException.class, () -> MathUtils.permutations(5, 6));
    }
    
    @Test
    @DisplayName("Test isPrime")
    public void testIsPrime() {
        // Test non-primes
        assertFalse(MathUtils.isPrime(-5));
        assertFalse(MathUtils.isPrime(0));
        assertFalse(MathUtils.isPrime(1));
        assertFalse(MathUtils.isPrime(4));
        assertFalse(MathUtils.isPrime(6));
        assertFalse(MathUtils.isPrime(8));
        assertFalse(MathUtils.isPrime(9));
        assertFalse(MathUtils.isPrime(10));
        assertFalse(MathUtils.isPrime(100));
        
        // Test primes
        assertTrue(MathUtils.isPrime(2));
        assertTrue(MathUtils.isPrime(3));
        assertTrue(MathUtils.isPrime(5));
        assertTrue(MathUtils.isPrime(7));
        assertTrue(MathUtils.isPrime(11));
        assertTrue(MathUtils.isPrime(13));
        assertTrue(MathUtils.isPrime(17));
        assertTrue(MathUtils.isPrime(19));
        assertTrue(MathUtils.isPrime(23));
        assertTrue(MathUtils.isPrime(97));
    }
    
    @Test
    @DisplayName("Test GCD calculation")
    public void testGcd() {
        // Test basic GCD
        assertEquals(6, MathUtils.gcd(48, 18));
        assertEquals(1, MathUtils.gcd(17, 19));
        assertEquals(12, MathUtils.gcd(12, 24));
        assertEquals(5, MathUtils.gcd(15, 25));
        
        // Test with zero
        assertEquals(5, MathUtils.gcd(5, 0));
        assertEquals(7, MathUtils.gcd(0, 7));
        
        // Test with negative numbers
        assertEquals(6, MathUtils.gcd(-48, 18));
        assertEquals(6, MathUtils.gcd(48, -18));
        assertEquals(6, MathUtils.gcd(-48, -18));
    }
    
    @Test
    @DisplayName("Test LCM calculation")
    public void testLcm() {
        // Test basic LCM
        assertEquals(36, MathUtils.lcm(12, 18));
        assertEquals(60, MathUtils.lcm(12, 20));
        assertEquals(21, MathUtils.lcm(3, 7));
        assertEquals(24, MathUtils.lcm(8, 12));
        
        // Test with one zero
        assertEquals(0, MathUtils.lcm(0, 5));
        assertEquals(0, MathUtils.lcm(7, 0));
        
        // Test with negative numbers
        assertEquals(36, MathUtils.lcm(-12, 18));
        assertEquals(36, MathUtils.lcm(12, -18));
    }
    
    @Test
    @DisplayName("Test LCM with both zeros")
    public void testLcmBothZeros() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.lcm(0, 0));
    }
    
    @Test
    @DisplayName("Test Fibonacci calculation")
    public void testFibonacci() {
        // Test Fibonacci sequence
        assertEquals(0, MathUtils.fibonacci(0));
        assertEquals(1, MathUtils.fibonacci(1));
        assertEquals(1, MathUtils.fibonacci(2));
        assertEquals(2, MathUtils.fibonacci(3));
        assertEquals(3, MathUtils.fibonacci(4));
        assertEquals(5, MathUtils.fibonacci(5));
        assertEquals(8, MathUtils.fibonacci(6));
        assertEquals(13, MathUtils.fibonacci(7));
        assertEquals(21, MathUtils.fibonacci(8));
        assertEquals(34, MathUtils.fibonacci(9));
        assertEquals(55, MathUtils.fibonacci(10));
    }
    
    @Test
    @DisplayName("Test Fibonacci with invalid input")
    public void testFibonacciInvalid() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.fibonacci(-1));
    }
    
    @Test
    @DisplayName("Test power calculation")
    public void testPower() {
        // Test positive exponents
        assertEquals(1.0, MathUtils.power(2, 0), DELTA);
        assertEquals(2.0, MathUtils.power(2, 1), DELTA);
        assertEquals(4.0, MathUtils.power(2, 2), DELTA);
        assertEquals(8.0, MathUtils.power(2, 3), DELTA);
        assertEquals(1024.0, MathUtils.power(2, 10), DELTA);
        
        // Test negative exponents
        assertEquals(0.5, MathUtils.power(2, -1), DELTA);
        assertEquals(0.25, MathUtils.power(2, -2), DELTA);
        assertEquals(0.125, MathUtils.power(2, -3), DELTA);
        
        // Test with different bases
        assertEquals(27.0, MathUtils.power(3, 3), DELTA);
        assertEquals(625.0, MathUtils.power(5, 4), DELTA);
        assertEquals(1.0, MathUtils.power(1, 100), DELTA);
        
        // Test zero exponent
        assertEquals(1.0, MathUtils.power(999, 0), DELTA);
    }
}