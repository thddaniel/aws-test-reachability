import java.util.Stack;

public class Leetcode547 {
    public static void main(String[] args) {
        Solution547 s = new Solution547();
        s.run();
    }
}

class Solution547 {
    public void run() {
        int[][] m1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = findCircleNumByDfs(m1);
        System.out.printf("n1:%d", n);
    }

    public void dfsRecursive(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfsRecursive(M, visited, j);
            }
        }
    }
    public int findCircleNumByDfsRecursive(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfsRecursive(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public int findCircleNumByDfs(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                stack.push(i);
                while (!stack.isEmpty()) {
                    int s = stack.pop();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            stack.push(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
