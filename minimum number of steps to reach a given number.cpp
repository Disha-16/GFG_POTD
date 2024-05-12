//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int minSteps(int d) {
        // code here
         int n = 0;
    int sum = 0;
    // Since d is positive as per the constraint, make d positive if it isn't
    d = std::abs(d);

    while (true) {
        n++;
        sum += n;
        int delta = sum - d;
        if (delta >= 0 && delta % 2 == 0) {
            return n;
        }
    }
    
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int d;
        cin >> d;

        Solution ob;
        cout << ob.minSteps(d) << "\n";
    }
    return 0;
}
// } Driver Code Ends
