class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int index1 = 0, index2 = 0, index = 0;
        
        // Merge nums1 and nums2 into arr
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                arr[index++] = nums1[index1++];
            } else {
                arr[index++] = nums2[index2++];
            }
        }
        
        // Append the remaining elements of nums1, if any
        while (index1 < nums1.length) {
            arr[index++] = nums1[index1++];
        }
        
        // Append the remaining elements of nums2, if any
        while (index2 < nums2.length) {
            arr[index++] = nums2[index2++];
        }
        
        // Calculate the median
        if (arr.length % 2 == 1) {
            return (double) arr[arr.length / 2];
        } else {
            return (double) (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        }
    }
}
