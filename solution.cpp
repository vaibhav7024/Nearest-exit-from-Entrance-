class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& ent) {
        int n=maze.size();
        int m=maze[0].size();
        vector<vector<int>> dirs ={{-1,0},{0,-1},{1,0},{0,1}};
        queue<pair<pair<int,int>,int>> q;
        q.push({{ent[0],ent[1]},0});
        maze[ent[0]][ent[1]]='+';
        while(!q.empty()){
            auto node = q.front();
            q.pop();
            int r = node.first.first;
            int c = node.first.second;
            int val = node.second;
            if((r==0||r==n-1 || c==0 || c==m-1 )&& !(r==ent[0] && c==ent[1])){
                return val;
            }
            for(auto dir:dirs){
                int dr = r+dir[0];
                int dc = c+dir[1];
                if(dr>=0 && dr<n && dc>=0 && dc<m && maze[dr][dc]=='.'){
                    maze[dr][dc] = '+';
                    q.push({{dr,dc},val+1});
                }
            }
        }
        return -1;
    }
};
