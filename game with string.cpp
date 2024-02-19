//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    int minValue(string s, int k){
        // code here
        unordered_map<char, int> freq;
    for (char c : s) {
        freq[c]++;
    }

    // Step 2: Use a priority queue to store the frequencies
    priority_queue<int> maxHeap;
    for (auto it = freq.begin(); it != freq.end(); ++it) {
        maxHeap.push(it->second);
    }

    // Step 3: Remove k characters
    while (k-- > 0 && !maxHeap.empty()) {
        int top = maxHeap.top();
        maxHeap.pop();
        top--;
        if (top > 0) {
            maxHeap.push(top);
        }
    }

    // Step 4: Calculate the sum of squares of frequencies
    int value = 0;
    while (!maxHeap.empty()) {
        int top = maxHeap.top();
        maxHeap.pop();
        value += top * top;
    }

    return value;

    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        string s;
        int k;
        cin>>s>>k;
        
        Solution ob;
        cout<<ob.minValue(s, k)<<"\n";
    }
    return 0;
}
// } Driver Code Ends
