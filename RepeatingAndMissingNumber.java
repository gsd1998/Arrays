package interviewQA;

import java.util.Arrays;

public class RepeatingAndMissingNumber {
    public static void main(String[] args){
        int[] nums = {1,2,2,4};
        int[] op = findErrorNums(nums);
        System.out.println(Arrays.toString(op));//[2, 3]
    }
    
    public static int[] findErrorNums(int[] nums) {
        long sArrays = 0;
        long sSquareArrays = 0;
        long n = nums.length;
        long sn = (n*(n+1))/2;
        long snSquare = (n*(n+1) * (2*n+1))/6;
        for(int i = 0; i <= n-1; i++){
            sArrays = sArrays + (long)nums[i];
            sSquareArrays = sSquareArrays + (long)nums[i] * (long)nums[i];
        }
        long val1 = sArrays - sn; //x - y = val1 -> (1)
        long val2 = sSquareArrays - snSquare; // x^2 - y^2 = val2
        val2 = val2/val1;// x + y = val2 -> (2)
        long x = (val1+val2)/2;
        long y = x - val1;
        int[] output = {(int)x, (int)y};
        return output;
    }
}

