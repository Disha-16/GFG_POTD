//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        int[][] dp = new int[n + 1][w + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // Base case
        dp[0][0] = 0;

        // Dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (cost[i - 1] != -1 && j >= i) {
                    // Choose minimum between not including the current weight and including it
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i] + cost[i - 1]);
                } else {
                    // If the weight is not available, just copy the value from the previous row
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][w] == Integer.MAX_VALUE ? -1 : dp[n][w];
    }
}
