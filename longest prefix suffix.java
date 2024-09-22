//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        // code here
         int n = str.length();

        // Create an array to store the length of the longest proper prefix
        // which is also a suffix for all prefixes of the string.
        int lps[] = new int[n];

        // Length of the previous longest prefix suffix
        int len = 0;

        // The loop calculates lps[i] for i from 1 to n-1
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // This is tricky. Consider the example "ababa" and i = 3
                if (len != 0) {
                    len = lps[len - 1];
                    // We do not increment i here
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // lps[n-1] contains the length of the longest proper prefix 
        // which is also a suffix
        return lps[n - 1];
    }
}
