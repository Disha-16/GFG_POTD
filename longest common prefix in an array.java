//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
         if (arr == null || arr.length == 0) {
            return "-1";
        }

        // Take the first string as a reference
        String prefix = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Check the prefix against each string in the array
            while (arr[i].indexOf(prefix) != 0) {
                // Reduce the prefix length by one character each time
                prefix = prefix.substring(0, prefix.length() - 1);
                // If there is no common prefix, return "-1"
                if (prefix.isEmpty()) {
                    return "-1";
                }
            }
        }

        return prefix;
    }
}