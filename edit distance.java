//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String str1, String str2) {
        // Code here
            int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return util(str1, str2, n, m, dp);
    }
    
    int util(String str1, String str2, int n, int m, int[][] dp){
        
        if(n == 0){
            return m;
        }
        
        if(m == 0){
            return n;
        }
        
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        
        
        if(str1.charAt(n - 1) == str2.charAt(m - 1)){
            return dp[n][m] = util(str1, str2, n - 1, m - 1, dp);
        }
        
        return dp[n][m] = Math.min(util(str1, str2, n, m - 1, dp) + 1, 
                Math.min(util(str1, str2, n - 1, m, dp) + 1, util(str1, str2, n - 1, m - 1, dp) + 1));
    }
}
