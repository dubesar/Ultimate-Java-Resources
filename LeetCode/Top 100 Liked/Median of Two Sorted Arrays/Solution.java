import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length-1;
        int n = nums2.length-1;
        int[] sum = new int[m+n+2];

        while (m >= 0 || n >= 0) {
            if (m >= 0) {
                if (n < 0 || nums1[m] >= nums2[n]) {
                    sum[m+n+1] = nums1[m];
                    m--;
                }
            }
            if (n >= 0) {
                if (m < 0 || nums1[m] <= nums2[n]) {
                    sum[m+n+1] = nums2[n];
                    n--;
                }
            }
        }

        if (sum.length % 2 == 0) {
            return ((double)sum[sum.length/2-1] + sum[sum.length/2]) / 2;
        }
        return sum[sum.length/2];
    }
}
