//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution{
    public:
    //arr1,arr2 : the arrays
    // n, m: size of arrays
    //Function to return a list containing the union of the two arrays. 
    vector<int> findUnion(int arr1[], int arr2[], int n, int m)
    {
        //Your code here
        //return vector with correct order of elements
     vector<int> result;
    int i = 0, j = 0;

    while (i < n && j < m) {
        // Handling duplicates in arr1
        while (i > 0 && i < n && arr1[i] == arr1[i - 1])
            ++i;
        // Handling duplicates in arr2
        while (j > 0 && j < m && arr2[j] == arr2[j - 1])
            ++j;

        // Compare elements from both arrays
        if (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                result.push_back(arr1[i]);
                ++i;
            } else if (arr1[i] > arr2[j]) {
                result.push_back(arr2[j]);
                ++j;
            } else {
                result.push_back(arr1[i]);
                ++i;
                ++j;
            }
        }
    }

    // Collect remaining elements from arr1
    while (i < n) {
        if (i == 0 || arr1[i] != arr1[i - 1]) {
            result.push_back(arr1[i]);
        }
        ++i;
    }

    // Collect remaining elements from arr2
    while (j < m) {
        if (j == 0 || arr2[j] != arr2[j - 1]) {
            result.push_back(arr2[j]);
        }
        ++j;
    }

    return result;
    }
};

//{ Driver Code Starts.

int main() {
	
	int T;
	cin >> T;
	
	while(T--){
	    
	    
	    
	    int N, M;
	    cin >>N >> M;
	    
	    int arr1[N];
	    int arr2[M];
	    
	    for(int i = 0;i<N;i++){
	        cin >> arr1[i];
	    }
	    
	    for(int i = 0;i<M;i++){
	        cin >> arr2[i];
	    }
	    Solution ob;
	    vector<int> ans = ob.findUnion(arr1,arr2, N, M);
	    for(int i: ans)cout<<i<<' ';
	    cout << endl;
	    
	}
	
	return 0;
}
// } Driver Code Ends
