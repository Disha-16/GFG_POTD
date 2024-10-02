//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int rotateDelete(vector<int> &arr) {
        // Your code here
         int l = arr.size();
        int k = 1;

        while (l > 1) {
            // Move the last element to the front
            arr.insert(arr.begin(), arr.back());
            arr.pop_back();
            
            // Remove element based on k value
            if (k > l) {
                arr.erase(arr.begin()); // Remove the first element
            } else {
                arr.erase(arr.end() - k); // Remove the element at position l - k
            }

            // Update the size and increment k
            l = arr.size();
            k++;
        }

        // Return the last remaining element
        return arr[0];
    }
};


//{ Driver Code Starts.

int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        Solution obj;
        int res = obj.rotateDelete(arr);
        cout << res << endl;
        // string tl;
        // getline(cin, tl);
    }
    return 0;
}

// } Driver Code Ends
