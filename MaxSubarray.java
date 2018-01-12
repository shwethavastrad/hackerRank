import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
		Solution solution = new Solution();

		int testCases = scanner.nextInt();

		for (int testCase = 0; testCase < testCases; ++testCase) {

			int elements = scanner.nextInt();
			int[] array = new int[elements];

			for (int i = 0; i < elements; ++i) {
				array[i] = scanner.nextInt();
			}

			int contiguousSum = highestContiguosSum(array);
			int nonContiguousSum = highestNonContiguousSum(array);

			System.out.println(contiguousSum + " " + nonContiguousSum);
		}
    }
    
    public static int highestContiguosSum(int[] array){
        int maxSoFar = array[0];
        int maxEndingHere = array[0];
        
        for(int i = 1; i < array.length; i++){
            maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
        
    }
    
    public static int highestNonContiguousSum(int[] array){
        int sum = 0;
		int smallestNegative = Integer.MIN_VALUE;

		for (int element : array) {
			if (element >= 0) {
				sum += element;
			} else {
				smallestNegative = Math.max(smallestNegative, element);
			}
		}

		int result = 0;

		if (sum == 0 && smallestNegative > Integer.MIN_VALUE) {
			result = smallestNegative;
		} else {
			result = sum;
		}
		
		return result;
        
    }
}
