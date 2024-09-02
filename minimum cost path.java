//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

using ii=pair<int,int>;
class Solution
{
    public:
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
	bool check(int i,int j,int n){
	    if(i<0 || i>=n || j<0 || j>=n) return 0;
	    return 1;
	}
    int minimumCostPath(vector<vector<int>>& grid) 
    {
        // Code here
         int dx[]={1,-1,0,0};
        int dy[]={0,0,1,-1};
        int n= grid.size();
        int dist[n][n];
        int vis[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=1e9;
                vis[i][j]=0;
            }
        }
        
        dist[0][0]= grid[0][0];
        
        priority_queue<pair<int,ii>> pq; //dist (i,j)
        pq.push({-dist[0][0],{0,0}});
        
        while(!pq.empty()){
            auto cur= pq.top();
            pq.pop();
            int dis= -cur.first;
            int i= cur.second.first;
            int j= cur.second.second;
            
            if(vis[i][j]) continue;
            vis[i][j]=1;
            
            for(int k=0;k<4;k++){
                int nexti= i+dx[k];
                int nextj= j+dy[k];
                if(check(nexti,nextj,n)){
                    if(dist[nexti][nextj]> dis+ grid[nexti][nextj]){
                        dist[nexti][nextj]= dis+ grid[nexti][nextj];
                        pq.push({-dist[nexti][nextj],{nexti,nextj}});
                    }
                }
            }
        }
        
        return dist[n-1][n-1];
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>grid(n, vector<int>(n, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		int ans = obj.minimumCostPath(grid);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends
