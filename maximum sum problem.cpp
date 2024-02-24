//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
    public:
        int maxSum(int n)
        {
            //code here.
             if (n == 0)
            return 0;

        vector<int> max_sum(n + 1, 0);

        // Calculating Maximum sum for each Number from 1 to n
        for (int i = 1; i <= n; ++i)
        {
            max_sum[i] = max(i, max_sum[i / 2] + max_sum[i / 3] + max_sum[i / 4]);
        }

        return max_sum[n];
        }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        Solution ob;
        cout<<ob.maxSum(n)<<"\n";
    }
    return 0;
}
// } Driver Code Ends
