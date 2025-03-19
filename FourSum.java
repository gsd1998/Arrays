package interviewQA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = {4,3,3,4,4,2,1,2,1,1};
        System.out.println(fourSumOptimal(nums, 9));//[[1, 1, 3, 4], [1, 2, 2, 4], [1, 2, 3, 3]]
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> outputList = new ArrayList<>();
        for(int i = 0; i <= n-1; i++){
            for(int j = i+1; j <= n-1; j++){
                for(int k = j+1; k <= n-1; k++){
                    for(int l = k+1; l <= n-1; l++){

                        if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(list);
                            if(!outputList.contains(list)){
                                outputList.add(list);
                            }
                        }
                    }
                }
            }
        }
        return outputList;
    }

    public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> outputList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i <= n-1; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1; j <= n-1; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int k = j+1;
                int l = n-1;
                while(k < l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum < target){
                        k++;
                    }else if(sum > target){
                        l--;
                    }else {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        outputList.add(list);
                        k++;
                        l--;

                        while(k < l && nums[k] == nums[k-1]){
                            k++;
                        }
                        while(k < l && nums[l] == nums[l+1]){
                            l--;
                        }
                    }
                }
            }
        }
        return outputList;
    }
}
