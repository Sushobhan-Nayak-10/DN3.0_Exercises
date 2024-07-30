public class FinancialForecasting {

    // Method to calculate future value using recursion
    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        // Base case: if no more years to forecast, return the initial value
        if (years == 0) {
            return initialValue;
        }
        // Recursive case: calculate the future value for the next year
        double nextValue = initialValue * (1 + growthRate);
        return calculateFutureValue(nextValue, growthRate, years - 1);
    }

    // Optimized method to calculate future value using memoization
    public static double calculateFutureValueOptimized(double initialValue, double growthRate, int years, double[] memo) {
        // Base case: if no more years to forecast, return the initial value
        if (years == 0) {
            return initialValue;
        }
        // Check if the value for the current number of years is already computed
        if (memo[years] != 0) {
            return memo[years];
        }
        // Recursive case: calculate the future value for the next year
        double nextValue = initialValue * (1 + growthRate);
        memo[years] = calculateFutureValueOptimized(nextValue, growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; // Initial investment
        double growthRate = 0.05; // 5% annual growth rate
        int years = 10; // Forecast for 10 years

        // Calculate future value using the simple recursive method
        double futureValue = calculateFutureValue(initialValue, growthRate, years);
        System.out.println("Future value (recursive): " + futureValue);

        // Calculate future value using the optimized recursive method with memoization
        double[] memo = new double[years + 1];
        double futureValueOptimized = calculateFutureValueOptimized(initialValue, growthRate, years, memo);
        System.out.println("Future value (optimized): " + futureValueOptimized);
    }
}
