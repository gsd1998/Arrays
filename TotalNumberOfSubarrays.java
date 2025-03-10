package interviewQA;

import java.util.HashMap;

public class TotalNumberOfSubarrays {

    public static void main(String[] args) {
        int[] nums = {1,2,3,-3,1,1,1,1,4,2,-3};
        System.out.println(subarraySum(nums,3));
    }

    /*
    here we use the concept of prefix Sum
    we create a map with key as PrefixSum and value as the count of prefixSum(as negatives and zero are present same
    prefix sum value can come more than once)
    so the ideology here is, we reached prefixSum = k at index 'i'
    then there exists a prefix sum before (prefixSum - k).
    if prefixSum = 6
    k = 3
    then at 6 - 3 = 3 there is a high chance that a prefix sum exists
     */

    public static int subarraySum(int[] nums, int k) {

        int noOfSubArrays = 0;
        int sum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int mapCount = 0;
        for(int i = 0; i <= nums.length-1; i++){
            sum = sum + nums[i];
            int rem = sum - k;
            if(map.containsKey(rem)){
                count = map.get(rem);
                noOfSubArrays = noOfSubArrays + count;
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
            System.out.println(map);
        }
        return noOfSubArrays;
    }
}

/*
{0=1, 1=1}
{0=1, 1=1, 3=1}
{0=1, 1=1, 3=1, 6=1}
{0=1, 1=1, 3=2, 6=1}
{0=1, 1=1, 3=2, 4=1, 6=1}
{0=1, 1=1, 3=2, 4=1, 5=1, 6=1}
{0=1, 1=1, 3=2, 4=1, 5=1, 6=2}
{0=1, 1=1, 3=2, 4=1, 5=1, 6=2, 7=1}
{0=1, 1=1, 3=2, 4=1, 5=1, 6=2, 7=1, 11=1}
{0=1, 1=1, 3=2, 4=1, 5=1, 6=2, 7=1, 11=1, 13=1}
{0=1, 1=1, 3=2, 4=1, 5=1, 6=2, 7=1, 10=1, 11=1, 13=1}
o/p => 8

 */
