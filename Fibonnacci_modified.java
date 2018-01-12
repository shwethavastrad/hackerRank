import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

			BigInteger first = scanner.nextBigInteger();
			BigInteger second = scanner.nextBigInteger();
			int n = scanner.nextInt();
            
            BigInteger[] series = new BigInteger[n];
            series[0] = first;
            series[1] = second;
	
            for(int i = 2; i < n; i++){
                series[i] = (series[i-1].pow(2)).add(series[i-2]);
                
            }
            System.out.println(series[n-1]);

    }
}
