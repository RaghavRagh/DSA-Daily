public class MedianOf2SortedArrays {

    // TC - O(n + m)
    private static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int idx1 = n / 2;
        int idx2 = idx1 - 1;
        int ptr = 0;
        int i = 0, j = 0;
        int ele1 = -1, ele2 = -1;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (ptr == idx1)
                    ele1 = nums1[i];
                if (ptr == idx2)
                    ele2 = nums1[i];
                ptr++;
                i++;
            } else {
                if (ptr == idx1)
                    ele1 = nums2[j];
                if (ptr == idx2)
                    ele2 = nums2[j];
                ptr++;
                j++;
            }
        }

        while (i < nums1.length) {
            if (ptr == idx1)
                ele1 = nums1[i];
            if (ptr == idx2)
                ele2 = nums1[i];
            ptr++;
            i++;
        }

        while (j < nums2.length) {
            if (ptr == idx1)
                ele1 = nums2[j];
            if (ptr == idx2)
                ele2 = nums2[j];
            ptr++;
            j++;
        }

        if (n % 2 == 1) {
            return ele1;
        }

        return (double) (ele1 + ele2) / 2.0;
    }

    // TC - O(min(logn, logm))
    private static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        // we want to apply binary search on the shorter array
        if (n1 > n2) {
            return findMedianSortedArrays2(nums2, nums1);
        }

        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;
        int n = n1 + n2;
        while (low <= high) {
            int mid1 = (low + high) >> 1; // (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };

        // System.out.println(findMedianSortedArrays1(nums1, nums2));
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }
}
