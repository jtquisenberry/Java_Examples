package greedy_algorithms;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

// https://www.interviewcake.com/question/java/highest-product-of-3?section=greedy&course=fc1

import static org.junit.Assert.*;

public class Highest_Product_Of_Three {

    public static int highestProductOf3(int[] intArray) {

        // calculate the highest product of three numbers
        
        if (intArray.length < 3)
        {
            throw new IllegalArgumentException("iae");
        }
        
        
        int highestSingle = Math.max(intArray[0], intArray[1]);
        int lowestSingle = Math.min(intArray[0], intArray[1]);
        int highestPair = intArray[0] * intArray[1];
        int lowestPair = intArray[0] * intArray[1];
        int highestTriple = intArray[0] * intArray[1] * intArray[2];
        
        
        for (int i = 2; i < intArray.length; i++)
        {
            int currentNumber = intArray[i];
            highestTriple = Math.max(highestTriple, 
                Math.max(currentNumber * highestPair, currentNumber * lowestPair));
            highestPair = Math.max(highestPair, 
                Math.max(currentNumber * highestSingle, currentNumber * lowestSingle));
            lowestPair = Math.min(lowestPair, 
                Math.min(currentNumber * highestSingle, currentNumber * lowestSingle));
            highestSingle = Math.max(currentNumber, highestSingle);
            lowestSingle = Math.min(currentNumber, lowestSingle);
        }
        

        return highestTriple;
    }


















    // tests

    @Test
    public void shortArrayTest() {
        final int actual = highestProductOf3(new int[] {1, 2, 3, 4});
        final int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void longerArrayTest() {
        final int actual = highestProductOf3(new int[] {6, 1, 3, 5, 7, 8, 2});
        final int expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasOneNegativeTest() {
        final int actual = highestProductOf3(new int[] {-5, 4, 8, 2, 3});
        final int expected = 96;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoNegativesTest() {
        final int actual = highestProductOf3(new int[] {-10, 1, 3, 2, -10});
        final int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayIsAllNegativesTest() {
        final int actual = highestProductOf3(new int[] {-5, -1, -3, -2});
        final int expected = -6;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        highestProductOf3(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        highestProductOf3(new int[] {1});
    }

    @Test(expected = Exception.class)
    public void exceptionWithTwoNumbersTest() {
        highestProductOf3(new int[] {1, 1});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Highest_Product_Of_Three.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
