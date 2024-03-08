//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:	
	bool sameFreq(string s)
	{
	    // code here 
	       unordered_map<char, int> freqMap;
    
    // Count the frequency of each character
    for (char c : s) {
        freqMap[c]++;
    }
    
    unordered_map<int, int> countMap;
    // Count the frequency of each frequency :)
    for (auto& pair : freqMap) {
        countMap[pair.second]++;
    }
    
    if (countMap.size() == 1) {
        // All characters already have the same frequency
        return true;
    } else if (countMap.size() == 2) {
        // Check if one removal can make frequencies equal
        auto it = countMap.begin();
        int freq1 = it->first;
        int count1 = it->second;
        it++;
        int freq2 = it->first;
        int count2 = it->second;
        
        if ((count1 == 1 && (freq1 - 1 == freq2 || freq1 - 1 == 0)) || 
            (count2 == 1 && (freq2 - 1 == freq1 || freq2 - 1 == 0))) {
            return true;
        }
    }
    
    return false;
	}
};

//{ Driver Code Starts.
int main(){
    int t;
    cin>>t;
    while(t--)
    {
        string s;
        cin>>s;
        Solution ob;
        cout<<ob.sameFreq(s)<<endl;
    }
}



// } Driver Code Ends
