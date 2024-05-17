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

            int x;
            x = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.findPair(n, x, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public int findPair(int n, int x, int[] arr) {
        // code here
        Arrays.sort(arr);

        // Initialize two pointers
        int left = 0, right = 1;

        // Traverse the array with two pointers
        while (right < n) {
            int diff = arr[right] - arr[left];
            if (diff == x) {
                return 1; // Pair found
            } else if (diff < x) {
                right++; // Move right pointer to increase the difference
            } else {
                left++; // Move left pointer to decrease the difference
                if (left == right) // Ensure left and right pointers are not at the same position
                    right++;
            }
        }

        return -1;
    }
}
