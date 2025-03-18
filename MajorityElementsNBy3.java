package interviewQA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityElementsNBy3 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,4,5};
        //System.out.println(majorityElement(nums));//[2,3]
        //System.out.println(majorityElementUsingHashMap(nums));
        System.out.println(majorityElementOptimal(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {

        List<Integer> list = new ArrayList<>();
        int threshold = nums.length/3;
        Arrays.sort(nums);
        int majorityElement = nums[0];
        int count = 1;
        if(nums.length == 1){
            list.add(majorityElement);
        }

        for(int i = 1; i <= nums.length-1; i++){
            if(nums[i] == majorityElement){
                count++;
            } else{
                if(count > threshold){
                    if(!list.contains(nums[i-1]))
                        list.add(nums[i-1]);
                }
                majorityElement = nums[i];
                count = 1;
            }
            if(i == nums.length-1 && count > threshold){
                if(!list.contains(nums[i]))
                    list.add(nums[i]);
            }
        }
        return list;
    }




    public static List<Integer> majorityElementUsingHashMap(int []nums) {
        HashMap<Integer,Integer> hMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int threshold = n/3;

        if(n == 1){
            list.add(nums[0]);
            return list;
        }
        for(int i = 0; i <= nums.length-1; i++){
            if(hMap.containsKey(nums[i])){
                hMap.put(nums[i], hMap.get(nums[i]) + 1);
                if(hMap.get(nums[i]) == threshold+1){
                    list.add(nums[i]);
                }
            }else{
                hMap.put(nums[i],1);
            }
            if(list.size() == 2){
                break;
            }
        }
        return list;
    }

    /* This uses Boyer Moore’s Voting Algorithm */
    public static List<Integer> majorityElementOptimal(int []nums) {
        List<Integer> list = new ArrayList<>();
        int threshold = nums.length/3;
        int e1 = 0;
        int e2 = 0;
        int c1 = 0;
        int c2 = 0;

        for(int i = 0; i <= nums.length-1; i++){
            if(c1==0 && nums[i] != e2){
                e1 = nums[i];
                c1 = 1;
            }
            else if(c2==0 && nums[i] != e1){
                e2 = nums[i];
                c2 = 1;
            }
            else if(e1 == nums[i]){
                c1++;
            }
            else if(e2 == nums[i]){
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }

        /* Check if the elements e1 and e2 we got are appearing more than the threshold */
        c1 = 0;
        c2 = 0;
        for(int i = 0; i <= nums.length-1; i++){
            if(e1 == nums[i]){
                c1++;
            }
            else if(e2 == nums[i]){
                c2++;
            }
        }
        if(c1 > threshold){
            list.add(e1);
        }
        if(c2 > threshold){
            list.add(e2);
        }

        return list;
    }
}
