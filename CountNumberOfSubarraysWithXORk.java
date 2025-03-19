package interviewQA;

import java.util.HashMap;

public class CountNumberOfSubarraysWithXORk {

    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 6, 4};
        System.out.println(solve(nums,6));
    }

    public static int solve(int[] A, int B) {
        int count = 0;
        int maxCount = 0;
        int xor = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i <= A.length-1; i++){
            xor = xor^A[i];
            int target = xor^B;
            if(map.containsKey(target)){
                count = map.get(target);
                maxCount = maxCount + count;
            }
            map.put(xor,map.getOrDefault(xor,0) + 1);
        }
        return maxCount;
    }
}
