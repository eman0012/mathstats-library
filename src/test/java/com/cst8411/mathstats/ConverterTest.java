package com.cst8411.mathstats;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Converter class.
 * 
 * @author Corneile Emanuel
 * @version 1.0.0
 */
public class ConverterTest {
    
    private static final double DELTA = 0.01;
    
    @Nested
    @DisplayName("Temperature Converter Tests")
    class TemperatureTests {
        
        @Test
        @DisplayName("Test Celsius to Fahrenheit conversion")
        public void testCelsiusToFahrenheit() {
            // Freezing point
            assertEquals(32.0, Converter.Temperature.celsiusToFahrenheit(0), DELTA);
            
            // Boiling point
            assertEquals(212.0, Converter.Temperature.celsiusToFahrenheit(100), DELTA);
            
            // Body temperature
            assertEquals(98.6, Converter.Temperature.celsiusToFahrenheit(37), DELTA);
            
            // Negative temperature
            assertEquals(-40.0, Converter.Temperature.celsiusToFahrenheit(-40), DELTA);
        }
        
        @Test
        @DisplayName("Test Fahrenheit to Celsius conversion")
        public void testFahrenheitToCelsius() {
            // Freezing point
            assertEquals(0.0, Converter.Temperature.fahrenheitToCelsius(32), DELTA);
            
            // Boiling point
            assertEquals(100.0, Converter.Temperature.fahrenheitToCelsius(212), DELTA);
            
            // Body temperature
            assertEquals(37.0, Converter.Temperature.fahrenheitToCelsius(98.6), DELTA);
            
            // Negative temperature
            assertEquals(-40.0, Converter.Temperature.fahrenheitToCelsius(-40), DELTA);
        }
        
        @Test
        @DisplayName("Test Celsius to Kelvin conversion")
        public void testCelsiusToKelvin() {
            // Absolute zero
            assertEquals(273.15, Converter.Temperature.celsiusToKelvin(0), DELTA);
            
            // Boiling point
            assertEquals(373.15, Converter.Temperature.celsiusToKelvin(100), DELTA);
            
            // Room temperature
            assertEquals(293.15, Converter.Temperature.celsiusToKelvin(20), DELTA);
        }
        
        @Test
        @DisplayName("Test Celsius to Kelvin with invalid temperature")
        public void testCelsiusToKelvinInvalid() {
            // Below absolute zero
            assertThrows(IllegalArgumentException.class, 
                () -> Converter.Temperature.celsiusToKelvin(-274));
        }
        
        @Test
        @DisplayName("Test Kelvin to Celsius conversion")
        public void testKelvinToCelsius() {
            // Absolute zero
            assertEquals(-273.15, Converter.Temperature.kelvinToCelsius(0), DELTA);
            
            // Freezing point
            assertEquals(0.0, Converter.Temperature.kelvinToCelsius(273.15), DELTA);
            
            // Boiling point
            assertEquals(100.0, Converter.Temperature.kelvinToCelsius(373.15), DELTA);
        }
        
        @Test
        @DisplayName("Test Kelvin to Celsius with invalid temperature")
        public void testKelvinToCelsiusInvalid() {
            // Negative Kelvin
            assertThrows(IllegalArgumentException.class, 
                () -> Converter.Temperature.kelvinToCelsius(-1));
        }
        
        @Test
        @DisplayName("Test Fahrenheit to Kelvin conversion")
        public void testFahrenheitToKelvin() {
            // Freezing point
            assertEquals(273.15, Converter.Temperature.fahrenheitToKelvin(32), DELTA);
            
            // Boiling point
            assertEquals(373.15, Converter.Temperature.fahrenheitToKelvin(212), DELTA);
            
            // Very cold temperature (not quite absolute zero to avoid rounding issues)
            assertEquals(255.37, Converter.Temperature.fahrenheitToKelvin(0), DELTA);
        }
        
        @Test
        @DisplayName("Test Fahrenheit to Kelvin with invalid temperature")
        public void testFahrenheitToKelvinInvalid() {
            // Below absolute zero
            assertThrows(IllegalArgumentException.class, 
                () -> Converter.Temperature.fahrenheitToKelvin(-460));
        }
        
        @Test
        @DisplayName("Test Kelvin to Fahrenheit conversion")
        public void testKelvinToFahrenheit() {
            // Absolute zero
            assertEquals(-459.67, Converter.Temperature.kelvinToFahrenheit(0), DELTA);
            
            // Freezing point
            assertEquals(32.0, Converter.Temperature.kelvinToFahrenheit(273.15), DELTA);
            
            // Boiling point
            assertEquals(212.0, Converter.Temperature.kelvinToFahrenheit(373.15), DELTA);
        }
        
        @Test
        @DisplayName("Test Kelvin to Fahrenheit with invalid temperature")
        public void testKelvinToFahrenheitInvalid() {
            // Negative Kelvin
            assertThrows(IllegalArgumentException.class, 
                () -> Converter.Temperature.kelvinToFahrenheit(-1));
        }
    }
    
    @Nested
    @DisplayName("Length Converter Tests")
    class LengthTests {
        
        @Test
        @DisplayName("Test meters to feet conversion")
        public void testMetersToFeet() {
            assertEquals(3.28084, Converter.Length.metersToFeet(1), DELTA);
            assertEquals(16.4042, Converter.Length.metersToFeet(5), DELTA);
            assertEquals(328.084, Converter.Length.metersToFeet(100), DELTA);
        }
        
        @Test
        @DisplayName("Test feet to meters conversion")
        public void testFeetToMeters() {
            assertEquals(0.3048, Converter.Length.feetToMeters(1), DELTA);
            assertEquals(1.524, Converter.Length.feetToMeters(5), DELTA);
            assertEquals(30.48, Converter.Length.feetToMeters(100), DELTA);
        }
        
        @Test
        @DisplayName("Test kilometers to miles conversion")
        public void testKilometersToMiles() {
            assertEquals(0.621371, Converter.Length.kilometersToMiles(1), DELTA);
            assertEquals(3.10686, Converter.Length.kilometersToMiles(5), DELTA);
            assertEquals(62.1371, Converter.Length.kilometersToMiles(100), DELTA);
        }
        
        @Test
        @DisplayName("Test miles to kilometers conversion")
        public void testMilesToKilometers() {
            assertEquals(1.60934, Converter.Length.milesToKilometers(1), DELTA);
            assertEquals(8.04672, Converter.Length.milesToKilometers(5), DELTA);
            assertEquals(160.934, Converter.Length.milesToKilometers(100), DELTA);
        }
        
        @Test
        @DisplayName("Test inches to centimeters conversion")
        public void testInchesToCentimeters() {
            assertEquals(2.54, Converter.Length.inchesToCentimeters(1), DELTA);
            assertEquals(30.48, Converter.Length.inchesToCentimeters(12), DELTA);
            assertEquals(91.44, Converter.Length.inchesToCentimeters(36), DELTA);
        }
        
        @Test
        @DisplayName("Test centimeters to inches conversion")
        public void testCentimetersToInches() {
            assertEquals(0.393701, Converter.Length.centimetersToInches(1), DELTA);
            assertEquals(3.93701, Converter.Length.centimetersToInches(10), DELTA);
            assertEquals(39.3701, Converter.Length.centimetersToInches(100), DELTA);
        }
    }
    
    @Nested
    @DisplayName("Weight Converter Tests")
    class WeightTests {
        
        @Test
        @DisplayName("Test kilograms to pounds conversion")
        public void testKilogramsToPounds() {
            assertEquals(2.20462, Converter.Weight.kilogramsToPounds(1), DELTA);
            assertEquals(11.0231, Converter.Weight.kilogramsToPounds(5), DELTA);
            assertEquals(220.462, Converter.Weight.kilogramsToPounds(100), DELTA);
        }
        
        @Test
        @DisplayName("Test pounds to kilograms conversion")
        public void testPoundsToKilograms() {
            assertEquals(0.453592, Converter.Weight.poundsToKilograms(1), DELTA);
            assertEquals(2.26796, Converter.Weight.poundsToKilograms(5), DELTA);
            assertEquals(45.3592, Converter.Weight.poundsToKilograms(100), DELTA);
        }
        
        @Test
        @DisplayName("Test grams to ounces conversion")
        public void testGramsToOunces() {
            assertEquals(0.035274, Converter.Weight.gramsToOunces(1), DELTA);
            assertEquals(1.05822, Converter.Weight.gramsToOunces(30), DELTA);
            assertEquals(3.5274, Converter.Weight.gramsToOunces(100), DELTA);
        }
        
        @Test
        @DisplayName("Test ounces to grams conversion")
        public void testOuncesToGrams() {
            assertEquals(28.3495, Converter.Weight.ouncesToGrams(1), DELTA);
            assertEquals(226.796, Converter.Weight.ouncesToGrams(8), DELTA);
            assertEquals(453.592, Converter.Weight.ouncesToGrams(16), DELTA);
        }
    }
    
    @Test
    @DisplayName("Test round-trip conversions")
    public void testRoundTripConversions() {
        // Temperature round-trips
        double celsius = 25.0;
        double fahrenheit = Converter.Temperature.celsiusToFahrenheit(celsius);
        assertEquals(celsius, Converter.Temperature.fahrenheitToCelsius(fahrenheit), DELTA);
        
        // Length round-trips
        double meters = 10.0;
        double feet = Converter.Length.metersToFeet(meters);
        assertEquals(meters, Converter.Length.feetToMeters(feet), DELTA);
        
        // Weight round-trips
        double kg = 50.0;
        double lbs = Converter.Weight.kilogramsToPounds(kg);
        assertEquals(kg, Converter.Weight.poundsToKilograms(lbs), DELTA);
    }
}