//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++

// A : given string to search
// B : vector of available strings

class Solution
{
public:
bool dictionaryContains(string &word, unordered_set<string> &dict) {
    return dict.find(word) != dict.end();
}
    int wordBreak(string s, vector<string> &dictionary) {
        //code here
         int size = s.size();
    if (size == 0) return 1;

    // Create the dictionary
    unordered_set<string> dict(dictionary.begin(), dictionary.end());

    // dp[i] is true if A[0..i-1] can be segmented into dictionary words
    vector<bool> dp(size + 1, false);
    dp[0] = true; // base case

    for (int i = 1; i <= size; i++) {
        for (int j = i - 1; j >= 0; j--) {
            if (dp[j]) {
                string word = s.substr(j, i - j);
                if (dictionaryContains(word, dict)) {
                    dp[i] = true;
                    break; // Next i
                }
            }
        }
    }

    return dp[size] ? 1 : 0;

    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        vector<string> dict;
        for(int i=0;i<n;i++){
            string S;
            cin>>S;
            dict.push_back(S);
        }
        string line;
        cin>>line;
        Solution ob;
        cout<<ob.wordBreak(line, dict)<<"\n";
    }
}

// } Driver Code Ends
