# MathStats Library

A comprehensive mathematical and statistical operations library for Java, providing essential statistical calculations, mathematical utilities, and unit conversions.

## Features

### Statistics Operations
- **Mean** - Calculate arithmetic average
- **Median** - Find the middle value
- **Mode** - Identify most frequent value
- **Range** - Calculate data spread
- **Variance** - Measure data dispersion (population and sample)
- **Standard Deviation** - Calculate data variability (population and sample)

### Mathematical Utilities
- **Factorial** - Calculate n!
- **Combinations** - Calculate nCr
- **Permutations** - Calculate nPr
- **Prime Checking** - Determine if a number is prime
- **GCD** - Greatest Common Divisor
- **LCM** - Least Common Multiple
- **Fibonacci** - Generate Fibonacci numbers
- **Power** - Efficient integer exponentiation

### Unit Converters
- **Temperature** - Celsius, Fahrenheit, Kelvin conversions
- **Length** - Metric and Imperial conversions
- **Weight** - Kilograms, pounds, grams, ounces conversions

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## Installation

### Using GitHub Packages (Recommended)

Add to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/eman0012/mathstats-library</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.cst8411</groupId>
    <artifactId>mathstats-library</artifactId>
    <version>1.0.0</version>
</dependency>
```

**Note:** GitHub Packages requires authentication. Add to your `~/.m2/settings.xml`:
```xml
<servers>
    <server>
        <id>github</id>
        <username>YOUR_GITHUB_USERNAME</username>
        <password>YOUR_GITHUB_TOKEN</password>
    </server>
</servers>
```

### Using the JAR directly

1. Download the JAR from [GitHub Packages](https://github.com/eman0012/mathstats-library/packages)
2. Add it to your project's classpath

### Building from source

```bash
git clone https://github.com/eman0012/mathstats-library.git
cd mathstats-library
mvn clean package
```

This will create the following JARs in the `target` directory:
- `mathstats-library-1.0.0.jar` - Main library
- `mathstats-library-1.0.0-jar-with-dependencies.jar` - Executable JAR with demo
- `mathstats-library-1.0.0-javadoc.jar` - JavaDoc documentation
- `mathstats-library-1.0.0-sources.jar` - Source code

## Usage

### As a Library

Add the JAR to your classpath and import the classes:

```java
import com.cst8411.mathstats.Statistics;
import com.cst8411.mathstats.MathUtils;
import com.cst8411.mathstats.Converter;

// Statistics example
double[] data = {10, 20, 30, 40, 50};
double mean = Statistics.mean(data);
double median = Statistics.median(data);
double stdDev = Statistics.standardDeviation(data);

// Math utilities example
long factorial = MathUtils.factorial(5);  // Returns 120
long combinations = MathUtils.combinations(10, 3);  // Returns 120
boolean isPrime = MathUtils.isPrime(17);  // Returns true

// Converter example
double celsius = Converter.Temperature.fahrenheitToCelsius(98.6);
double meters = Converter.Length.feetToMeters(6.0);
double kg = Converter.Weight.poundsToKilograms(150);
```

### Running the Demo

The library includes an interactive demo application:

```bash
java -jar target/mathstats-library-1.0.0-jar-with-dependencies.jar
```

The demo provides a menu-driven interface to explore all library features:
1. Statistics Operations
2. Mathematical Utilities
3. Unit Converters
4. Quick Demo (All Features)

## API Documentation

### Statistics Class

| Method | Description | Parameters | Returns |
|--------|-------------|------------|---------|
| `mean(double[] data)` | Calculate arithmetic mean | Array of values | Mean value |
| `median(double[] data)` | Find median value | Array of values | Median value |
| `mode(double[] data)` | Find most frequent value | Array of values | Mode value |
| `range(double[] data)` | Calculate range | Array of values | Range |
| `variance(double[] data)` | Population variance | Array of values | Variance |
| `standardDeviation(double[] data)` | Population std dev | Array of values | Standard deviation |
| `sampleVariance(double[] data)` | Sample variance | Array of values | Sample variance |
| `sampleStandardDeviation(double[] data)` | Sample std dev | Array of values | Sample std dev |

### MathUtils Class

| Method | Description | Parameters | Returns |
|--------|-------------|------------|---------|
| `factorial(int n)` | Calculate factorial | Non-negative integer | n! |
| `combinations(int n, int r)` | Calculate combinations | n, r | nCr |
| `permutations(int n, int r)` | Calculate permutations | n, r | nPr |
| `isPrime(int n)` | Check if prime | Integer | Boolean |
| `gcd(int a, int b)` | Greatest common divisor | Two integers | GCD |
| `lcm(int a, int b)` | Least common multiple | Two integers | LCM |
| `fibonacci(int n)` | Generate Fibonacci number | Index n | Fibonacci(n) |
| `power(double base, int exp)` | Calculate power | Base and exponent | Result |

### Converter Class

Nested classes for different conversion types:

#### Temperature
- `celsiusToFahrenheit(double celsius)`
- `fahrenheitToCelsius(double fahrenheit)`
- `celsiusToKelvin(double celsius)`
- `kelvinToCelsius(double kelvin)`
- `fahrenheitToKelvin(double fahrenheit)`
- `kelvinToFahrenheit(double kelvin)`

#### Length
- `metersToFeet(double meters)`
- `feetToMeters(double feet)`
- `kilometersToMiles(double kilometers)`
- `milesToKilometers(double miles)`
- `inchesToCentimeters(double inches)`
- `centimetersToInches(double centimeters)`

#### Weight
- `kilogramsToPounds(double kilograms)`
- `poundsToKilograms(double pounds)`
- `gramsToOunces(double grams)`
- `ouncesToGrams(double ounces)`

## Testing

Run the test suite:

```bash
mvn test
```

The library includes 45 comprehensive unit tests covering all functionality.

## Project Structure

```
mathstats-library/
├── pom.xml                          # Maven configuration
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/cst8411/mathstats/
│   │           ├── Statistics.java   # Statistical operations
│   │           ├── MathUtils.java    # Mathematical utilities
│   │           ├── Converter.java    # Unit conversions
│   │           └── Demo.java         # Interactive demo
│   └── test/
│       └── java/
│           └── com/cst8411/mathstats/
│               ├── StatisticsTest.java
│               ├── MathUtilsTest.java
│               └── ConverterTest.java
└── target/                           # Generated files

```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is part of academic coursework for CST8411 at Algonquin College.

## Author

**Corneile Emanuel**  
Student ID: 041154912  
Course: CST8411 - Information Systems Development and Deployment  
Institution: Algonquin College

## Repository

- **GitHub Repository:** https://github.com/eman0012/mathstats-library
- **GitHub Packages:** https://github.com/eman0012/mathstats-library/packages
- **Package Registry:** `maven.pkg.github.com/eman0012/mathstats-library`