//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s1;
            s1 = br.readLine();

            String s2;
            s2 = br.readLine();

            Solution obj = new Solution();
            int res = obj.countWays(s1, s2);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
     static final int MOD = 1000000007;

    public static int countWays(String s1, String s2) {
        // code here
                int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Initializing the first column with 1
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        // Filling the dp matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If characters match, we have two choices:
                // 1. Include the character in the subsequence.
                // 2. Exclude the character from the subsequence.
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                } else {
                    // If characters don't match, we can only exclude the character.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];

    }
}
