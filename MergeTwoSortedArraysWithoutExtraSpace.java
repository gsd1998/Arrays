package interviewQA;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {

    public static void main(String[] args) {

        long[] nums1 = {1, 8, 8};
        long[] nums2 = {2, 3, 4, 5};
        mergeTwoSortedArraysWithoutExtraSpace(nums1,nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        int left = a.length-1;
        int right = 0;
        while(left >=0 && right <= b.length-1){
            if(a[left] > b[right]){
                long temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    //Using gap algo
    public static void mergeTwoSortedArraysWithoutExtraSpaceOptimised(long[] arr1, long[] arr2) {

        int n = arr1.length;
        int m = arr2.length;
        int len = n + m;
        int gap = (len / 2) + (len % 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }


}
