package greedy_algorithms;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

// https://www.interviewcake.com/question/java/stock-price?section=greedy&course=fc1


import static org.junit.Assert.*;

public class Max_Profit {

    public static int getMaxProfit(int[] stockPrices) {

        // calculate the max profit
        
        
        if (stockPrices.length < 2)
        {
            throw new IllegalArgumentException("iae");
        }
        
        
        int lowestPrice = stockPrices[0];
        int bestProfit = stockPrices[1] - stockPrices[0];
        
        for (int i = 1; i < stockPrices.length; i++)
        {
            int currentPrice = stockPrices[i];
            int currentProfit = currentPrice - lowestPrice;
            bestProfit = Math.max(currentProfit, bestProfit);
            lowestPrice = Math.min(lowestPrice, currentPrice);
            
        }
        

        return bestProfit;
    }


















    // tests

    @Test
    public void priceGoesUpThenDownTest() {
        final int actual = getMaxProfit(new int[] {1, 5, 3, 2});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownThenUpTest() {
        final int actual = getMaxProfit(new int[] {7, 2, 8, 9});
        final int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesUpAllDayTest() {
        final int actual = getMaxProfit(new int[] {1, 6, 7, 9});
        final int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownAllDayTest() {
        final int actual = getMaxProfit(new int[] {9, 7, 4, 1});
        final int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    public void priceStaysTheSameAllDayTest() {
        final int actual = getMaxProfit(new int[] {1, 1, 1, 1});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithOnePriceTest() {
        getMaxProfit(new int[] {5});
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyPricesTest() {
        getMaxProfit(new int[] {});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Max_Profit.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}