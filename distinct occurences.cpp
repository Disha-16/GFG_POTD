//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
 

// } Driver Code Ends
/*You are required to complete this method*/

class Solution
{
    public:
    const int MOD = 1e9 + 7;
    int subsequenceCount(string s, string t)
    {
      //Your code here
      int n = s.length();
    int m = t.length();

    // Create a 2D DP table
    vector<vector<long long>> dp(m + 1, vector<long long>(n + 1, 0));

    // Base case initialization
    for (int j = 0; j <= n; j++) {
        dp[0][j] = 1; // An empty string is a subsequence of any string only 1 time.
    }

    // Fill dp table
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            // If last characters don't match, ignore the last character of s
            if (t[i - 1] != s[j - 1]) {
                dp[i][j] = dp[i][j - 1];
            } else {
                // If last characters match, consider both ignoring and including the last character of s
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1]) % MOD;
            }
        }
    }

    return dp[m][n];
    }
};
 


//{ Driver Code Starts. 

//  Driver code to check above method
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		string s;
		string tt;
		cin>>s;
		cin>>tt;
		
		Solution ob;
		cout<<ob.subsequenceCount(s,tt)<<endl;
		
		
	}
  
}
// } Driver Code Ends
