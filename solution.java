class Solution {
    static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
    public int nearestExit(char[][] maze, int[] en) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(en[0],en[1]));
        maze[en[0]][en[1]]='+';
        int steps=0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size--!=0){
                Pair node = q.poll();
                int i=node.i;
                int j=node.j;
                if(!(i==en[0]&&j==en[1]) && (i==0 || i==m-1 || j==0 || j==n-1)){
                    return steps;
                }
                for(int[] dir:dirs){
                    int dr = i+dir[0];
                    int dc = j+dir[1];
                    if(dr>=0 && dr<m && dc>=0 && dc<n && maze[dr][dc]=='.'){
                        maze[dr][dc]='+';
                        q.add(new Pair(dr,dc));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
