public class Leetcode26 {
    public static void main(String[] args) {
        Solution26 s = new Solution26();
        s.run();
    }
}

class Solution26 {
    public void run() {
        int[] input = {0,0,1,1,1,3,3,3,3,4};
        int len = removeDuplicates(input);
        System.out.printf("length: %d \n", len);
        for (int i: input) {
            System.out.printf("%d ", i);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len == 0 || len == 1) {
            return len;
        }
        int p = 0;
        int q = 1;
        while (q < len) {
            if (nums[p] != nums[q]) {
                p++;
                nums[p] = nums[q];
            }
            q++;
        }
        return p + 1;
    }
}
