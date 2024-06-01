//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
       HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int x = 0, y = 0;
        // Iterate through the characters in the string
        for (char c : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(c);
            // Check if the character's position in the English alphabet is even or odd
            int position = c - 'a' + 1; // assuming input contains only lowercase English characters
            if (position % 2 == 0 && frequency % 2 == 0) {
                x++; // Count characters with even position and even frequency
            } else if (position % 2 != 0 && frequency % 2 != 0) {
                y++; // Count characters with odd position and odd frequency
            }
        }

        // Check if the sum of x and y is even or odd
        if ((x + y) % 2 == 0) {
            return "EVEN";
        } else {
            return "ODD";
        }
    }
}
