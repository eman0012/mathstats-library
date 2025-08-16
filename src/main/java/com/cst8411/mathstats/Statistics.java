package com.cst8411.mathstats;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Statistical operations utility class providing common statistical calculations.
 * 
 * @author Corneile Emanuel
 * @version 1.0.0
 */
public class Statistics {
    
    /**
     * Calculates the arithmetic mean (average) of an array of numbers.
     * 
     * @param data array of double values
     * @return the mean of the data
     * @throws IllegalArgumentException if data is null or empty
     */
    public static double mean(double[] data) {
        validateData(data);
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.length;
    }
    
    /**
     * Finds the median (middle value) of an array of numbers.
     * 
     * @param data array of double values
     * @return the median of the data
     * @throws IllegalArgumentException if data is null or empty
     */
    public static double median(double[] data) {
        validateData(data);
        // Create a copy to avoid modifying original array
        double[] sortedData = Arrays.copyOf(data, data.length);
        Arrays.sort(sortedData);
        
        int middle = sortedData.length / 2;
        // If even number of elements, return average of two middle elements
        if (sortedData.length % 2 == 0) {
            return (sortedData[middle - 1] + sortedData[middle]) / 2.0;
        } else {
            return sortedData[middle];
        }
    }
    
    /**
     * Finds the mode (most frequent value) in an array of numbers.
     * Returns the smallest mode if multiple modes exist.
     * 
     * @param data array of double values
     * @return the mode of the data
     * @throws IllegalArgumentException if data is null or empty
     */
    public static double mode(double[] data) {
        validateData(data);
        
        Map<Double, Integer> frequencyMap = new HashMap<>();
        // Count frequency of each value
        for (double value : data) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }
        
        // Find the value with highest frequency
        double mode = data[0];
        int maxFrequency = 0;
        
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency || 
                (entry.getValue() == maxFrequency && entry.getKey() < mode)) {
                mode = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        
        return mode;
    }
    
    /**
     * Calculates the range (difference between max and min) of the data.
     * 
     * @param data array of double values
     * @return the range of the data
     * @throws IllegalArgumentException if data is null or empty
     */
    public static double range(double[] data) {
        validateData(data);
        double min = data[0];
        double max = data[0];
        
        for (double value : data) {
            if (value < min) min = value;
            if (value > max) max = value;
        }
        
        return max - min;
    }
    
    /**
     * Calculates the population variance of the data.
     * 
     * @param data array of double values
     * @return the population variance
     * @throws IllegalArgumentException if data is null or empty
     */
    public static double variance(double[] data) {
        validateData(data);
        double mean = mean(data);
        double sumSquaredDifferences = 0;
        
        for (double value : data) {
            double difference = value - mean;
            sumSquaredDifferences += difference * difference;
        }
        
        return sumSquaredDifferences / data.length;
    }
    
    /**
     * Calculates the population standard deviation of the data.
     * 
     * @param data array of double values
     * @return the population standard deviation
     * @throws IllegalArgumentException if data is null or empty
     */
    public static double standardDeviation(double[] data) {
        return Math.sqrt(variance(data));
    }
    
    /**
     * Calculates the sample variance of the data.
     * Uses n-1 denominator (Bessel's correction).
     * 
     * @param data array of double values
     * @return the sample variance
     * @throws IllegalArgumentException if data is null or has less than 2 elements
     */
    public static double sampleVariance(double[] data) {
        validateData(data);
        if (data.length < 2) {
            throw new IllegalArgumentException("Sample variance requires at least 2 data points");
        }
        
        double mean = mean(data);
        double sumSquaredDifferences = 0;
        
        for (double value : data) {
            double difference = value - mean;
            sumSquaredDifferences += difference * difference;
        }
        
        return sumSquaredDifferences / (data.length - 1);
    }
    
    /**
     * Calculates the sample standard deviation of the data.
     * 
     * @param data array of double values
     * @return the sample standard deviation
     * @throws IllegalArgumentException if data is null or has less than 2 elements
     */
    public static double sampleStandardDeviation(double[] data) {
        return Math.sqrt(sampleVariance(data));
    }
    
    /**
     * Validates that the data array is not null and not empty.
     * 
     * @param data array to validate
     * @throws IllegalArgumentException if data is null or empty
     */
    private static void validateData(double[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Data array cannot be null");
        }
        if (data.length == 0) {
            throw new IllegalArgumentException("Data array cannot be empty");
        }
    }
}