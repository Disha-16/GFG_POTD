//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to reverse words in a given string.
    string reverseWords(string str) {
        // code here
         string ans = "";
        string temp = "";
        
        for (int i = str.length() - 1; i >= 0; i--)  {
            if (str[i] == '.')  {
                ans += temp;
                temp = "";
                ans += ".";
            }
            else
                temp = str[i] + temp;
        }
        ans += temp;
        
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution obj;
        cout << obj.reverseWords(s) << endl;
    }
}
// } Driver Code Ends