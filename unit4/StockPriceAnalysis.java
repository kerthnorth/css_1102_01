import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StockPriceAnalysis {
    ArrayList<String> data = new ArrayList<>();
    int stockPrices[] = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};
    public static Scanner scanner = new Scanner(System.in);

    /**
     * This method calculate the average price of stocks
     * it checks the length of the stock list 
     * it then adds up the stock prices and divides by the length
     * it diplays the average stock price 
     * 
     * @return the average price of stocks as a double
     */

    public double calculateAveragePrice() {
        int length = stockPrices.length;
        int sum = 0;
        for (int num : stockPrices) {
            sum += num;
        }
        double average = sum / length;
        for (int i = 0; i < length; i++) {
            // Empty loop as in original code
        }
        System.out.println("Average: " + average);
        return average;
    }

    /**
     * This methods will then find the maximum stock price
     * it makes use of java's max function the returns you the highest value in a list
     * 
     * @param stockPrices an array of stock prices
     * @return the maximum price
     */
    public int findMaximumPrice(int[] stockPrices) {
        int max = Arrays.stream(stockPrices).max().getAsInt(); 
        System.out.println("The maximum stock is: " + max);
        
        return max;
    }

    /**
     * Count the number of occurrences of a given number in the given array of stock prices.
     * This method displays to the user so that they can enter a value to target
     * using my scanner object (target value), i convert this to an int called targetNum
     * i initialise count as an int at 0
     * i then Iterate over my array list to check if the values inside are equal to my target
     * 
     * @param stockPrices an array of stock prices
     * @param num the target number to be counted
     * @return the number of occurrences as an int
     */
    public int countOccurrences(int[] stockPrices, int num) {
        System.out.println("Enter target value: ");
        String targetValue = scanner.nextLine().trim();
        int targetNum = Integer.parseInt(targetValue);
        int count = 0;
        for (int i = 0; i < stockPrices.length; i++) {
            if (stockPrices[i] == targetNum) {
                count++;
            }
        }
        System.out.println("Number of occurrences: " + count);
        return count;
    }

    /**
     * this function adds the previous value to the next to create a cumulative array list
     *
     *
     * @param stockPrices a list of stock prices
     * @return an ArrayList containing the cumulative sum of stock prices
     */

    public static ArrayList<Integer> computeCumulativeSum(ArrayList<Integer> stockPrices) {
        ArrayList<Integer> cumulativeSum = new ArrayList<>();
        int sum = 0;
        for (int price : stockPrices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        System.out.println("The cumulative sum is: "+cumulativeSum);
        return cumulativeSum;
    }

    /**
     * Runs the main program.
     * 
     * Creates an instance of this class, calls each of its methods, and closes the
     * Scanner.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        StockPriceAnalysis analysis = new StockPriceAnalysis();
        analysis.calculateAveragePrice();
        
        analysis.findMaximumPrice(analysis.stockPrices);

        analysis.countOccurrences(analysis.stockPrices, 0);
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : analysis.stockPrices) {
            list.add(num);
        }
        computeCumulativeSum(list);
        scanner.close();
    }
}
