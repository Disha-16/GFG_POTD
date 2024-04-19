//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	
	
	public:
	vector<int> findMissing(int a[], int b[], int n, int m) 
	{ 
	    // Your code goes here
	     unordered_set<int> bSet;
    
    // Insert all elements of array b into the set
    for (int i = 0; i < m; ++i) {
        bSet.insert(b[i]);
    }
    
    // Create a vector to store the result
    vector<int> result;
    
    // Check each element in array a and see if it's not in bSet
    for (int i = 0; i < n; ++i) {
        if (bSet.find(a[i]) == bSet.end()) {
            result.push_back(a[i]); // Add to result if not found in bSet
        }
    }
    
    // Return the resulting vector
    return result;
	} 
};
	

//{ Driver Code Starts.

int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
    	int n;
        cin>>n;
        int m;
        cin>>m;
        int a[n];
        int b[m];
        for(int i=0;i<n;i++)
        cin>>a[i];
        for(int i=0;i<m;i++)
        cin >> b[i];
        vector<int> ans;
        

        Solution ob;
        ans=ob.findMissing(a,b,n,m);
        for(int i=0;i<ans.size();i++)
        cout<<ans[i]<<" ";
	    
        
	    cout << "\n";
	     
    }
    return 0;
}
// } Driver Code Ends
