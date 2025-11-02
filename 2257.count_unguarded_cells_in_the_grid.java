class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
    
    boolean[][] guarded = new boolean[m][n];
    boolean[][] blocked = new boolean[m][n];

    // Mark guards and walls as blocked
    for (int[] g : guards)
        blocked[g[0]][g[1]] = true;
    for (int[] w : walls)
        blocked[w[0]][w[1]] = true;

    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    // Mark guarded cells
    for (int[] g : guards) {
        for (int[] d : dirs) {
            int x = g[0] + d[0], y = g[1] + d[1];
            while (x >= 0 && x < m && y >= 0 && y < n && !blocked[x][y]) {
                guarded[x][y] = true;
                x += d[0];
                y += d[1];
            }
        }
    }

    // Count unguarded and unblocked cells
    int count = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (!guarded[i][j] && !blocked[i][j])
                count++;
        }
    }

    return count;
}
}
    
