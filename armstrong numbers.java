//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        // code here
        int hundreds = n / 100;
        int tens = (n / 10) % 10;
        int units = n % 10;
        
        // Calculate the sum of cubes of digits
        int sumOfCubes = (hundreds * hundreds * hundreds) + (tens * tens * tens) + (units * units * units);
        
        // Check if the sum of cubes is equal to the number itself
        if (sumOfCubes == n) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
