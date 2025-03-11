package interviewQA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {3,5,3,6,3,8,9,3,0,3,5,3,6,3,1,3,3};
        System.out.println(majorityElementOptimised(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i <= nums.length-1; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i],1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue() > nums.length/2){
                return e.getKey();
            }
        }
        return 0;
    }

    //Moore’s Voting Algorithm: If the array contains a majority element, its occurrence must be greater than the floor(N/2
    public static int majorityElementOptimised(int[] nums) {

        int majorityE = nums[0];
        int count = 1;
        for(int i = 1; i <= nums.length-1; i++){
            if(count == 0){
                majorityE  = nums[i];
                count = 1;
            }
            else if(nums[i] == majorityE)
                count++;
            else
                count--;
        }
        return majorityE;
    }
}
