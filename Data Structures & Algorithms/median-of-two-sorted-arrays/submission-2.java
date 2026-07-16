class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int mid = (n + m) / 2;
        int ptr1 = 0;
        int ptr2 = 0;
        int median1 = 0;
        int median2 = 0;
        int index = 0;

        while (index <= mid) {
            median2 = median1;
            if (ptr1 < n && (ptr2 >= m || nums1[ptr1] < nums2[ptr2])) {
                median1 = nums1[ptr1];
                ptr1++;
            }
            else {
                median1 = nums2[ptr2];
                ptr2++;
            }
            index++;
        }

        


        if ((n+m)%2 == 0) {
            return (double)(median1 + median2)/2;
        } 
        return median1;
    }
}
