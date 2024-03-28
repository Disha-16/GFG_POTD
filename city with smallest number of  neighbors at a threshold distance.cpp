//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    int findCity(int n, int m, vector<vector<int>>& edges, int distanceThreshold) {
        // Your code here
        vector<vector<int>> dist(n, vector<int>(n, INT_MAX));
    // Set the distance from a city to itself to 0
    for (int i = 0; i < n; ++i) {
        dist[i][i] = 0;
    }
    // Update the distance matrix with the given edges
    for (const auto& e : edges) {
        dist[e[0]][e[1]] = e[2];
        dist[e[1]][e[0]] = e[2];
    }

    // Floyd-Warshall Algorithm
    for (int k = 0; k < n; ++k) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dist[i][k] < INT_MAX && dist[k][j] < INT_MAX) {
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    int minReachable = INT_MAX, answer = -1;
    // Find the city with the minimum number of reachable cities within the distance threshold
    for (int i = 0; i < n; ++i) {
        int count = 0;
        for (int j = 0; j < n; ++j) {
            if (i != j && dist[i][j] <= distanceThreshold) {
                ++count;
            }
        }
        // Update answer if a smaller number of reachable cities is found
        // or if the same number is found but the current city has a greater label
        if (count <= minReachable) {
            minReachable = count;
            answer = i;
        }
    }

    return answer;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> adj;
        // n--;
        for (int i = 0; i < m; ++i) {
            vector<int> temp;
            for (int j = 0; j < 3; ++j) {
                int x;
                cin >> x;
                temp.push_back(x);
            }
            adj.push_back(temp);
        }

        int dist;
        cin >> dist;
        Solution obj;
        cout << obj.findCity(n, m, adj, dist) << "\n";
    }
}

// } Driver Code Ends
