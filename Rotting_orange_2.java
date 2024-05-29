import java.util.LinkedList;
import java.util.Queue;

public class Rotting_orange_2 {
    class Pair {
  int row, col, time;

  Pair(int row, int col, int time) {
    this.row = row;
    this.col = col;
    this.time = time;
  }
}

class Solution {
  public int orangesRotting(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int countFresh = 0;
    Queue<Pair> q = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 2) {
          q.add(new Pair(i, j, 0));
        } else if (grid[i][j] == 1) {
          countFresh++;
        }
      }
    }

    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    int maxTime = 0;
    int cf =0;

    while (!q.isEmpty()) {
      Pair p = q.poll();
      int row = p.row;
      int col = p.col;
      int time = p.time;
      maxTime = Math.max(maxTime, time);

      for (int i = 0; i < 4; i++) {
        int nrow = row + drow[i];
        int ncol = col + dcol[i];
        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1) {
          q.add(new Pair(nrow, ncol, time + 1));
          grid[nrow][ncol] = 2;
          cf++;
        }
      }
    }

    if (countFresh != cf) return -1; // All fresh oranges should be rotten
    return maxTime;
  }
}
}
