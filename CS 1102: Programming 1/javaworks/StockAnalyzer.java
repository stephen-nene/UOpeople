import java.util.ArrayList;

public class StockAnalyzer {

    // Method to calculate the average stock price
    public static float calculateAveragePrice(float[] stockPrices) {
        float sum = 0;
        for (float price : stockPrices) {
            sum += price;
        }
        return sum / stockPrices.length;
    }

    // Method to find the maximum stock price
    public static float findMaximumPrice(float[] stockPrices) {
        float maxPrice = Float.MIN_VALUE;
        for (float price : stockPrices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    // Method to count occurrences of a specific price
    public static int countOccurrences(float[] stockPrices, float targetPrice) {
        int count = 0;
        for (float price : stockPrices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    // Method to compute cumulative sum of stock prices
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> stockPrices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : stockPrices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

    public static void main(String[] args) {
        // Example usage
        float[] stockPricesArray = {10.5f, 12.0f, 11.8f, 13.2f, 12.5f, 14.0f, 13.7f, 15.5f, 14.8f, 16.0f};
        ArrayList<Float> stockPricesArrayList = new ArrayList<>();
        for (float price : stockPricesArray) {
            stockPricesArrayList.add(price);
        }

        // Calculate average stock price
        float averagePrice = calculateAveragePrice(stockPricesArray);
        System.out.println("Average Stock Price: " + averagePrice);

        // Find maximum stock price
        float maximumPrice = findMaximumPrice(stockPricesArray);
        System.out.println("Maximum Stock Price: " + maximumPrice);

        // Count occurrences of a specific price
        float targetPrice = 13.7f;
        int occurrences = countOccurrences(stockPricesArray, targetPrice);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrences);

        // Compute cumulative sum of stock prices
        ArrayList<Float> cumulativeSum = computeCumulativeSum(stockPricesArrayList);
        System.out.println("Cumulative Sum of Stock Prices: " + cumulativeSum);
    }
}
