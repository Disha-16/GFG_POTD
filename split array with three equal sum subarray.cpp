//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
//  Class Solution to contain the method for solving the problem.
class Solution {
  public:
    // Function to determine if array arr can be split into three equal sum sets.
    vector<int> findSplit(vector<int>& arr) {
        // code here
          int total = accumulate(begin(arr), end(arr), 0);
        int n = arr.size();
        
        if(total == 0) return {0, 0};
        
        if(total % 3 != 0) return {-1, -1};
        
        int equalHalves = total / 3;
        
        int firstHalf = 0;
        int i = 0;
        
        while(i < n && firstHalf + arr[i] <= equalHalves){
            firstHalf += arr[i];
            i += 1;
        }
        
        if(i == n || firstHalf != equalHalves) return {-1, -1};
        
        int thirdHalf = 0;
        int j = n - 1;
        
        while(j >= i && thirdHalf + arr[j] <= equalHalves){
            thirdHalf += arr[j];
            j -= 1;
        }
        
        if(thirdHalf != equalHalves) return {-1, -1};
        
        return {i, j};
    }
};

//{ Driver Code Starts.

int main() {
    int test_cases;
    cin >> test_cases;
    cin.ignore();
    while (test_cases--) {
        string input;
        vector<int> arr;

        // Read the array from input line
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        // Solution instance to invoke the function
        Solution ob;
        vector<int> result = ob.findSplit(arr);

        // Output result
        if (result[0] == -1 && result[1] == -1) {
            cout << "false" << endl;
        } else {
            cout << "true" << endl;
        }
    }
    return 0;
}

// } Driver Code Ends
