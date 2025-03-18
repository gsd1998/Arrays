package interviewQA;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        System.out.println(threeSumOptimal(nums));// [[-2, 0, 2], [-2, 1, 1]]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i <= n-1; i++){
            for(int j = i+1; j <= n-1; j++){
                for(int k = j+1; k <= n-1; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            Collections.sort(list);
                            if(!outputList.contains(list)){
                                outputList.add(list);
                            }
                    }
                }
            }
        }
        return outputList;
    }

    public static List<List<Integer>> threeSumUsingHashing(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i <= n-1; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i+1; j <= n-1; j++){
                int target = -(nums[i] + nums[j]);
                if(set.contains(target)){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target);
                    Collections.sort(list);
                    if(!outputList.contains(list)){
                        outputList.add(list);
                    }
                }
                set.add(nums[j]);
            }
        }
        return outputList;
    }

    //O(N) + O(NlogN)
    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i <= n-1; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                } else if (sum < 0){
                    j++;
                } else{
                    List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                    outputList.add(list);
                    k--;
                    j++;
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                }
            }
        }
        return outputList;
    }
}
