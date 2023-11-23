package vn.dangdnh;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = l1 + l2;
        int[] res = new int[l];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l1 && j < l2) {
            if (nums1[i] <= nums2[j]) {
                res[k] = nums1[i];
                ++i;
            } else {
                res[k] = nums2[j];
                ++j;
            }
            ++k;
        }
        if (i < l1) {
            for (; i < l1; ++i) {
                res[k] = nums1[i];
                ++k;
            }
        }
        if (j < l2) {
            for (; j < l2; ++j) {
                res[k] = nums2[j];
                ++k;
            }
        }
        return l % 2 != 0 ? (float) res[l / 2] : (float) (res[l / 2 - 1] + res[l / 2]) / 2;
    }

    public static void main(String[] args) {

    }
}
