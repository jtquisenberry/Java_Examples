package arrays;

import java.util.Arrays;

//https://www.interviewcake.com/question/java/reverse-string-in-place?section=array-and-string-manipulation&course=fc1

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Reverse_String_In_Place {

 public static void reverse(char[] arrayOfChars) {

     // reverse input array of characters in place
     
     
     if (arrayOfChars.length < 2)
     {
         return;
     }
     
     int left_index = 0;
     int right_index = arrayOfChars.length -1;
     
     while (left_index < right_index)
     {
         char temp = arrayOfChars[left_index];
         arrayOfChars[left_index] = arrayOfChars[right_index];
         arrayOfChars[right_index] = temp;
         
         left_index++;
         right_index--;
     }
     
     return;
     

 }



 // tests

 @Test
 public void emptyStringTest() {
     final char[] actual = "".toCharArray();
     reverse(actual);
     final char[] expected = "".toCharArray();
     assertArrayEquals(expected, actual);
 }

 @Test
 public void singleCharacterStringTest() {
     final char[] actual = "A".toCharArray();
     reverse(actual);
     final char[] expected = "A".toCharArray();
     assertArrayEquals(expected, actual);
 }

 @Test
 public void longerStringTest() {
     final char[] actual = "ABCDE".toCharArray();
     reverse(actual);
     final char[] expected = "EDCBA".toCharArray();
     assertArrayEquals(expected, actual);
 }

 public static void main(String[] args) {
     Result result = JUnitCore.runClasses(Reverse_String_In_Place.class);
     for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
     }
     if (result.wasSuccessful()) {
         System.out.println("All tests passed.");
     }
 }
}
