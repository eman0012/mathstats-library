package com.cst8411.mathstats;

/**
 * Unit conversion utility class providing temperature and common unit conversions.
 * 
 * @author Corneile Emanuel
 * @version 1.0.0
 */
public class Converter {
    
    // Temperature conversion constants
    private static final double CELSIUS_TO_FAHRENHEIT_SCALE = 9.0 / 5.0;
    private static final double FAHRENHEIT_TO_CELSIUS_SCALE = 5.0 / 9.0;
    private static final double CELSIUS_TO_FAHRENHEIT_OFFSET = 32.0;
    private static final double KELVIN_OFFSET = 273.15;
    
    /**
     * Temperature conversion utilities.
     */
    public static class Temperature {
        
        /**
         * Converts Celsius to Fahrenheit.
         * 
         * @param celsius temperature in Celsius
         * @return temperature in Fahrenheit
         */
        public static double celsiusToFahrenheit(double celsius) {
            return (celsius * CELSIUS_TO_FAHRENHEIT_SCALE) + CELSIUS_TO_FAHRENHEIT_OFFSET;
        }
        
        /**
         * Converts Fahrenheit to Celsius.
         * 
         * @param fahrenheit temperature in Fahrenheit
         * @return temperature in Celsius
         */
        public static double fahrenheitToCelsius(double fahrenheit) {
            return (fahrenheit - CELSIUS_TO_FAHRENHEIT_OFFSET) * FAHRENHEIT_TO_CELSIUS_SCALE;
        }
        
        /**
         * Converts Celsius to Kelvin.
         * 
         * @param celsius temperature in Celsius
         * @return temperature in Kelvin
         * @throws IllegalArgumentException if result would be below absolute zero
         */
        public static double celsiusToKelvin(double celsius) {
            double kelvin = celsius + KELVIN_OFFSET;
            if (kelvin < 0) {
                throw new IllegalArgumentException("Temperature cannot be below absolute zero");
            }
            return kelvin;
        }
        
        /**
         * Converts Kelvin to Celsius.
         * 
         * @param kelvin temperature in Kelvin
         * @return temperature in Celsius
         * @throws IllegalArgumentException if kelvin is negative
         */
        public static double kelvinToCelsius(double kelvin) {
            if (kelvin < 0) {
                throw new IllegalArgumentException("Kelvin cannot be negative");
            }
            return kelvin - KELVIN_OFFSET;
        }
        
        /**
         * Converts Fahrenheit to Kelvin.
         * 
         * @param fahrenheit temperature in Fahrenheit
         * @return temperature in Kelvin
         * @throws IllegalArgumentException if result would be below absolute zero
         */
        public static double fahrenheitToKelvin(double fahrenheit) {
            double celsius = fahrenheitToCelsius(fahrenheit);
            return celsiusToKelvin(celsius);
        }
        
        /**
         * Converts Kelvin to Fahrenheit.
         * 
         * @param kelvin temperature in Kelvin
         * @return temperature in Fahrenheit
         * @throws IllegalArgumentException if kelvin is negative
         */
        public static double kelvinToFahrenheit(double kelvin) {
            double celsius = kelvinToCelsius(kelvin);
            return celsiusToFahrenheit(celsius);
        }
    }
    
    /**
     * Length conversion utilities.
     */
    public static class Length {
        // Metric conversions (base unit: meters)
        private static final double MM_TO_M = 0.001;
        private static final double CM_TO_M = 0.01;
        private static final double KM_TO_M = 1000.0;
        
        // Imperial conversions (base unit: meters)
        private static final double INCH_TO_M = 0.0254;
        private static final double FOOT_TO_M = 0.3048;
        private static final double YARD_TO_M = 0.9144;
        private static final double MILE_TO_M = 1609.344;
        
        /**
         * Converts meters to feet.
         * 
         * @param meters length in meters
         * @return length in feet
         */
        public static double metersToFeet(double meters) {
            return meters / FOOT_TO_M;
        }
        
        /**
         * Converts feet to meters.
         * 
         * @param feet length in feet
         * @return length in meters
         */
        public static double feetToMeters(double feet) {
            return feet * FOOT_TO_M;
        }
        
        /**
         * Converts kilometers to miles.
         * 
         * @param kilometers length in kilometers
         * @return length in miles
         */
        public static double kilometersToMiles(double kilometers) {
            return (kilometers * KM_TO_M) / MILE_TO_M;
        }
        
        /**
         * Converts miles to kilometers.
         * 
         * @param miles length in miles
         * @return length in kilometers
         */
        public static double milesToKilometers(double miles) {
            return (miles * MILE_TO_M) / KM_TO_M;
        }
        
        /**
         * Converts inches to centimeters.
         * 
         * @param inches length in inches
         * @return length in centimeters
         */
        public static double inchesToCentimeters(double inches) {
            return (inches * INCH_TO_M) / CM_TO_M;
        }
        
        /**
         * Converts centimeters to inches.
         * 
         * @param centimeters length in centimeters
         * @return length in inches
         */
        public static double centimetersToInches(double centimeters) {
            return (centimeters * CM_TO_M) / INCH_TO_M;
        }
    }
    
    /**
     * Weight conversion utilities.
     */
    public static class Weight {
        // Metric conversions (base unit: grams)
        private static final double MG_TO_G = 0.001;
        private static final double KG_TO_G = 1000.0;
        private static final double TONNE_TO_G = 1000000.0;
        
        // Imperial conversions (base unit: grams)
        private static final double OZ_TO_G = 28.3495;
        private static final double LB_TO_G = 453.592;
        private static final double STONE_TO_G = 6350.29;
        
        /**
         * Converts kilograms to pounds.
         * 
         * @param kilograms weight in kilograms
         * @return weight in pounds
         */
        public static double kilogramsToPounds(double kilograms) {
            return (kilograms * KG_TO_G) / LB_TO_G;
        }
        
        /**
         * Converts pounds to kilograms.
         * 
         * @param pounds weight in pounds
         * @return weight in kilograms
         */
        public static double poundsToKilograms(double pounds) {
            return (pounds * LB_TO_G) / KG_TO_G;
        }
        
        /**
         * Converts grams to ounces.
         * 
         * @param grams weight in grams
         * @return weight in ounces
         */
        public static double gramsToOunces(double grams) {
            return grams / OZ_TO_G;
        }
        
        /**
         * Converts ounces to grams.
         * 
         * @param ounces weight in ounces
         * @return weight in grams
         */
        public static double ouncesToGrams(double ounces) {
            return ounces * OZ_TO_G;
        }
    }
}