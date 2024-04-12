//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    long long pairAndSum(int n, long long arr[]) {
        // code here
         long long sum = 0;

    // For each bit position
    for (int bit = 0; bit < 31; bit++) {
        // Count how many numbers have this bit set
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] & (1 << bit)) {
                count++;
            }
        }

        // Every pair of numbers contributing this bit will add 2^bit to the total sum
        // countC2 = count * (count - 1) / 2; is the number of ways we can pick 2 numbers from 'count'
        long long countC2 = (long long) count * (count - 1) / 2;
        sum += countC2 * (1 << bit);
    }

    return sum;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        long long Arr[N];
        for (int i = 0; i < N; i++) {
            cin >> Arr[i];
        }
        Solution ob;
        cout << ob.pairAndSum(N, Arr) << endl;
    }
    return 0;
}
// } Driver Code Ends
