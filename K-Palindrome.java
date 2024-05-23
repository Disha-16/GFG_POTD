//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kPalindrome(String str, int n, int k) {
        // code here
         int lpsLength = longestPalindromicSubsequence(str);

        // Check if the difference between the string length and the length of its LPS is less than or equal to k
        return n - lpsLength <= k ? 1 : 0;
    }

    private int longestPalindromicSubsequence(String str) {
        int n = str.length();
        // Create a table to store the lengths of palindromic subsequences
        int[][] dp = new int[n][n];

        // Strings of length 1 are palindrome by default
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the table in a bottom-up manner
        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (str.charAt(i) == str.charAt(j) && cl == 2) {
                    dp[i][j] = 2;
                } else if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
