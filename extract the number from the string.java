//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(sentence);
        
        long largest = -1;
        
        // Iterate through all found numbers
        while (matcher.find()) {
            String numStr = matcher.group();
            
            // Check if the number contains '9'
            if (!numStr.contains("9")) {
                // Parse the number and check if it's the largest
                long number = Long.parseLong(numStr);
                if (number > largest) {
                    largest = number;
                }
            }
        }
        
        return largest;
    }
}
