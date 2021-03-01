import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode200 {
    public static void main(String args[]) {
        Solution200 s = new Solution200();
        s.run();
    }

}

class Solution200 {
    public void run() {
        char[][] grid = {{'1', '1', '1', '0'},
                {'1', '1', '1', '0'},
                {'1', '1', '1', '0'},
                {'0', '1', '0', '1'}};
        int num = numIslands(grid);

        System.out.print(num);
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int num = 0;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j ++) {
                char point = grid[i][j];
                if (point == '1') {
                    num ++;
                    queue.offer(new Point(i, j, '1'));
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        if (p.x - 1 >= 0 && grid[p.x-1][p.y] == '1') {
                            queue.offer(new Point(p.x - 1, p.y, '1'));
                            grid[p.x - 1][p.y] = '0';
                        }
                        if (p.x + 1 < r && grid[p.x+1][p.y] == '1') {
                            queue.offer(new Point(p.x + 1, p.y, '1'));
                            grid[p.x + 1][p.y] = '0';
                        }
                        if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == '1') {
                            queue.offer(new Point(p.x, p.y - 1, '1'));
                            grid[p.x][p.y - 1] = '0';
                        }
                        if (p.y + 1 < c && grid[p.x][p.y + 1] == '1') {
                            queue.offer(new Point(p.x , p.y + 1, '1'));
                            grid[p.x][p.y + 1] = '0';
                        }
                    }
                }
            }
        }
        return num;
    }

    class Point {
        char value;
        int x;
        int y;
        Point(int inputX, int inputY, char inputValue) {
            value = inputValue;
            x = inputX;
            y = inputY;
        }
    }
}