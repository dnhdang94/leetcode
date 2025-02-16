package vn.dangdnh;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            int val = Math.abs(nums[i]);
            if (1 <= val && val <= len) {
                nums[val - 1] = -1 * Math.abs(nums[val - 1]);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
