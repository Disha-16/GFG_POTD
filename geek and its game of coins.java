//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findWinner(n, x, y);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findWinner(int n, int x, int y) {
        // code here
         int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            if (i - 1 >= 0 && dp[i - 1] == 0)
                dp[i] = 1; // If one coin is a winning move, choose it
            else if (i - x >= 0 && dp[i - x] == 0)
                dp[i] = 1; // If x coins is a winning move, choose it
            else if (i - y >= 0 && dp[i - y] == 0)
                dp[i] = 1; // If y coins is a winning move, choose it
            else
                dp[i] = 0; // If none of the above is a winning move, choose any other move
        }
        
        return dp[n];
    }
}
