package interviewQA;

import java.util.Arrays;

public class MaximumSubarraySum {

    public static void main(String[] args) {

        int[] nums ={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    // Kadane's Algorithm =>
    // A subarray with a sum less than 0 will always reduce our answer and so this type of subarray
    // cannot be a part of the subarray with maximum sum.
    public static int maxSubArray(int[] nums) {
        int maxSum= Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i <= nums.length-1; i++){
            if(sum == 0){
                start = i;
            }
            sum = sum + nums[i];
            if(sum > maxSum){
                maxSum = sum;
                end = i;
            }
            if(sum < 0)
                sum = 0;
        }
        /* This will print the maxiumum subarray
        *  Whenever sum == 0 then we are starting a new subarray hence start becomes i at sum == 0
        *  Hence maxSubarray would be till sum become > than maxSum which we will mark as end.
        * */
        int[] arr = new int[end - start + 1];
        for(int i=0; i <= end - start; i++){
            arr[i] = nums[i + start];
        }

        System.out.println(Arrays.toString(arr));
        return maxSum;
    }
}
