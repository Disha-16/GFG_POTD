//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        // code here
        int n=str.length();
        Integer dp[][] = new Integer[n][n];
        return solve(0,n-1,dp,str);
    }
    static int solve(int i,int j,Integer dp[][],String s){
        if(i>=j)    return 0;
        if(dp[i][j]!=null)  return dp[i][j];
        
        if(s.charAt(i)==s.charAt(j))    return dp[i][j] = solve(i+1,j-1,dp,s);
        return dp[i][j] = Math.min( solve(i+1,j,dp,s) , solve(i,j-1,dp,s) ) + 1;
    }
}
