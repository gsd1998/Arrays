package interviewQA;

public class MaxConsecutiveOnes {

        /*
        Given a binary array nums, return the maximum number of consecutive 1's in the array

        */

        public static void main(String[] args) {

            int[] nums = {1,1,0,1,1,1};
            int maxCount  = findMaxConsecutiveOnes(nums);
            System.out.println(maxCount); //3

        }
        public static int findMaxConsecutiveOnes(int[] nums) {
            int consecutiveCount = 0;
            int maxCount = 0;
            for(int i=0; i <= nums.length-1; i++){
                if(nums[i]==1){
                    consecutiveCount++;
                    maxCount = Math.max(consecutiveCount,maxCount);

                }else{
                    consecutiveCount = 0;
                }
            }
            return maxCount;
        }


}
