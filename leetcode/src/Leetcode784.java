import java.util.*;

public class Leetcode784 {
    public static void main(String args[]) {
        Solution784 s = new Solution784();
        s.run();
    }
}

class Solution784 {
    public void run() {
        String s1 = "a1b2";
        String s2 = "3z4";
        String s3 = "12345";
        List<String> list = letterCasePermutation(s1);
        list.forEach(
                l -> {
                    System.out.print(l);
                    System.out.print("\n");
                }
        );
    }

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        int length = S.length();
        dfs(0, length, result, S, stack);
        return result;
    }

    void dfs(int start, int len, List<String> result, String S, Stack<Character> stack) {
        if (stack.size() == len) {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < len; i++) {
                builder.append(stack.get(i));
            }
            result.add(builder.toString());
            return;
        }
        char ch = S.charAt(start);
        stack.push(ch);
        dfs(start + 1, len, result, S, stack);
        stack.pop();
        if (Character.isLetter(ch)) {
            ch ^= 1 << 5;
            stack.push(ch);
            dfs(start + 1, len, result, S, stack);
            stack.pop();
        }
    }
}