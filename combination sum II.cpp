//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
public:
     void findCombinations(int index, int target, vector<int>& arr, vector<int>& current, vector<vector<int>>& result) {
        if (target == 0) {
            result.push_back(current);
            return;
        }
        
        for (int i = index; i < arr.size(); i++) {
            // Skip the same element to avoid duplicates in the same recursive level
            if (i > index && arr[i] == arr[i-1]) continue;
            
            if (arr[i] > target) break; // No point in continuing if the number exceeds the target
            
            current.push_back(arr[i]);
            findCombinations(i + 1, target - arr[i], arr, current, result);
            current.pop_back();
        }
    }
    vector<vector<int>> CombinationSum2(vector<int> arr,int n,int k)
    {
        //code here
          vector<vector<int>> result;
        vector<int> current;
        sort(arr.begin(), arr.end()); // Sort the array to handle duplicates and to ensure the combinations are sorted
        findCombinations(0, k, arr, current, result);
        return result;
    }
};

//{ Driver Code Starts.


int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,k;
        cin>>n>>k;
        vector<int> arr(n);
        for(int i=0;i<n;i++)
        {
            cin>>arr[i];
        }
        Solution ob;
        auto obj=ob.CombinationSum2(arr,n,k);
        for(int i=0;i<obj.size();i++)
        {
            for(int j=0;j<obj[i].size();j++)
            {
                cout<<obj[i][j]<<" ";
            }
            cout<<"\n";
        }
        if(obj.size()==0) cout<<"\n";
    }
    return 0;
}
// } Driver Code Ends
