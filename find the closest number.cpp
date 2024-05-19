//{ Driver Code Starts
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution{
    public:
    int findClosest( int n, int k,int arr[]) 
    { 
        // Complete the function
        int left = 0, right = n - 1;
    int closest = -1;

    // Binary search to find the closest value
    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Update closest if necessary
        if (closest == -1 || abs(arr[mid] - k) <= abs(arr[closest] - k)) {
            if (abs(arr[mid] - k) == abs(arr[closest] - k))
                closest = max(closest, mid);
            else
                closest = mid;
        }

        // If k is smaller, ignore right half
        if (arr[mid] > k)
            right = mid - 1;
        // If k is greater, ignore left half
        else if (arr[mid] < k)
            left = mid + 1;
        // If k is present in the array, return k
        else
            return arr[mid];
    }

    // Return the closest value found
    return arr[closest];
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
        int arr[n];
        for (int i=0; i<n; i++)
        {
            cin>>arr[i];
        }
        Solution ob;
        cout<<ob.findClosest(n,k,arr)<<endl;
    }
}

// } Driver Code Ends
