package com.cst8411.mathstats;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Statistics class.
 * 
 * @author Corneile Emanuel
 * @version 1.0.0
 */
public class StatisticsTest {
    
    private static final double DELTA = 0.0001;
    
    @Test
    @DisplayName("Test mean calculation")
    public void testMean() {
        // Test with positive numbers
        double[] data1 = {1, 2, 3, 4, 5};
        assertEquals(3.0, Statistics.mean(data1), DELTA);
        
        // Test with negative numbers
        double[] data2 = {-10, -20, -30};
        assertEquals(-20.0, Statistics.mean(data2), DELTA);
        
        // Test with mixed numbers
        double[] data3 = {-5, 0, 5, 10};
        assertEquals(2.5, Statistics.mean(data3), DELTA);
        
        // Test with single element
        double[] data4 = {42.5};
        assertEquals(42.5, Statistics.mean(data4), DELTA);
    }
    
    @Test
    @DisplayName("Test median calculation")
    public void testMedian() {
        // Test with odd number of elements
        double[] data1 = {1, 3, 2, 4, 5};
        assertEquals(3.0, Statistics.median(data1), DELTA);
        
        // Test with even number of elements
        double[] data2 = {1, 2, 3, 4};
        assertEquals(2.5, Statistics.median(data2), DELTA);
        
        // Test with single element
        double[] data3 = {7.5};
        assertEquals(7.5, Statistics.median(data3), DELTA);
        
        // Test with duplicate values
        double[] data4 = {5, 5, 5, 5};
        assertEquals(5.0, Statistics.median(data4), DELTA);
    }
    
    @Test
    @DisplayName("Test mode calculation")
    public void testMode() {
        // Test with clear mode
        double[] data1 = {1, 2, 2, 3, 2, 4};
        assertEquals(2.0, Statistics.mode(data1), DELTA);
        
        // Test with all unique values
        double[] data2 = {1, 2, 3, 4, 5};
        double mode = Statistics.mode(data2);
        assertTrue(mode >= 1 && mode <= 5);
        
        // Test with multiple modes (should return smallest)
        double[] data3 = {1, 1, 2, 2, 3};
        assertEquals(1.0, Statistics.mode(data3), DELTA);
        
        // Test with single element
        double[] data4 = {42};
        assertEquals(42.0, Statistics.mode(data4), DELTA);
    }
    
    @Test
    @DisplayName("Test range calculation")
    public void testRange() {
        // Test normal range
        double[] data1 = {1, 5, 3, 9, 2};
        assertEquals(8.0, Statistics.range(data1), DELTA);
        
        // Test with negative numbers
        double[] data2 = {-10, -5, 0, 5, 10};
        assertEquals(20.0, Statistics.range(data2), DELTA);
        
        // Test with identical values
        double[] data3 = {5, 5, 5, 5};
        assertEquals(0.0, Statistics.range(data3), DELTA);
        
        // Test with single element
        double[] data4 = {7};
        assertEquals(0.0, Statistics.range(data4), DELTA);
    }
    
    @Test
    @DisplayName("Test variance calculation")
    public void testVariance() {
        // Test with simple data
        double[] data1 = {2, 4, 6, 8};
        assertEquals(5.0, Statistics.variance(data1), DELTA);
        
        // Test with no variance
        double[] data2 = {5, 5, 5, 5};
        assertEquals(0.0, Statistics.variance(data2), DELTA);
        
        // Test with known variance
        double[] data3 = {1, 2, 3, 4, 5};
        assertEquals(2.0, Statistics.variance(data3), DELTA);
    }
    
    @Test
    @DisplayName("Test standard deviation calculation")
    public void testStandardDeviation() {
        // Test with simple data
        double[] data1 = {2, 4, 6, 8};
        assertEquals(Math.sqrt(5.0), Statistics.standardDeviation(data1), DELTA);
        
        // Test with no deviation
        double[] data2 = {3, 3, 3};
        assertEquals(0.0, Statistics.standardDeviation(data2), DELTA);
    }
    
    @Test
    @DisplayName("Test sample variance calculation")
    public void testSampleVariance() {
        // Test with simple data
        double[] data1 = {2, 4, 6, 8};
        assertEquals(6.6667, Statistics.sampleVariance(data1), 0.001);
        
        // Test with minimum required elements
        double[] data2 = {1, 5};
        assertEquals(8.0, Statistics.sampleVariance(data2), DELTA);
    }
    
    @Test
    @DisplayName("Test sample standard deviation calculation")
    public void testSampleStandardDeviation() {
        // Test with simple data
        double[] data1 = {2, 4, 6, 8};
        assertEquals(Math.sqrt(6.6667), Statistics.sampleStandardDeviation(data1), 0.001);
    }
    
    @Test
    @DisplayName("Test null data validation")
    public void testNullDataValidation() {
        assertThrows(IllegalArgumentException.class, () -> Statistics.mean(null));
        assertThrows(IllegalArgumentException.class, () -> Statistics.median(null));
        assertThrows(IllegalArgumentException.class, () -> Statistics.mode(null));
        assertThrows(IllegalArgumentException.class, () -> Statistics.range(null));
        assertThrows(IllegalArgumentException.class, () -> Statistics.variance(null));
        assertThrows(IllegalArgumentException.class, () -> Statistics.standardDeviation(null));
    }
    
    @Test
    @DisplayName("Test empty data validation")
    public void testEmptyDataValidation() {
        double[] emptyData = {};
        assertThrows(IllegalArgumentException.class, () -> Statistics.mean(emptyData));
        assertThrows(IllegalArgumentException.class, () -> Statistics.median(emptyData));
        assertThrows(IllegalArgumentException.class, () -> Statistics.mode(emptyData));
        assertThrows(IllegalArgumentException.class, () -> Statistics.range(emptyData));
        assertThrows(IllegalArgumentException.class, () -> Statistics.variance(emptyData));
        assertThrows(IllegalArgumentException.class, () -> Statistics.standardDeviation(emptyData));
    }
    
    @Test
    @DisplayName("Test sample variance with insufficient data")
    public void testSampleVarianceInsufficientData() {
        double[] data = {5};
        assertThrows(IllegalArgumentException.class, () -> Statistics.sampleVariance(data));
        assertThrows(IllegalArgumentException.class, () -> Statistics.sampleStandardDeviation(data));
    }
}