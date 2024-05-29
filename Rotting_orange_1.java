import java.util.*;


class Pair {
    int row,col,time;
    Pair(int row,int col,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ff = 0;
         Queue<Pair> q = new LinkedList<>();
        for (int i =0;i <n;i++ ){
            for(int j =0; i<m;j++){
                if(grid[i][j] == 2){
q.add(new Pair(i,j,0));
                }else if (grid [i][j] ==1){
                    ff++;
                }
            }
        }
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        int cf =0;
        int maxTime =0;
        while (!q.isEmpty()) {
      Pair p = q.poll();
      int row = p.row;
      int col = p.col;
      int time = p.time;
      maxTime = Math.max(maxTime, time);

            for(int i =0; i <4 ;i++){
                int nrow = row+ drow[i];
                int ncol = col+dcol[i];
                if(nrow >=0 &&  nrow < n && ncol >= 0  && ncol <m && grid[nrow][ncol] ==1 ){
                    q.add(new Pair(nrow,ncol,time+1));
                    grid[nrow][ncol] =2;
cf++;
                }
            }
        }
        if (cf != ff) return -1;
        return maxTime ;
    }
}