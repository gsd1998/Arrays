package interviewQA;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingNumberArray {

    public static void main(String[] args) {
        int[] nums = {3,0,1};

        //System.out.println(missingNumberBruteForce(nums));//2
        //System.out.println(missingNumberHashArray(nums));//2
        //System.out.println(missingNumberOptimisedSolution(nums));//2
        System.out.println(missingNumberOptimisedSolutionXor(nums));
    }

    public static int missingNumberBruteForce(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        for(int i=0; i <= n; i++){
            if(!list.contains(i)){
                return i;
            }
        }
        return -1;
    }

    //using a hash array by pre-calculation
    public static int missingNumberHashArray(int[] nums) {

        int n = nums.length;
        int[] hashArr = new int[n+1];
        for(int i=0; i <= nums.length-1; i++){
            hashArr[nums[i]]++;
        }
        System.out.println(Arrays.toString(hashArr));
        for(int i = 0; i <= hashArr.length-1 ; i++){
            if(hashArr[i] == 0){
                return i;
            }
        }
        return -1;
    }

    //using concept of sum of n natural numbers
    public static int missingNumberOptimisedSolution(int[] nums) {
        int n = nums.length;

        int sum = (n*(n+1))/2; // equation for sum of n natural numbers
        int sumFromArray = 0;
        for(int i=0; i <= nums.length-1; i++){
            sumFromArray = sumFromArray + nums[i];
        }
        return sum - sumFromArray;
    }

    //optimised solution using xor
    public static int missingNumberOptimisedSolutionXor(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        int xor2 = 0;
        for(int i=0; i <= n-1; i++){
            xor2 = xor2^nums[i];
            xor1 = xor1^i;
        }
        xor1 = xor1^n;
        return xor1^xor2;
    }

}
