import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[m];
        for(int i = 0; i < m; i++){
            coins[i] = sc.nextInt();
        }
        
        long r = change(coins, n);
        System.out.println(r);
    }
    
    public static int count(int[] c, int m, int n){
        int[][] table = new int[n+1][m];
        int x, y;
        // Fill the enteries for 0 value case (n = 0)
        for (int i=0; i<m; i++)
            table[0][i] = 1;
        
        for (int i = 1; i <=n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                // Count of solutions including S[j]
                x = (i-c[j] >= 0)? table[i - c[j]][j]: 0;
 
                // Count of solutions excluding S[j]
                y = (j >= 1)? table[i][j-1]: 0;
 
                // total count
                table[i][j] = x + y;
            }
        }
        return table[n][m-1];
        
        
    }
    
     public static long change(int[] coins, int N) {
        long[] numCoins = new long[N+1];
        numCoins[0] = 1;
        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j < numCoins.length; j++) {
                numCoins[j] += numCoins[j - coins[i]];
            }
        }
        return numCoins[N];
    }
}
