package interviewQA;

import java.util.Arrays;

public class RightRotateArray {

    //Given an integer array nums, rotate the array to the right by k steps, where k is non-negative

    public static void main(String[] args) {

        int[] nums ={1,2,3,4,5,6,7};
        rotate(nums,3);
        rotateOptimized(nums,3);
        System.out.println(Arrays.toString(nums)); //[5, 6, 7, 1, 2, 3, 4]
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
         int[] tempArr = new int[k];
         int d=n-k;
         for(int i = d; i<=n-1; i++){
             tempArr[i-n+k] = nums[i];
         }
         for(int i=d-1; i>=0; i--){
             nums[i+k] = nums[i];
         }
         for(int i = 0; i< tempArr.length; i++){
             nums[i] =  tempArr[i];
         }
    }


    public static void rotateOptimized(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums,0,n-k-1);
        reverse(nums,n-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    private static void reverse(int[] arr, int left, int right){

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
