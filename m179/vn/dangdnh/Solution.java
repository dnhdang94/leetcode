package vn.dangdnh;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public String largestNumber(int[] nums) {
        List<String> numStrs = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
        for (int i = 0; i < numStrs.size() - 1; i++) {
            for (int j = numStrs.size() - 2; j >= i; j--) {
                String s1 = numStrs.get(j + 1) + numStrs.get(j);
                String s2 = numStrs.get(j) + numStrs.get(j + 1);
                if (s1.compareTo(s2) > 0) {
                    String ts = numStrs.get(j);
                    numStrs.set(j, numStrs.get(j + 1));
                    numStrs.set(j + 1, ts);
                }
            }
        }
        return removeLeadingZeros(String.join("", numStrs));
    }

    public String removeLeadingZeros(String num) {
        StringBuilder sb = new StringBuilder(num);
        while (!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 0, 0};
        System.out.println(solution.largestNumber(nums));
    }
}
