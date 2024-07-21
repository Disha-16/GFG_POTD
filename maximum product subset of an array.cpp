//{ Driver Code Starts
/* Driver program to test above function */

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    long long int findMaxProduct(vector<int>& arr) {
        // Write your code here
          long long prod=1,maxi=INT_MIN,zero=0;
        for(int i=0;i<arr.size();i++){
            if(arr[i]!=0){
                prod=(1LL*prod*arr[i])%1000000007;
                if(arr[i]<0) maxi=max(maxi,1LL*arr[i]);
            }
            else zero++;
        }
        if(zero==arr.size()) return 0;
        if(prod<0) prod/=maxi;
        return (1LL*prod)%1000000007;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        long long int ans = ob.findMaxProduct(arr);
        cout << ans << endl;
    }
    return 0;
}

// } Driver Code Ends
