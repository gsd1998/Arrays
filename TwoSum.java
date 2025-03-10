package interviewQA;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        //System.out.println(Arrays.toString(twoSum(nums, 9)));
        //System.out.println(Arrays.toString(twoSumHashingApproach(nums, 9)));
        System.out.println(Arrays.toString(twoSumOptimized(nums,9)));
    }

    //Brute Force
    public static int[] twoSum(int[] nums, int target) {
        int index1 = 0;
        int index2 = 0;
        int[] outputArr = new int[2];
        for (int i = 0; i <= nums.length - 1; i++) {
            int twoSum = 0;
            for (int j = i + 1; j <= nums.length - 1; j++) {
                twoSum = nums[i] + nums[j];
                if (twoSum == target) {
                    outputArr[0] = i;
                    outputArr[1] = j;
                    break;
                }
            }
            if (twoSum == target) {
                break;
            }
        }
        return outputArr;
    }

    //Using Hashing where key is element and value is index
    public static int[] twoSumHashingApproach(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] outputArr = new int[2];
        for(int  i = 0; i <= nums.length-1; i++){
            int difference = target - nums[i];
            if(map.containsKey(difference)){
                outputArr[0] = i;
                outputArr[1] = map.get(difference);
            }
            map.put(nums[i], i);
        }
        return outputArr;
    }

    //Using two pointer approach
    public static int[] twoSumOptimized(int[] nums, int target) {
        int left = 0 ;
        int right  = nums.length -1;
        int[] out = new int[2];
        Arrays.sort(nums);
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                out[0] = nums[left];
                out[1] = nums[right];
                return out;
            }
            else if(sum > target)
                right--;
            else
                left++;
        }
        return out;
    }

}
