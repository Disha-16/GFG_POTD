//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    // Function to find the number of islands.
    int numIslands(vector<vector<char>>& grid) {
        // Code here
       int n = grid.size();
        if (n == 0) return 0;
        int m = grid[0].size();
        int noOfIslands = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    noOfIslands++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return noOfIslands;
    }

  private:
    void dfs(vector<vector<char>>& grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }
        
        grid[i][j] = '2'; 
        
        dfs(grid, i - 1, j, n, m);
        dfs(grid, i + 1, j, n, m);
        dfs(grid, i, j - 1, n, m);
        dfs(grid, i, j + 1, n, m);
        dfs(grid, i + 1, j + 1, n, m);
        dfs(grid, i - 1, j - 1, n, m);
        dfs(grid, i - 1, j + 1, n, m);
        dfs(grid, i + 1, j - 1, n, m);
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<char>> grid(n, vector<char>(m, '#'));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }
        Solution obj;
        int ans = obj.numIslands(grid);
        cout << ans << '\n';
    }
    return 0;
}
// } Driver Code Ends
