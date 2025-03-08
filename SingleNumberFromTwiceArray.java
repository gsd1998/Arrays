package interviewQA;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberFromTwiceArray {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        //System.out.println(singleNumber(nums));//4
        System.out.println(singleNumberXor(nums));//4
    }

    public static int singleNumber(int[] nums) {
        int count=0;
        int singleNumber = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i <= nums.length-1; i++){
            if(map.containsKey(nums[i])) {
                count = map.get(nums[i]);
                count++;
                map.put(nums[i], count);
            }
            else
                map.put(nums[i],1);
        }

        for(Map.Entry<Integer,Integer> element : map.entrySet()){
            if(element.getValue() == 1){
                singleNumber = element.getKey();
                break;
            }
        }
        return singleNumber;

        //O(NlogN) + O(N/2 +1)
        //O(N/2 + 1)
    }

    //using xor -> all the elements appearing twice will be 0 and single element xor 0 would be that single element itself
    public static int singleNumberXor(int[] nums) {
        int xor = 0;
        for(int i=0; i <= nums.length-1; i++){
            xor = xor^nums[i];
        }
        return xor;
        //O(N)
        //O(1)
    }


}
