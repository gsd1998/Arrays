package interviewQA;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColorsOptimized(nums);
        System.out.println(Arrays.toString(nums));
    }

    //This is a kind of Brute force approach coz we are not allowed to use any library's sort function.
    public static void sortColors(int[] nums) {
        int c1 = 0, c2 = 0, c3 = 0;
        for(int i = 0; i <= nums.length-1; i++){
            if(nums[i] == 0)
                c1++;
            if(nums[i] == 1)
                c2++;
            if(nums[i] == 2)
                c3++;
        }
        for(int i = 0; i < c1; i++){
            nums[i] = 0;
        }
        for(int i = c1; i < c1+c2; i++){
            nums[i] = 1;
        }
        for(int i = c1+c2; i <= nums.length-1; i++){
            nums[i] = 2;
        }
    }

    //This uses a three pointer approach -> Dutch National flag algorithm
    /*  arr[0….low-1] contains 0. [Extreme left part]
        arr[low….mid-1] contains 1.
        arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
    */

    public static void sortColorsOptimized(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(low, mid, nums);
                mid++;
                low++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swap(mid, high, nums);
                high--;
            }
        }
    }

    private static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
