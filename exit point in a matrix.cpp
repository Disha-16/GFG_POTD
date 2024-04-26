//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<int> FindExitPoint(int n, int m, vector<vector<int>>& matrix) {
        // Code here
       
    
    // Directions are represented as (row_change, col_change)
    // Index: 0 = right, 1 = down, 2 = left, 3 = up
    vector<pair<int, int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int currentDirection = 0; // Start moving right
    int r = 0, c = 0;
    
    while (true) {
        if (matrix[r][c] == 1) {
            // Change direction to the right of current direction
            currentDirection = (currentDirection + 1) % 4;
            // Change the cell from 1 to 0
            matrix[r][c] = 0;
        }
        
        // Calculate next position
        int nextR = r + directions[currentDirection].first;
        int nextC = c + directions[currentDirection].second;
        
        // Check if next position is out of bounds
        if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) {
            return {r, c}; // We exit the matrix from current position
        }
        
        // Move to the next position
        r = nextR;
        c = nextC;
    }
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> matrix(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                cin >> matrix[i][j];
        Solution obj;
        vector<int> ans = obj.FindExitPoint(n, m, matrix);
        for (auto i : ans)
            cout << i << " ";
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends
