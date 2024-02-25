//{ Driver Code Starts
// Driver Code
#include<bits/stdc++.h>
#define ll long long int
using namespace std;

// } Driver Code Ends

class Solution
{
    public:
    // Complete this function
    long long int count(long long int n)
    {
    	// Your code here
    	 int scores[] = {3, 5, 10};
    int m = sizeof(scores)/sizeof(scores[0]); // Number of scoring options
    
    // dp[i] will be storing the number of solutions for value i.
    vector<int> dp(n+1, 0);
    
    // There is one way to reach 0.
    dp[0] = 1;
    
    // Fill dp[] in a bottom-up manner
    for(int i=0; i<m; i++) {
        for(int j=scores[i]; j<=n; j++) {
            dp[j] += dp[j - scores[i]];
        }
    }
    
    return dp[n];
    	
    }
};

//{ Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		ll n;
		cin>>n;
		Solution obj;
		cout<<obj.count(n)<<endl;
	}
	return 0;
}
// } Driver Code Ends
