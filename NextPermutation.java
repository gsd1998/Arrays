package interviewQA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {2,5,6,4,3,0,0};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(0, n-1, nums);
            return;
        }
        for(int i = n-1; i > index; i--){
            if(nums[i] > nums[index]){
                swap(index,i,nums);
                break;
            }
        }
        reverse(index+1, n-1, nums);
    }
    private static void swap(int index, int i, int[] nums){
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
    private static void reverse(int left, int right, int[] nums){
        while(left <= right){
            swap(left,right,nums);
            left++;
            right--;
        }
    }
}
